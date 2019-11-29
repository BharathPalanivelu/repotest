package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.c.b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f28308a = "LogToFile";

    /* renamed from: b  reason: collision with root package name */
    private static String f28309b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f28310c = false;

    /* renamed from: d  reason: collision with root package name */
    private static SimpleDateFormat f28311d = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");

    /* renamed from: e  reason: collision with root package name */
    private static SimpleDateFormat f28312e = new SimpleDateFormat("yyyy-MM-dd_HH");

    /* renamed from: f  reason: collision with root package name */
    private static Date f28313f = new Date();

    /* renamed from: g  reason: collision with root package name */
    private static HandlerThread f28314g = new HandlerThread("handlerThread");
    private static Handler h;
    private static String i;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f28315a;

        /* renamed from: b  reason: collision with root package name */
        public String f28316b;

        /* renamed from: c  reason: collision with root package name */
        public String f28317c = null;

        public a(String str, String str2) {
            this.f28315a = str;
            this.f28316b = str2;
        }

        public a(String str, String str2, String str3) {
            this.f28315a = str;
            this.f28316b = str2;
            this.f28317c = str3;
        }
    }

    public static void a(String str, String str2) {
        com.garena.android.appkit.d.a.b("%s", str + "," + str2);
        String e2 = b.e();
        if (com.garena.android.appkit.tools.b.e(c.g.env_test).equals(e2) || com.garena.android.appkit.tools.b.e(c.g.env_uat).equals(e2)) {
            a(com.shopee.feeds.feedlibrary.b.b().c());
            Message obtain = Message.obtain();
            obtain.obj = new a(str, str2, str);
            h.sendMessage(obtain);
        }
    }

    public static void b(String str, String str2) {
        com.garena.android.appkit.d.a.b("%s", str + "," + str2);
        String e2 = b.e();
        if (com.garena.android.appkit.tools.b.e(c.g.env_test).equals(e2) || com.garena.android.appkit.tools.b.e(c.g.env_uat).equals(e2)) {
            a(com.shopee.feeds.feedlibrary.b.b().c());
            Message obtain = Message.obtain();
            obtain.obj = new a(str, str2);
            h.sendMessage(obtain);
        }
    }

    private static synchronized void a(Context context) {
        synchronized (h.class) {
            if (f28309b == null) {
                f28309b = b(context) + "/Logs";
            }
            if (i == null) {
                i = f28309b + "/log_" + f28311d.format(new Date()) + ".log";
            }
            f28310c = true;
            if (h == null) {
                f28314g.start();
                h = new Handler(f28314g.getLooper()) {
                    public void handleMessage(Message message) {
                        super.handleMessage(message);
                        a aVar = (a) message.obj;
                        if (!TextUtils.isEmpty(aVar.f28317c)) {
                            h.b(aVar.f28315a, aVar.f28316b, aVar.f28317c);
                        } else {
                            h.d(aVar.f28315a, aVar.f28316b);
                        }
                    }
                };
            }
        }
    }

    private static String b(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return context.getExternalFilesDir((String) null).getPath();
        }
        return context.getFilesDir().getPath();
    }

    public static String a(String str) {
        return f28309b + File.separator + str + f28312e.format(new Date()) + ".log";
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d A[SYNTHETIC, Splitter:B:24:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077 A[SYNTHETIC, Splitter:B:30:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082 A[SYNTHETIC, Splitter:B:35:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0072=Splitter:B:27:0x0072, B:21:0x0068=Splitter:B:21:0x0068} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = f28309b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.text.SimpleDateFormat r1 = f28311d
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r1 = r1.format(r2)
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            r0.append(r4)
            r0.append(r1)
            r0.append(r5)
            java.lang.String r4 = "\n"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.io.File r5 = new java.io.File
            java.lang.String r0 = f28309b
            r5.<init>(r0)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x0042
            r5.mkdirs()
        L_0x0042:
            r5 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x0067 }
            java.lang.String r1 = i     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x0067 }
            r2 = 1
            r0.<init>(r1, r2)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x0067 }
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x0067 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x0067 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x0067 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x0067 }
            r1.write(r4)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x005f, all -> 0x005c }
            r1.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x005c:
            r4 = move-exception
            r5 = r1
            goto L_0x0080
        L_0x005f:
            r4 = move-exception
            r5 = r1
            goto L_0x0068
        L_0x0062:
            r4 = move-exception
            r5 = r1
            goto L_0x0072
        L_0x0065:
            r4 = move-exception
            goto L_0x0080
        L_0x0067:
            r4 = move-exception
        L_0x0068:
            r4.printStackTrace()     // Catch:{ all -> 0x0065 }
            if (r5 == 0) goto L_0x007f
            r5.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x0071:
            r4 = move-exception
        L_0x0072:
            r4.printStackTrace()     // Catch:{ all -> 0x0065 }
            if (r5 == 0) goto L_0x007f
            r5.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007f:
            return
        L_0x0080:
            if (r5 == 0) goto L_0x008a
            r5.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.util.h.d(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC, Splitter:B:24:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[SYNTHETIC, Splitter:B:30:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084 A[SYNTHETIC, Splitter:B:35:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0074=Splitter:B:27:0x0074, B:21:0x006a=Splitter:B:21:0x006a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r0 = f28309b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.text.SimpleDateFormat r1 = f28311d
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r1 = r1.format(r2)
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            r0.append(r4)
            r0.append(r1)
            r0.append(r5)
            java.lang.String r4 = "\n"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.io.File r5 = new java.io.File
            java.lang.String r0 = f28309b
            r5.<init>(r0)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x0042
            r5.mkdirs()
        L_0x0042:
            r5 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x0069 }
            java.lang.String r6 = a((java.lang.String) r6)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x0069 }
            r1 = 1
            r0.<init>(r6, r1)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x0069 }
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x0069 }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x0069 }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x0069 }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x0069 }
            r6.write(r4)     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0061, all -> 0x005e }
            r6.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x005e:
            r4 = move-exception
            r5 = r6
            goto L_0x0082
        L_0x0061:
            r4 = move-exception
            r5 = r6
            goto L_0x006a
        L_0x0064:
            r4 = move-exception
            r5 = r6
            goto L_0x0074
        L_0x0067:
            r4 = move-exception
            goto L_0x0082
        L_0x0069:
            r4 = move-exception
        L_0x006a:
            r4.printStackTrace()     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x0081
            r5.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x0073:
            r4 = move-exception
        L_0x0074:
            r4.printStackTrace()     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x0081
            r5.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0081:
            return
        L_0x0082:
            if (r5 == 0) goto L_0x008c
            r5.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.util.h.b(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
