package com.tencent.liteav.basic.module;

public class TXCStatus {
    private static native double nativeStatusGetDoubleValue(String str, int i, int i2);

    private static native long nativeStatusGetIntValue(String str, int i, int i2);

    private static native String nativeStatusGetStrValue(String str, int i, int i2);

    private static native boolean nativeStatusSetDoubleValue(String str, int i, int i2, double d2);

    private static native boolean nativeStatusSetIntValue(String str, int i, int i2, long j);

    private static native boolean nativeStatusSetStrValue(String str, int i, int i2, String str2);

    private static native void nativeStatusStartRecord(String str);

    private static native void nativeStatusStopRecord(String str);

    public static void a(String str) {
        nativeStatusStartRecord(str);
    }

    public static void b(String str) {
        nativeStatusStopRecord(str);
    }

    public static boolean a(String str, int i, Object obj) {
        return a(str, i, 0, obj);
    }

    public static boolean a(String str, int i, int i2, Object obj) {
        if (str == null || str.length() == 0 || obj == null) {
            return false;
        }
        if (obj instanceof Double) {
            return nativeStatusSetDoubleValue(str, i, i2, ((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return nativeStatusSetStrValue(str, i, i2, (String) obj);
        }
        if (obj instanceof Long) {
            return nativeStatusSetIntValue(str, i, i2, ((Long) obj).longValue());
        }
        return nativeStatusSetIntValue(str, i, i2, (long) ((Integer) obj).intValue());
    }

    public static long a(String str, int i) {
        return a(str, i, 0);
    }

    public static String b(String str, int i) {
        return b(str, i, 0);
    }

    public static int c(String str, int i) {
        return c(str, i, 0);
    }

    public static double d(String str, int i) {
        return d(str, i, 0);
    }

    public static long a(String str, int i, int i2) {
        return nativeStatusGetIntValue(str, i, i2);
    }

    public static String b(String str, int i, int i2) {
        return nativeStatusGetStrValue(str, i, i2);
    }

    public static int c(String str, int i, int i2) {
        return (int) nativeStatusGetIntValue(str, i, i2);
    }

    public static double d(String str, int i, int i2) {
        return nativeStatusGetDoubleValue(str, i, i2);
    }
}
