package com.shopee.app.util;

import android.os.Build;
import com.garena.android.appkit.d.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ba {
    public static boolean a() {
        try {
            return b() || c() || d();
        } catch (Exception e2) {
            a.a(e2);
            return false;
        }
    }

    private static boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean c() {
        for (String file : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean d() {
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
                if (exec != null) {
                    exec.destroy();
                }
                return true;
            }
            if (exec != null) {
                exec.destroy();
            }
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }
}
