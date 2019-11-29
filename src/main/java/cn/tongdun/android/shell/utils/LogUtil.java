package cn.tongdun.android.shell.utils;

import android.util.Log;

public class LogUtil {
    public static boolean D = false;
    public static final boolean DEV = false;
    public static boolean E = false;
    public static boolean I = false;
    private static final String TAG = linkxxxxx("0c2f4f3a442d53", 107);
    public static final int Tag = 77777777;

    public static native byte[] Logdata();

    public static void dev(String str) {
    }

    public static void info(boolean z) {
        I = z;
    }

    public static void debug(boolean z) {
        D = z;
    }

    public static void error(boolean z) {
        E = z;
    }

    public static void openLog() {
        D = true;
        I = true;
        E = true;
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void i(String str, String str2) {
        if (I) {
            Log.i(str, str2);
        }
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void d(String str, String str2) {
        if (D) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, Throwable th) {
        Log.e(TAG, str);
        if (E) {
            th.printStackTrace();
        }
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void e(String str, String str2) {
        if (E) {
            Log.e(str, str2);
        }
    }

    public static void dev(String str, Object... objArr) {
        String.format(str, objArr);
    }

    public static void err(String str) {
        Log.e(TAG, str);
    }

    public static void info(String str) {
        Log.i(TAG, str);
    }

    public static String linkxxxxx(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 84);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 88);
            byte b3 = bArr[0];
            int i4 = 1;
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
