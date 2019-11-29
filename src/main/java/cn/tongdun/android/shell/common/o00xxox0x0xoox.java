package cn.tongdun.android.shell.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.tongdun.android.shell.utils.LogUtil;
import java.util.Arrays;

public class o00xxox0x0xoox {
    public static String o00xxox0x0xoox(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(o00xxox0x0xoox("27464340594b4e46524a594b", 13));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String oo0ooo0o00o0xo(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(o00xxox0x0xoox("234b4f555e55405a4c52", 1));
        } catch (Exception e2) {
            LogUtil.err(o00xxox0x0xoox("162e6101500e5c06031c", 101) + CollectorError.catchErr(e2));
            return null;
        }
    }

    public static String o00xx0xx0ooooo0xx00(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            String str = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            return packageName + o00xxox0x0xoox("5d3f", 105) + str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String x0000xo0x0oooooo0(Context context) {
        int myPid = Process.myPid();
        try {
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String x0ox00x0oooo0xxx(Context context) {
        String str;
        if (Build.VERSION.SDK_INT < 21) {
            str = Arrays.toString(new String[]{Build.CPU_ABI, Build.CPU_ABI2});
        } else {
            str = Arrays.toString(Build.SUPPORTED_ABIS);
        }
        String n1 = HelperJNI.n1();
        return Build.BRAND + o00xxox0x0xoox("2920", 122) + Build.MODEL + o00xxox0x0xoox("2969", 51) + Build.VERSION.SDK_INT + o00xxox0x0xoox("297d", 39) + xo00x00xo00(context) + o00xxox0x0xoox("2941", 27) + str + o00xxox0x0xoox("2977", 45) + n1;
    }

    static String xo00x00xo00(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return HelperJNI.simplemd5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 90);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 119);
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
