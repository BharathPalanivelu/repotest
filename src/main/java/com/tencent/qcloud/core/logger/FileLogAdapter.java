package com.tencent.qcloud.core.logger;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FileLogAdapter implements LogAdapter {
    private static final long BUFFER_SIZE = 32768;
    private static final String LOG_DIR = "QCloudLogs";
    private static final long LOG_FLUSH_DURATION = 10000;
    private static final int MAX_FILE_COUNT = 30;
    private static final int MAX_FILE_SIZE = 32768;
    private static final int MSG_DELETE_FILE = 2;
    private static final int MSG_FLUSH_ALL = 0;
    private static final int MSG_FLUSH_CONTENT = 1;
    private static final byte[] object = new byte[0];
    /* access modifiers changed from: private */
    public String alias;
    private List<FileLogItem> bufferRecord;
    private FileFilter fileFilter;
    private Handler handler;
    private String logRootDir;
    private volatile long mBufferSize;
    private int minPriority;

    public FileLogAdapter(Context context, String str) {
        this(context, str, 4);
    }

    public FileLogAdapter(Context context, String str, int i) {
        this.fileFilter = new FileFilter() {
            public boolean accept(File file) {
                String name = file.getName();
                if (name.endsWith("." + FileLogAdapter.this.alias + ".log") && FileLogAdapter.this.getIndexFromFile(file) != -1) {
                    return true;
                }
                return false;
            }
        };
        this.bufferRecord = Collections.synchronizedList(new ArrayList());
        this.mBufferSize = 0;
        this.alias = str;
        this.minPriority = i;
        this.logRootDir = context.getExternalCacheDir() + File.separator + LOG_DIR;
        HandlerThread handlerThread = new HandlerThread("log_handlerThread", 1);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    FileLogAdapter.this.flush();
                    sendEmptyMessageDelayed(0, FileLogAdapter.LOG_FLUSH_DURATION);
                } else if (i == 1) {
                    FileLogAdapter.this.input();
                }
            }
        };
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 0;
        this.handler.sendMessage(obtainMessage);
    }

    public boolean isLoggable(int i, String str) {
        return i >= this.minPriority;
    }

    public synchronized void log(int i, String str, String str2, Throwable th) {
        FileLogItem fileLogItem = new FileLogItem(str, i, str2, th);
        this.bufferRecord.add(fileLogItem);
        this.mBufferSize += fileLogItem.getLength();
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 500);
    }

    private String getTodayDate() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    private String getLongDate(long j) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(j));
    }

    private File getLogFile(long j) {
        String str = this.logRootDir + File.separator + getLongDate(j);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            return new File(str, "1." + this.alias + ".log");
        }
        File[] listFiles = file.listFiles(this.fileFilter);
        if (listFiles == null || listFiles.length == 0) {
            return new File(str, "1." + this.alias + ".log");
        }
        Arrays.sort(listFiles, new Comparator<File>() {
            public int compare(File file, File file2) {
                return FileLogAdapter.this.getIndexFromFile(file) - FileLogAdapter.this.getIndexFromFile(file2);
            }
        });
        File file2 = listFiles[listFiles.length - 1];
        if (file2.length() > 32768) {
            file2 = new File(str, "" + (getIndexFromFile(file2) + 1) + "." + this.alias + ".log");
        }
        int length = listFiles.length + 1;
        for (int i = 0; i < length - 30; i++) {
            listFiles[i].delete();
        }
        return file2;
    }

    /* access modifiers changed from: private */
    public int getIndexFromFile(File file) {
        try {
            String name = file.getName();
            return Integer.valueOf(name.substring(0, name.indexOf(46))).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[SYNTHETIC, Splitter:B:32:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f A[SYNTHETIC, Splitter:B:39:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0069 A[SYNTHETIC, Splitter:B:46:0x0069] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x005a=Splitter:B:36:0x005a, B:29:0x004e=Splitter:B:29:0x004e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void write(java.util.List<com.tencent.qcloud.core.logger.FileLogItem> r6) {
        /*
            r5 = this;
            byte[] r0 = object
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r6 = move-exception
            goto L_0x0072
        L_0x000a:
            r1 = 0
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ FileNotFoundException -> 0x0059, IOException -> 0x004d }
            java.io.File r2 = r5.getLogFile(r2)     // Catch:{ FileNotFoundException -> 0x0059, IOException -> 0x004d }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0059, IOException -> 0x004d }
            r4 = 1
            r3.<init>(r2, r4)     // Catch:{ FileNotFoundException -> 0x0059, IOException -> 0x004d }
            r1 = 0
        L_0x001a:
            int r2 = r6.size()     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0044, all -> 0x0042 }
            if (r1 >= r2) goto L_0x0036
            java.lang.Object r2 = r6.get(r1)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0044, all -> 0x0042 }
            com.tencent.qcloud.core.logger.FileLogItem r2 = (com.tencent.qcloud.core.logger.FileLogItem) r2     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0044, all -> 0x0042 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0044, all -> 0x0042 }
            java.lang.String r4 = "UTF-8"
            byte[] r2 = r2.getBytes(r4)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0044, all -> 0x0042 }
            r3.write(r2)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0044, all -> 0x0042 }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x0036:
            r3.flush()     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0044, all -> 0x0042 }
            r3.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0065
        L_0x003d:
            r6 = move-exception
        L_0x003e:
            r6.printStackTrace()     // Catch:{ all -> 0x0007 }
            goto L_0x0065
        L_0x0042:
            r6 = move-exception
            goto L_0x0067
        L_0x0044:
            r6 = move-exception
            r1 = r3
            goto L_0x004e
        L_0x0047:
            r6 = move-exception
            r1 = r3
            goto L_0x005a
        L_0x004a:
            r6 = move-exception
            r3 = r1
            goto L_0x0067
        L_0x004d:
            r6 = move-exception
        L_0x004e:
            r6.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0065
        L_0x0057:
            r6 = move-exception
            goto L_0x003e
        L_0x0059:
            r6 = move-exception
        L_0x005a:
            r6.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0065
        L_0x0063:
            r6 = move-exception
            goto L_0x003e
        L_0x0065:
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x0067:
            if (r3 == 0) goto L_0x0071
            r3.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0007 }
        L_0x0071:
            throw r6     // Catch:{ all -> 0x0007 }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            goto L_0x0075
        L_0x0074:
            throw r6
        L_0x0075:
            goto L_0x0074
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.logger.FileLogAdapter.write(java.util.List):void");
    }

    /* access modifiers changed from: private */
    public synchronized void flush() {
        if (this.mBufferSize > 0) {
            write(this.bufferRecord);
            this.bufferRecord.clear();
            this.mBufferSize = 0;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void input() {
        if (this.mBufferSize > 32768) {
            flush();
        }
    }
}
