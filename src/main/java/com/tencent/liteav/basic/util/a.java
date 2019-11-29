package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class a {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    @TargetApi(18)
    public static long a(StatFs statFs) {
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBytes();
        }
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static boolean a(long j) {
        return a(new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())) > j;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052 A[SYNTHETIC, Splitter:B:26:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r5) {
        /*
            java.lang.String r0 = "IOException occurred. "
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r2 = ""
            r5.<init>(r2)
            boolean r2 = r1.isFile()
            r3 = 0
            if (r2 != 0) goto L_0x0016
            return r3
        L_0x0016:
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0049 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0049 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0049 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0049 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0049 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0049 }
        L_0x0025:
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            if (r2 == 0) goto L_0x002f
            r5.append(r2)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            goto L_0x0025
        L_0x002f:
            r1.close()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r1.close()     // Catch:{ IOException -> 0x003a }
            return r5
        L_0x003a:
            r5 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0, r5)
            throw r1
        L_0x0041:
            r5 = move-exception
            r3 = r1
            goto L_0x0050
        L_0x0044:
            r5 = move-exception
            r3 = r1
            goto L_0x004a
        L_0x0047:
            r5 = move-exception
            goto L_0x0050
        L_0x0049:
            r5 = move-exception
        L_0x004a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0047 }
            r1.<init>(r0, r5)     // Catch:{ all -> 0x0047 }
            throw r1     // Catch:{ all -> 0x0047 }
        L_0x0050:
            if (r3 == 0) goto L_0x005d
            r3.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005d
        L_0x0056:
            r5 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0, r5)
            throw r1
        L_0x005d:
            goto L_0x005f
        L_0x005e:
            throw r5
        L_0x005f:
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.a.b(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c A[SYNTHETIC, Splitter:B:21:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0034 A[Catch:{ Exception -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003f A[SYNTHETIC, Splitter:B:30:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0047 A[Catch:{ Exception -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r2, byte[] r3) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0020 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0020 }
            r1.write(r3)     // Catch:{ Exception -> 0x001d, all -> 0x001a }
            r1.close()     // Catch:{ Exception -> 0x0030 }
            r2.close()     // Catch:{ Exception -> 0x0030 }
            goto L_0x003b
        L_0x001a:
            r3 = move-exception
            r0 = r1
            goto L_0x003d
        L_0x001d:
            r3 = move-exception
            r0 = r1
            goto L_0x0027
        L_0x0020:
            r3 = move-exception
            goto L_0x0027
        L_0x0022:
            r3 = move-exception
            r2 = r0
            goto L_0x003d
        L_0x0025:
            r3 = move-exception
            r2 = r0
        L_0x0027:
            r3.printStackTrace()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0032
        L_0x0030:
            r2 = move-exception
            goto L_0x0038
        L_0x0032:
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ Exception -> 0x0030 }
            goto L_0x003b
        L_0x0038:
            r2.printStackTrace()
        L_0x003b:
            return
        L_0x003c:
            r3 = move-exception
        L_0x003d:
            if (r0 == 0) goto L_0x0045
            r0.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0045
        L_0x0043:
            r2 = move-exception
            goto L_0x004b
        L_0x0045:
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x004e
        L_0x004b:
            r2.printStackTrace()
        L_0x004e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.a.a(java.lang.String, byte[]):void");
    }

    public static boolean a(Context context, String str) {
        try {
            String[] list = context.getAssets().list("");
            for (String equals : list) {
                if (equals.equals(str.trim())) {
                    TXCLog.i("isAssetFileExists", str + " exist");
                    return true;
                }
            }
            TXCLog.i("isAssetFileExists", str + " not exist");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            TXCLog.i("isAssetFileExists", str + " not exist");
            return false;
        }
    }

    public static String b(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            if (inputStream.read(bArr) <= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return "";
            }
            inputStream.close();
            String str2 = new String(bArr, "utf-8");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return str2;
        } catch (IOException e4) {
            e4.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return "";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }
}
