package com.tencent.qalsdk.core;

import android.content.Context;
import android.os.Environment;
import com.tencent.qalsdk.util.QLog;
import java.io.File;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f32167a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static String f32168b = (Environment.getExternalStorageDirectory().getPath() + "/qalsdk/files");

    public static synchronized String a(Context context) {
        String str;
        synchronized (b.class) {
            try {
                File filesDir = context.getFilesDir();
                if (filesDir == null) {
                    File cacheDir = context.getCacheDir();
                    if (cacheDir == null) {
                        if (QLog.isColorLevel()) {
                            QLog.w("MSF.C.CoreUtil", 2, "load cache dir is null");
                        }
                        str = null;
                    } else {
                        str = cacheDir.getAbsolutePath();
                        int lastIndexOf = str.lastIndexOf(47);
                        if (lastIndexOf != -1) {
                            str = str.substring(0, lastIndexOf) + "/files/";
                        }
                    }
                } else {
                    str = filesDir.getAbsolutePath();
                }
                if (str == null) {
                    str = f32168b;
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } else {
                    File file2 = new File(str);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file2.exists() || !file2.canWrite()) {
                        str = f32168b;
                        new File(str).mkdirs();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.CoreUtil", 2, "load save root dir is " + str);
                }
            } catch (Throwable th) {
                if (QLog.isColorLevel()) {
                    QLog.w("MSF.C.CoreUtil", 2, "getSaveRootPath error ", th);
                }
                return null;
            }
        }
        return str;
    }

    public static int b(Context context) {
        if (f32167a == -1 && context != null) {
            try {
                f32167a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return f32167a;
    }
}
