package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

public class o0oo0xx00ooo0oox0xx0 {
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("213073327c35753762", 70);
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("307561363d213c2333243a262d7a6f777b6c76677b70", 24);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("0149393258345934", 60);
    private static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("017153735c745576422450384a4b", 39);
    private static final String x0ox00x0oooo0xxx = o00xxox0x0xoox("016753655c62556042325740", 49);

    public static boolean o00xxox0x0xoox(Context context, String str) {
        String str2;
        if (context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && (str.contains(x0000xo0x0oooooo0) || str.contains(x0ox00x0oooo0xxx))) {
            return true;
        }
        String str3 = Build.BRAND;
        if (str3 != null && str3.length() > 30) {
            str3 = str3.substring(0, 30);
        }
        if (o00xx0xx0ooooo0xx00.equals(str3)) {
            return true;
        }
        if (oo0ooo0o00o0xo.equals(Build.MODEL)) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.GET_TASKS")) {
            StringBuilder sb = new StringBuilder();
            for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(Integer.MAX_VALUE)) {
                String packageName = runningTaskInfo.baseActivity.getPackageName();
                if (sb.length() > 0) {
                    sb.append(o00xxox0x0xoox("7f", 43));
                }
                sb.append(packageName);
            }
            str2 = sb.toString();
        } else {
            str2 = "";
        }
        return !TextUtils.isEmpty(str2) && str2.contains(o00xxox0x0xoox);
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
            byte b2 = (byte) (i ^ 97);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 83);
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
