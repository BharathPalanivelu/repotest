package com.shopee.livequiz.g;

import a.h;
import a.k;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.shopee.livequiz.b;
import com.shopee.livequiz.data.bean.PingNetEntity;
import java.util.concurrent.Callable;

public class f {

    public interface a {
        void a();

        void b();
    }

    private static boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b.a().c().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static void a(final String str, final a aVar) {
        if (!a()) {
            aVar.b();
        } else {
            k.a(new Callable<PingNetEntity>() {
                /* renamed from: a */
                public PingNetEntity call() throws Exception {
                    PingNetEntity pingNetEntity = new PingNetEntity();
                    pingNetEntity.host = str;
                    pingNetEntity.f29828c = 5;
                    pingNetEntity.i = 0.2d;
                    pingNetEntity.W = 500;
                    return f.b(pingNetEntity);
                }
            }).a(new h<PingNetEntity, Void>() {
                /* renamed from: a */
                public Void then(k<PingNetEntity> kVar) throws Exception {
                    PingNetEntity f2 = kVar.f();
                    if (f2 == null) {
                        return null;
                    }
                    if (f2.result) {
                        aVar.a();
                        return null;
                    }
                    aVar.b();
                    return null;
                }
            }, k.f377b);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a2 A[SYNTHETIC, Splitter:B:65:0x01a2] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01d3 A[SYNTHETIC, Splitter:B:77:0x01d3] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f8 A[SYNTHETIC, Splitter:B:88:0x01f8] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:59:0x0188=Splitter:B:59:0x0188, B:71:0x01b9=Splitter:B:71:0x01b9} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.shopee.livequiz.data.bean.PingNetEntity b(com.shopee.livequiz.data.bean.PingNetEntity r19) {
        /*
            r1 = r19
            java.lang.String r0 = "exec finished."
            java.lang.String r2 = "exec cmd success:"
            java.lang.String r3 = "exec cmd fail."
            java.lang.String r4 = "ping fail:process is null."
            java.lang.String r5 = "ping exit."
            java.lang.String r6 = "NetworkUtil %s"
            int r7 = r1.f29828c
            r8 = 1
            int r7 = r7 - r8
            int r7 = java.lang.Math.abs(r7)
            double r9 = (double) r7
            double r11 = r1.i
            java.lang.Double.isNaN(r9)
            double r9 = r9 * r11
            r11 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r9 = r9 * r11
            long r13 = r1.W
            double r13 = (double) r13
            java.lang.Double.isNaN(r13)
            double r9 = r9 + r13
            double r9 = r9 / r11
            double r9 = java.lang.Math.ceil(r9)
            int r7 = (int) r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "ping -c "
            r9.append(r10)
            int r10 = r1.f29828c
            r9.append(r10)
            java.lang.String r10 = " -i "
            r9.append(r10)
            double r10 = r1.i
            r9.append(r10)
            java.lang.String r10 = " -W "
            r9.append(r10)
            long r10 = r1.W
            r9.append(r10)
            java.lang.String r10 = " -w "
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = " "
            r9.append(r7)
            java.lang.String r7 = r1.host
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r9 = 0
            r10 = 0
            java.lang.Runtime r11 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x01b5, InterruptedException -> 0x0184, all -> 0x017d }
            java.lang.Process r11 = r11.exec(r7)     // Catch:{ IOException -> 0x01b5, InterruptedException -> 0x0184, all -> 0x017d }
            if (r11 != 0) goto L_0x00a1
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x009d, InterruptedException -> 0x0099, all -> 0x0094 }
            r0[r10] = r4     // Catch:{ IOException -> 0x009d, InterruptedException -> 0x0099, all -> 0x0094 }
            com.garena.android.appkit.d.a.a(r6, r0)     // Catch:{ IOException -> 0x009d, InterruptedException -> 0x0099, all -> 0x0094 }
            java.lang.StringBuffer r0 = r1.resultBuffer     // Catch:{ IOException -> 0x009d, InterruptedException -> 0x0099, all -> 0x0094 }
            a((java.lang.StringBuffer) r0, (java.lang.String) r4)     // Catch:{ IOException -> 0x009d, InterruptedException -> 0x0099, all -> 0x0094 }
            r1.pingTime = r9     // Catch:{ IOException -> 0x009d, InterruptedException -> 0x0099, all -> 0x0094 }
            r1.result = r10     // Catch:{ IOException -> 0x009d, InterruptedException -> 0x0099, all -> 0x0094 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r10] = r5
            com.garena.android.appkit.d.a.e(r6, r0)
            if (r11 == 0) goto L_0x0093
            r11.destroy()
        L_0x0093:
            return r1
        L_0x0094:
            r0 = move-exception
            r1 = r0
            r4 = r9
            goto L_0x01e9
        L_0x0099:
            r0 = move-exception
            r4 = r9
            goto L_0x0176
        L_0x009d:
            r0 = move-exception
            r4 = r9
            goto L_0x017b
        L_0x00a1:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0178, InterruptedException -> 0x0173, all -> 0x016d }
            java.io.InputStreamReader r12 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0178, InterruptedException -> 0x0173, all -> 0x016d }
            java.io.InputStream r13 = r11.getInputStream()     // Catch:{ IOException -> 0x0178, InterruptedException -> 0x0173, all -> 0x016d }
            r12.<init>(r13)     // Catch:{ IOException -> 0x0178, InterruptedException -> 0x0173, all -> 0x016d }
            r4.<init>(r12)     // Catch:{ IOException -> 0x0178, InterruptedException -> 0x0173, all -> 0x016d }
            int r12 = r1.f29828c     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
        L_0x00b1:
            java.lang.String r13 = r4.readLine()     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            if (r13 == 0) goto L_0x00e1
            java.lang.Object[] r14 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r14[r10] = r13     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            com.garena.android.appkit.d.a.e(r6, r14)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.StringBuffer r14 = r1.resultBuffer     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            a((java.lang.StringBuffer) r14, (java.lang.String) r13)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.String r13 = a((java.lang.String) r13)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            if (r13 == 0) goto L_0x00de
            double r14 = b((java.lang.String) r13)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r16 = 0
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x00dc
            long r9 = r1.W     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            double r9 = (double) r9     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            int r18 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r18 > 0) goto L_0x00dc
            int r12 = r12 + -1
        L_0x00dc:
            r1.pingTime = r13     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
        L_0x00de:
            r9 = 0
            r10 = 0
            goto L_0x00b1
        L_0x00e1:
            r11.waitFor()     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            float r9 = (float) r12     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            int r10 = r1.f29828c     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            float r10 = (float) r10     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            float r9 = r9 / r10
            double r9 = (double) r9     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r1.loss = r9     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            double r9 = r1.loss     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r12 = 4596373779801702400(0x3fc99999a0000000, double:0.20000000298023224)
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 > 0) goto L_0x0126
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r9.<init>()     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r9.append(r2)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r9.append(r7)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r10 = 0
            r3[r10] = r9     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            com.garena.android.appkit.d.a.e(r6, r3)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.StringBuffer r3 = r1.resultBuffer     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r9.<init>()     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r9.append(r2)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r9.append(r7)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.String r2 = r9.toString()     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            a((java.lang.StringBuffer) r3, (java.lang.String) r2)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r1.result = r8     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r7 = 0
            goto L_0x0138
        L_0x0126:
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r7 = 0
            r2[r7] = r3     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            com.garena.android.appkit.d.a.a(r6, r2)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.StringBuffer r2 = r1.resultBuffer     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            a((java.lang.StringBuffer) r2, (java.lang.String) r3)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r2 = 0
            r1.pingTime = r2     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r1.result = r7     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
        L_0x0138:
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            r2[r7] = r0     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            com.garena.android.appkit.d.a.e(r6, r2)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.StringBuffer r2 = r1.resultBuffer     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            a((java.lang.StringBuffer) r2, (java.lang.String) r0)     // Catch:{ IOException -> 0x016b, InterruptedException -> 0x0169, all -> 0x0165 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r7] = r5
            com.garena.android.appkit.d.a.e(r6, r0)
            if (r11 == 0) goto L_0x0150
            r11.destroy()
        L_0x0150:
            r4.close()     // Catch:{ IOException -> 0x0155 }
            goto L_0x01e5
        L_0x0155:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 0
            r0[r3] = r2
            com.garena.android.appkit.d.a.a(r6, r0)
            goto L_0x01e5
        L_0x0165:
            r0 = move-exception
            r1 = r0
            goto L_0x01e9
        L_0x0169:
            r0 = move-exception
            goto L_0x0176
        L_0x016b:
            r0 = move-exception
            goto L_0x017b
        L_0x016d:
            r0 = move-exception
            r2 = r9
            r1 = r0
            r4 = r2
            goto L_0x01e9
        L_0x0173:
            r0 = move-exception
            r2 = r9
            r4 = r2
        L_0x0176:
            r9 = r11
            goto L_0x0188
        L_0x0178:
            r0 = move-exception
            r2 = r9
            r4 = r2
        L_0x017b:
            r9 = r11
            goto L_0x01b9
        L_0x017d:
            r0 = move-exception
            r2 = r9
            r1 = r0
            r4 = r2
            r11 = r4
            goto L_0x01e9
        L_0x0184:
            r0 = move-exception
            r2 = r9
            r4 = r2
            r9 = r4
        L_0x0188:
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x01e6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01e6 }
            r3 = 0
            r2[r3] = r0     // Catch:{ all -> 0x01e6 }
            com.garena.android.appkit.d.a.a(r6, r2)     // Catch:{ all -> 0x01e6 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r3] = r5
            com.garena.android.appkit.d.a.e(r6, r0)
            if (r9 == 0) goto L_0x01a0
            r9.destroy()
        L_0x01a0:
            if (r4 == 0) goto L_0x01e5
            r4.close()     // Catch:{ IOException -> 0x01a6 }
            goto L_0x01e5
        L_0x01a6:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 0
            r0[r3] = r2
            com.garena.android.appkit.d.a.a(r6, r0)
            goto L_0x01e5
        L_0x01b5:
            r0 = move-exception
            r2 = r9
            r4 = r2
            r9 = r4
        L_0x01b9:
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x01e6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01e6 }
            r3 = 0
            r2[r3] = r0     // Catch:{ all -> 0x01e6 }
            com.garena.android.appkit.d.a.a(r6, r2)     // Catch:{ all -> 0x01e6 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r3] = r5
            com.garena.android.appkit.d.a.e(r6, r0)
            if (r9 == 0) goto L_0x01d1
            r9.destroy()
        L_0x01d1:
            if (r4 == 0) goto L_0x01e5
            r4.close()     // Catch:{ IOException -> 0x01d7 }
            goto L_0x01e5
        L_0x01d7:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 0
            r0[r3] = r2
            com.garena.android.appkit.d.a.a(r6, r0)
        L_0x01e5:
            return r1
        L_0x01e6:
            r0 = move-exception
            r1 = r0
            r11 = r9
        L_0x01e9:
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r2 = 0
            r0[r2] = r5
            com.garena.android.appkit.d.a.e(r6, r0)
            if (r11 == 0) goto L_0x01f6
            r11.destroy()
        L_0x01f6:
            if (r4 == 0) goto L_0x020a
            r4.close()     // Catch:{ IOException -> 0x01fc }
            goto L_0x020a
        L_0x01fc:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 0
            r0[r3] = r2
            com.garena.android.appkit.d.a.a(r6, r0)
        L_0x020a:
            goto L_0x020c
        L_0x020b:
            throw r1
        L_0x020c:
            goto L_0x020b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.livequiz.g.f.b(com.shopee.livequiz.data.bean.PingNetEntity):com.shopee.livequiz.data.bean.PingNetEntity");
    }

    private static void a(StringBuffer stringBuffer, String str) {
        if (stringBuffer != null) {
            stringBuffer.append(str + "\n");
        }
    }

    private static String a(String str) {
        String str2 = null;
        for (String str3 : str.split("\n")) {
            if (str3.contains("time=")) {
                str2 = str3.substring(str3.indexOf("time=") + 5);
                com.garena.android.appkit.d.a.e("NetworkUtil %s", str2);
            }
        }
        return str2;
    }

    private static double b(String str) {
        if (!str.contains(" ms")) {
            return 0.0d;
        }
        int indexOf = str.indexOf(" ms");
        if (indexOf <= 0) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str.substring(0, indexOf));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }
}
