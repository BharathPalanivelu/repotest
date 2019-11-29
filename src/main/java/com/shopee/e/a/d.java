package com.shopee.e.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.f.a.g;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f27143a;

    public d(Context context) {
        File file = null;
        try {
            file = context.getExternalFilesDir((String) null);
        } catch (Exception e2) {
            Log.e("SZDiskLogStrategy", "exception when get external dir", e2);
        }
        String str = (file == null ? context.getFilesDir() : file).getAbsolutePath() + File.separatorChar + "szlog";
        HandlerThread handlerThread = new HandlerThread("SZFileLogger." + str);
        handlerThread.start();
        this.f27143a = new a(handlerThread.getLooper(), a(context), str);
    }

    public void a(int i, String str, String str2) {
        Handler handler = this.f27143a;
        handler.sendMessage(handler.obtainMessage(i, str2));
    }

    private String a(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "main";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "main";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                String str = next.processName;
                if (str != null) {
                    String[] split = str.split(":");
                    if (split.length >= 2) {
                        return split[split.length - 1];
                    }
                } else {
                    continue;
                }
            }
        }
        return "main";
    }

    static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final String f27144a;

        /* renamed from: b  reason: collision with root package name */
        private SimpleDateFormat f27145b = new SimpleDateFormat("yyyyMMdd", Locale.UK);

        /* renamed from: c  reason: collision with root package name */
        private Date f27146c = new Date();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f27147d;

        a(Looper looper, String str, String str2) {
            super(looper);
            this.f27144a = str2;
            this.f27147d = str;
        }

        public void handleMessage(Message message) {
            FileWriter fileWriter;
            String str = (String) message.obj;
            try {
                fileWriter = new FileWriter(a(this.f27144a, "logs"), true);
                try {
                    a(fileWriter, str);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                fileWriter = null;
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException unused3) {
                    }
                }
            }
        }

        private void a(FileWriter fileWriter, String str) throws IOException {
            fileWriter.append(str);
        }

        private File a(String str, final String str2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f27146c.setTime(System.currentTimeMillis());
            File file2 = new File(file, String.format("%s_%s_%s.csv", new Object[]{str2, this.f27147d, this.f27145b.format(this.f27146c)}));
            if (!file2.exists()) {
                File[] listFiles = file.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        return file.isFile() && file.getName().startsWith(str2) && file.getName().contains(a.this.f27147d);
                    }
                });
                ArrayList arrayList = new ArrayList(listFiles.length);
                Collections.addAll(arrayList, listFiles);
                Collections.sort(arrayList);
                while (arrayList.size() >= 7) {
                    ((File) arrayList.remove(0)).delete();
                }
            }
            return file2;
        }
    }
}
