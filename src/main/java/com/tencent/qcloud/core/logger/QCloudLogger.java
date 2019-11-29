package com.tencent.qcloud.core.logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class QCloudLogger {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final List<LogAdapter> logAdapters = new ArrayList();
    private static final AndroidLogcatAdapter logcatAdapter = new AndroidLogcatAdapter();

    static {
        logAdapters.add(logcatAdapter);
    }

    private QCloudLogger() {
    }

    public static void addAdapter(LogAdapter logAdapter) {
        if (logAdapter != null) {
            synchronized (LogAdapter.class) {
                boolean z = false;
                Iterator<LogAdapter> it = logAdapters.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getClass().equals(logAdapter.getClass())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    logAdapters.add(logAdapter);
                }
            }
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        print(2, str, (Throwable) null, str2, objArr);
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        print(2, str, th, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        print(3, str, (Throwable) null, str2, objArr);
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        print(3, str, th, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        print(4, str, (Throwable) null, str2, objArr);
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        print(4, str, th, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        print(5, str, (Throwable) null, str2, objArr);
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        print(5, str, th, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        print(6, str, (Throwable) null, str2, objArr);
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        print(6, str, th, str2, objArr);
    }

    public static boolean isLoggableOnLogcat(int i, String str) {
        return logcatAdapter.isLoggable(i, str);
    }

    private static void print(int i, String str, Throwable th, String str2, Object... objArr) {
        try {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
        } catch (Exception unused) {
            str2 = str2 + ": !!!! Log format exception: ";
        }
        synchronized (LogAdapter.class) {
            for (LogAdapter next : logAdapters) {
                if (next.isLoggable(i, str)) {
                    next.log(i, str, str2, th);
                }
            }
        }
    }
}
