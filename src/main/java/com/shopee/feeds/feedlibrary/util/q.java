package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import java.io.File;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static String f28360a = "picture_cache";

    public static String a(Context context, String str) {
        return context.getDir("images", 0).getPath() + File.separator + str;
    }

    public static String b(Context context, String str) {
        String str2 = context.getDir("images", 0).getPath() + File.separator + "feeds";
        if (!new File(str2).exists()) {
            new File(str2).mkdirs();
        }
        return str2 + File.separator + str;
    }

    public static String c(Context context, String str) {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "feeds";
        k.e(str2);
        return str2 + File.separator + str;
    }

    public static String a(String str) {
        if (str.startsWith("htts://") || str.startsWith("https://") || str.startsWith("file://")) {
            return str;
        }
        return "file://" + str;
    }

    public static String b(String str) {
        if (!d.a(str)) {
            return str.indexOf("file://") == 0 ? str.substring(7, str.length()) : str;
        }
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0095, code lost:
        r10 = null;
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File a(java.io.File r9, java.lang.String r10) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r3 = "mounted"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r2 == 0) goto L_0x0087
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r3 = android.os.Environment.DIRECTORY_DCIM     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.io.File r3 = android.os.Environment.getExternalStoragePublicDirectory(r3)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r4 = "FeedsAndroid"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r3 != 0) goto L_0x0025
            r2.mkdirs()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            goto L_0x0031
        L_0x0025:
            boolean r3 = r2.isFile()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r3 == 0) goto L_0x0031
            r2.delete()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r2.mkdirs()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
        L_0x0031:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r4.<init>()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r5 = "feeds_save_"
            r4.append(r5)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.util.UUID r5 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r4.append(r5)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r4.append(r10)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r10 = r4.toString()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r3.<init>(r2, r10)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r3.createNewFile()     // Catch:{ Exception -> 0x0083, all -> 0x0091 }
            e.u r10 = e.n.b((java.io.File) r3)     // Catch:{ Exception -> 0x0083, all -> 0x0091 }
            e.d r10 = e.n.a((e.u) r10)     // Catch:{ Exception -> 0x0083, all -> 0x0091 }
            e.v r9 = e.n.a((java.io.File) r9)     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            e.e r9 = e.n.a((e.v) r9)     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            long r4 = r10.a(r9)     // Catch:{ Exception -> 0x0078, all -> 0x0074 }
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x008a
            r10.flush()     // Catch:{ Exception -> 0x0078, all -> 0x0074 }
            r1 = 1
            goto L_0x008a
        L_0x0074:
            r0 = move-exception
            r2 = r9
            r9 = r0
            goto L_0x00a6
        L_0x0078:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
            goto L_0x0098
        L_0x007d:
            r9 = move-exception
            r2 = r0
            goto L_0x00a6
        L_0x0080:
            r9 = move-exception
            r2 = r0
            goto L_0x0098
        L_0x0083:
            r9 = move-exception
            r10 = r0
            r2 = r10
            goto L_0x0098
        L_0x0087:
            r9 = r0
            r10 = r9
            r3 = r10
        L_0x008a:
            com.shopee.feeds.feedlibrary.util.k.a((java.io.Closeable) r10)
            com.shopee.feeds.feedlibrary.util.k.a((java.io.Closeable) r9)
            goto L_0x00a1
        L_0x0091:
            r9 = move-exception
            r2 = r0
            goto L_0x00a7
        L_0x0094:
            r9 = move-exception
            r10 = r0
            r2 = r10
            r3 = r2
        L_0x0098:
            r9.printStackTrace()     // Catch:{ all -> 0x00a5 }
            com.shopee.feeds.feedlibrary.util.k.a((java.io.Closeable) r10)
            com.shopee.feeds.feedlibrary.util.k.a((java.io.Closeable) r2)
        L_0x00a1:
            if (r1 == 0) goto L_0x00a4
            r0 = r3
        L_0x00a4:
            return r0
        L_0x00a5:
            r9 = move-exception
        L_0x00a6:
            r0 = r10
        L_0x00a7:
            com.shopee.feeds.feedlibrary.util.k.a((java.io.Closeable) r0)
            com.shopee.feeds.feedlibrary.util.k.a((java.io.Closeable) r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.util.q.a(java.io.File, java.lang.String):java.io.File");
    }

    public static int a(Bitmap bitmap) {
        int i;
        if (Build.VERSION.SDK_INT >= 19) {
            i = bitmap.getAllocationByteCount();
        } else if (Build.VERSION.SDK_INT >= 12) {
            i = bitmap.getByteCount();
        } else {
            i = bitmap.getHeight() * bitmap.getRowBytes();
        }
        return i / 1000;
    }
}
