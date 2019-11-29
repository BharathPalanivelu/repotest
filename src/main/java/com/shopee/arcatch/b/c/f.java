package com.shopee.arcatch.b.c;

import android.os.Build;
import android.os.Environment;
import java.io.File;

public class f {
    public static String a() {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Shopee Recordings";
        if ("vivo".equalsIgnoreCase(Build.BRAND)) {
            String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "相机";
            if (new File(str2).exists()) {
                return str2;
            }
            return str;
        } else if (!"oppo".equalsIgnoreCase(Build.BRAND)) {
            return str;
        } else {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "Camera";
        }
    }
}
