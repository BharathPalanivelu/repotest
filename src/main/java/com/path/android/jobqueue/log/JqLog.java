package com.path.android.jobqueue.log;

public class JqLog {
    private static CustomLogger customLogger = new CustomLogger() {
        public void d(String str, Object... objArr) {
        }

        public void e(String str, Object... objArr) {
        }

        public void e(Throwable th, String str, Object... objArr) {
        }

        public boolean isDebugEnabled() {
            return false;
        }
    };

    public static void setCustomLogger(CustomLogger customLogger2) {
        customLogger = customLogger2;
    }

    public static boolean isDebugEnabled() {
        return customLogger.isDebugEnabled();
    }

    public static void d(String str, Object... objArr) {
        customLogger.d(str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        customLogger.e(th, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        customLogger.e(str, objArr);
    }
}
