package com.tencent.imsdk.log;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMLogListener;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class QLogImpl {
    /* access modifiers changed from: private */
    public static final int[] INTERVAL_RETRY_INIT = {1, 2, 4, 8, 16, 29};
    private static final String MEMTag = "appMemory";
    public static final String TAG_REPORTLEVEL_COLORUSER = "W";
    public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
    public static final String TAG_REPORTLEVEL_USER = "E";
    private static int UIN_REPORTLOG_LEVEL = 4;
    protected static int _DEFAULT_REPORTLOG_LEVEL = 4;
    public static Runnable acutualInitRunnable = new ae();
    static long colorLogTime = 0;
    static HashSet<String> colorTags = new HashSet<>();
    protected static Object formatterLock = new Object();
    /* access modifiers changed from: private */
    public static AtomicBoolean isInitLogFileDone = new AtomicBoolean(false);
    protected static boolean isLogToFile = true;
    private static AtomicBoolean isPreExceptionEnospc = new AtomicBoolean(false);
    private static long lastPrintMemeoryTime = 0;
    static long lastWriterErrorTime = 0;
    static final ReentrantLock lock = new ReentrantLock();
    static MyLinkedBlockingDeque<String> logDeque = new MyLinkedBlockingDeque<>(15000);
    private static String logPath = "";
    private static String logTime = "";
    /* access modifiers changed from: private */
    public static int myProcessId = 0;
    private static long nextHourTime = 0;
    private static long nextSecondMinuteTime = 0;
    static String nowUsedFile = "";
    /* access modifiers changed from: private */
    public static String packageName = "";
    /* access modifiers changed from: private */
    public static String processName = "";
    /* access modifiers changed from: private */
    public static Handler retryInitHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static AtomicInteger retryInitTimes = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public static volatile Context sContext = null;
    private static TIMLogListener sdkLogLister = null;
    static Thread t = new ag();
    private static final String tag = "MSF.D.QLogImpl";
    private static FileWriter writer;

    public static class LogFile extends File {
        public LogFile(File file, String str) {
            super(file, str);
        }

        public LogFile(String str) {
            super(str);
        }
    }

    protected static class QLogItem {
        String level;
        String msg;
        String tag;
        Throwable tr;

        public QLogItem(String str, String str2, String str3, Throwable th) {
            this.tag = str;
            this.level = str2;
            this.msg = str3;
            this.tr = th;
        }
    }

    private static void addLogItem(String str, int i, String str2, Throwable th) {
        if (IMMsfCoreProxy.get().getMode() != 1 && isLogToFile) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= nextSecondMinuteTime) {
                checkNextMinuteTime(currentTimeMillis);
            }
            long j = colorLogTime;
            if (j != 0 && currentTimeMillis - j > 1800000) {
                colorLogTime = 0;
                colorTags.clear();
            }
            String reportLevel = getReportLevel(i);
            long id = Thread.currentThread().getId();
            String str3 = logTime + "|" + processName + "[" + myProcessId + "]|" + String.valueOf(id) + "|" + reportLevel + "|" + str + "|" + str2 + "\n";
            if (th != null) {
                str3 = str3 + "\n" + Log.getStackTraceString(th) + "\n";
            }
            if (addLogToCache(str3) && IMMsfCoreProxy.get().getContext() != null && System.currentTimeMillis() - lastPrintMemeoryTime > 180000) {
                lastPrintMemeoryTime = System.currentTimeMillis();
                printMemStatus();
            }
        }
    }

    private static boolean addLogToCache(String str) {
        try {
            logDeque.add(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static synchronized void checkNextMinuteTime(long j) {
        synchronized (QLogImpl.class) {
            if (j > nextSecondMinuteTime) {
                synchronized (formatterLock) {
                    logTime = MsfSdkUtils.timeFormatter.format(Long.valueOf(j));
                    nextSecondMinuteTime += 1000;
                }
            }
        }
    }

    public static void d(String str, int i, String str2) {
        d(str, i, str2, (Throwable) null);
    }

    public static void d(String str, int i, String str2, Throwable th) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            if (IMMsfCoreProxy.get().getSdkConfig() == null || IMMsfCoreProxy.get().getSdkConfig().isLogPrintEnabled()) {
                if (th == null) {
                    Log.d(str, "[" + getReportLevel(i) + "]" + str2);
                } else {
                    Log.d(str, "[" + getReportLevel(i) + "]" + str2, th);
                }
            }
            addLogItem(str, i, str2, th);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(4, str, str2);
            }
        }
    }

    public static void dfile(String str, int i, String str2) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            addLogItem(str, i, str2, (Throwable) null);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(4, str, str2);
            }
        }
    }

    public static void e(String str, int i, String str2) {
        e(str, i, str2, (Throwable) null);
    }

    public static void e(String str, int i, String str2, Throwable th) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            if (IMMsfCoreProxy.get().getSdkConfig() == null || IMMsfCoreProxy.get().getSdkConfig().isLogPrintEnabled()) {
                if (th == null) {
                    Log.e(str, "[" + getReportLevel(i) + "]" + str2);
                } else {
                    Log.e(str, "[" + getReportLevel(i) + "]" + str2, th);
                }
            }
            addLogItem(str, i, str2, th);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(1, str, str2);
            }
        }
    }

    public static void efile(String str, int i, String str2) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            addLogItem(str, i, str2, (Throwable) null);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(1, str, str2);
            }
        }
    }

    public static String getLogFileName(String str) {
        return processName.replace(":", "_") + "." + str + ".log";
    }

    public static String getLogPath() {
        return logPath;
    }

    public static String getReportLevel(int i) {
        return i != 1 ? i != 2 ? i != 4 ? "E" : "D" : "W" : "E";
    }

    private static String getThisHour(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH", Locale.CHINA);
        logTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA).format(Long.valueOf(j));
        String format = simpleDateFormat.format(instance.getTime());
        setNextSecond(instance);
        setNextHour(instance);
        return format;
    }

    public static void i(String str, int i, String str2) {
        i(str, i, str2, (Throwable) null);
    }

    public static void i(String str, int i, String str2, Throwable th) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            if (IMMsfCoreProxy.get().getSdkConfig() == null || IMMsfCoreProxy.get().getSdkConfig().isLogPrintEnabled()) {
                if (th == null) {
                    Log.i(str, "[" + getReportLevel(i) + "]" + str2);
                } else {
                    Log.i(str, "[" + getReportLevel(i) + "]" + str2, th);
                }
            }
            addLogItem(str, i, str2, th);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(3, str, str2);
            }
        }
    }

    public static void ifile(String str, int i, String str2) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            addLogItem(str, i, str2, (Throwable) null);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(3, str, str2);
            }
        }
    }

    public static void init(Context context) {
        sContext = context.getApplicationContext();
    }

    static synchronized void initLogFile(long j) throws IOException {
        File file;
        FileWriter fileWriter;
        synchronized (QLogImpl.class) {
            logPath = Environment.getExternalStorageDirectory().getPath() + "/tencent/imsdklogs/" + packageName.replace(".", Constants.URL_PATH_DELIMITER) + Constants.URL_PATH_DELIMITER;
            File file2 = new File(logPath);
            if (!file2.exists() && !file2.mkdirs()) {
                QLog.d(tag, 1, "create imsdklogs folder failed");
            }
            nowUsedFile = logPath + getLogFileName(getThisHour(j));
            try {
                file = new File(nowUsedFile);
                try {
                    if (!file.exists()) {
                        boolean createNewFile = file.createNewFile();
                        writeAppVersion();
                        if (writer != null) {
                            FileWriter fileWriter2 = writer;
                            fileWriter2.write(logTime + "|" + processName + "|D|MSF.D.QLogImpl" + "|" + Build.MODEL + SQLBuilder.BLANK + Build.VERSION.RELEASE + " create newLogFile " + file.getName() + SQLBuilder.BLANK + createNewFile + "\n");
                            fileWriter = writer;
                        }
                        writer = new FileWriter(file, true);
                        writeAppVersion();
                    } else {
                        writeAppVersion();
                        if (writer != null) {
                            FileWriter fileWriter3 = writer;
                            fileWriter3.write(logTime + "|" + processName + "|E|MSF.D.QLogImpl" + "|" + Build.MODEL + SQLBuilder.BLANK + Build.VERSION.RELEASE + "|newLogFile " + file.getName() + " is existed.\n");
                            fileWriter = writer;
                        }
                        writer = new FileWriter(file, true);
                        writeAppVersion();
                    }
                    fileWriter.flush();
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    writer = new FileWriter(file, true);
                    writeAppVersion();
                }
            } catch (Throwable th2) {
                th = th2;
                file = file2;
                th.printStackTrace();
                writer = new FileWriter(file, true);
                writeAppVersion();
            }
            writer = new FileWriter(file, true);
            writeAppVersion();
        }
    }

    private static boolean insertLogToCacheHead(String str) {
        try {
            logDeque.addFirst(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isColorUser() {
        return UIN_REPORTLOG_LEVEL > 1;
    }

    public static boolean isDEVELOPER() {
        return UIN_REPORTLOG_LEVEL >= 4;
    }

    public static void p(String str, String str2) {
        if (IMMsfCoreProxy.get().getSdkConfig() == null || IMMsfCoreProxy.get().getSdkConfig().isLogPrintEnabled()) {
            Log.d(tag, "[s]" + str2);
        }
    }

    private static void printMemStatus() {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) IMMsfCoreProxy.get().getContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            if (QLog.isColorLevel()) {
                d(MEMTag, 2, "availMem:" + ((memoryInfo.availMem / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M lowThreshold:" + ((memoryInfo.threshold / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M");
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                d(MEMTag, 2, "printMemError " + e2, e2);
            }
        }
    }

    private static void setNextHour(Calendar calendar) {
        calendar.add(11, 1);
        calendar.set(12, 0);
        calendar.set(13, 0);
        nextHourTime = calendar.getTimeInMillis();
    }

    private static void setNextSecond(Calendar calendar) {
        calendar.set(14, 0);
        nextSecondMinuteTime = calendar.getTimeInMillis() + 1000;
    }

    public static void setSdkLogListener(TIMLogListener tIMLogListener) {
        sdkLogLister = tIMLogListener;
    }

    public static void w(String str, int i, String str2) {
        w(str, i, str2, (Throwable) null);
    }

    public static void w(String str, int i, String str2, Throwable th) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            if (IMMsfCoreProxy.get().getSdkConfig() == null || IMMsfCoreProxy.get().getSdkConfig().isLogPrintEnabled()) {
                if (th == null) {
                    Log.w(str, "[" + getReportLevel(i) + "]" + str2);
                } else {
                    Log.w(str, "[" + getReportLevel(i) + "]" + str2, th);
                }
            }
            addLogItem(str, i, str2, th);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(2, str, str2);
            }
        }
    }

    public static void wfile(String str, int i, String str2) {
        if (UIN_REPORTLOG_LEVEL >= i || colorTags.contains(str)) {
            addLogItem(str, i, str2, (Throwable) null);
            TIMLogListener tIMLogListener = sdkLogLister;
            if (tIMLogListener != null) {
                tIMLogListener.log(2, str, str2);
            }
        }
    }

    private static void writeAppVersion() throws IOException {
        if (writer != null && !"".equals(QLog.sBuildNumber)) {
            FileWriter fileWriter = writer;
            fileWriter.write(logTime + "|" + processName + "|D||QQ_Version: " + QLog.sBuildNumber + IOUtils.LINE_SEPARATOR_WINDOWS);
            writer.flush();
        }
    }

    /* access modifiers changed from: private */
    public static void writeLogToFile(String str) {
        try {
            if (!isLogToFile) {
                return;
            }
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (writer == null) {
                    System.out.println("can not write log.");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (lastWriterErrorTime != 0) {
                        if (currentTimeMillis - lastWriterErrorTime > 60000) {
                            initLogFile(System.currentTimeMillis());
                        }
                    }
                    lastWriterErrorTime = currentTimeMillis;
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 > nextHourTime) {
                        initLogFile(currentTimeMillis2);
                    }
                    if (lock.tryLock()) {
                        writer.write(str);
                        writer.flush();
                        lock.unlock();
                    } else if (!insertLogToCacheHead(str)) {
                        Log.d("QLogImpl", "insertLogToCacheHead failed!");
                    }
                }
                isPreExceptionEnospc.compareAndSet(true, false);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            if (!(th instanceof IOException) || !th.getMessage().contains("ENOSPC")) {
                isPreExceptionEnospc.compareAndSet(true, false);
                th.printStackTrace();
                try {
                    initLogFile(System.currentTimeMillis());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } else if (isPreExceptionEnospc.compareAndSet(false, true)) {
                th.printStackTrace();
            }
        }
    }
}
