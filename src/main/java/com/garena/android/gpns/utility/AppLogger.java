package com.garena.android.gpns.utility;

import android.content.Context;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class AppLogger {
    private static final String APP_LOG_FLAG = "GPNS";
    public static boolean RELEASE = false;
    private static final SimpleDateFormat format = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss", Locale.ENGLISH);
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void e(Throwable th) {
        if (!RELEASE) {
            Log.e(APP_LOG_FLAG, th.getMessage(), th);
        }
    }

    public static void i(String str) {
        if (!RELEASE) {
            Log.i(APP_LOG_FLAG, str);
        }
    }

    public static void f(String str) {
        boolean z = RELEASE;
    }

    private static String formatLog(String str) {
        return format.format(new Date()) + ";" + str;
    }

    private static void appendLog(String str) {
        if (mContext != null) {
            File file = new File(mContext.getCacheDir() + "/log_gpns.txt");
            i("cache directory " + mContext.getCacheDir());
            boolean exists = file.exists();
            if (!exists) {
                try {
                    exists = file.createNewFile();
                } catch (IOException e2) {
                    e(e2);
                }
            }
            if (exists) {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                    bufferedWriter.append(str);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (IOException e3) {
                    e(e3);
                }
            }
        }
    }

    public static void d(String str) {
        if (!RELEASE) {
            Log.d(APP_LOG_FLAG, str);
        }
    }

    private AppLogger() {
    }

    public static abstract class NetworkThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread thread, Throwable th) {
            if (!AppLogger.RELEASE) {
                AppLogger.i("NETWORK THREAD CRASH");
                AppLogger.e(th);
            }
        }
    }
}
