package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.content.Context;
import android.os.Build;

public class xoo0xoo0oxo00x0o0 {
    public static boolean o00xxox0x0xoox(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean o00xxox0x0xoox(Context context, String... strArr) {
        if (r0 == 0) {
            return false;
        }
        boolean z = false;
        for (String checkCallingOrSelfPermission : strArr) {
            if (context.checkCallingOrSelfPermission(checkCallingOrSelfPermission) == 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean o00xxox0x0xoox(int i) {
        return Build.VERSION.SDK_INT < i;
    }

    public static boolean oo0ooo0o00o0xo(int i) {
        return Build.VERSION.SDK_INT >= i;
    }
}
