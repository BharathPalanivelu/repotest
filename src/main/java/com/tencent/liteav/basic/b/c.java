package com.tencent.liteav.basic.b;

import android.content.Context;
import java.io.File;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private Context f31231b;

    /* renamed from: c  reason: collision with root package name */
    private String f31232c;

    /* renamed from: d  reason: collision with root package name */
    private String f31233d;

    /* renamed from: e  reason: collision with root package name */
    private String f31234e;

    /* renamed from: f  reason: collision with root package name */
    private b f31235f;

    /* renamed from: g  reason: collision with root package name */
    private long f31236g;
    private long h;
    private boolean i;

    public c(Context context, String str, String str2, String str3, b bVar, boolean z) {
        this.f31231b = context;
        this.f31232c = str;
        this.f31233d = str2;
        this.f31234e = str3;
        this.f31235f = bVar;
        this.i = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: com.tencent.liteav.basic.b.d} */
    /* JADX WARNING: type inference failed for: r0v28, types: [java.net.URLConnection] */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01a5, code lost:
        if (r1.f31235f != null) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01a7, code lost:
        r1.f31235f.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ae, code lost:
        r3 = null;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01b1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01b2, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01c2, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01c7, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01ce, code lost:
        r1.f31235f.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x01e0, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x01e5, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x01ea, code lost:
        if (r1.f31235f == null) goto L_0x01ed;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:32:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01bd A[SYNTHETIC, Splitter:B:131:0x01bd] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01c2 A[Catch:{ IOException -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01c7 A[Catch:{ IOException -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01ce A[Catch:{ IOException -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01db A[SYNTHETIC, Splitter:B:147:0x01db] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e0 A[Catch:{ IOException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e5 A[Catch:{ IOException -> 0x01ed }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r16 = this;
            r1 = r16
            android.content.Context r0 = r1.f31231b
            boolean r0 = com.tencent.liteav.basic.util.a.a((android.content.Context) r0)
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x01fa
            java.lang.String r0 = r1.f31232c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01fa
            java.lang.String r0 = r1.f31233d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01fa
            java.lang.String r0 = r1.f31234e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01fa
            java.lang.String r0 = r1.f31232c
            java.lang.String r4 = "http"
            boolean r0 = r0.startsWith(r4)
            if (r0 != 0) goto L_0x0030
            goto L_0x01fa
        L_0x0030:
            java.io.File r0 = new java.io.File
            java.lang.String r4 = r1.f31233d
            r0.<init>(r4)
            boolean r4 = r0.exists()
            if (r4 != 0) goto L_0x0041
            r0.mkdirs()
            goto L_0x004f
        L_0x0041:
            boolean r4 = r0.isFile()
            if (r4 == 0) goto L_0x004f
            com.tencent.liteav.basic.b.b r4 = r1.f31235f
            if (r4 == 0) goto L_0x004f
            r4.a(r0, r3)
            return
        L_0x004f:
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = r1.f31233d
            r0.append(r5)
            java.lang.String r5 = java.io.File.separator
            r0.append(r5)
            java.lang.String r5 = r1.f31234e
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            boolean r0 = r4.exists()     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            if (r0 == 0) goto L_0x0080
            r4.delete()     // Catch:{ Exception -> 0x007b, all -> 0x0076 }
            goto L_0x0080
        L_0x0076:
            r0 = move-exception
            r5 = r3
            r15 = r5
            goto L_0x01bb
        L_0x007b:
            r0 = move-exception
            r5 = r3
            r6 = r5
            goto L_0x01d8
        L_0x0080:
            r4.createNewFile()     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            java.lang.String r5 = r1.f31232c     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            r5 = r0
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x01d4, all -> 0x01b7 }
            r0 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r0)     // Catch:{ Exception -> 0x01b4, all -> 0x01b1 }
            r5.setReadTimeout(r0)     // Catch:{ Exception -> 0x01b4, all -> 0x01b1 }
            r0 = 1
            r5.setDoInput(r0)     // Catch:{ Exception -> 0x01b4, all -> 0x01b1 }
            java.lang.String r6 = "GET"
            r5.setRequestMethod(r6)     // Catch:{ Exception -> 0x01b4, all -> 0x01b1 }
            int r6 = r5.getResponseCode()     // Catch:{ Exception -> 0x01b4, all -> 0x01b1 }
            int r7 = r5.getResponseCode()     // Catch:{ Exception -> 0x01b4, all -> 0x01b1 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 != r8) goto L_0x00b6
            r7 = 1
            goto L_0x00b7
        L_0x00b6:
            r7 = 0
        L_0x00b7:
            if (r7 == 0) goto L_0x017b
            boolean r0 = r1.i     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            r8 = 0
            if (r0 == 0) goto L_0x010c
            int r0 = r5.getContentLength()     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            long r10 = (long) r0     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            r1.f31236g = r10     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            long r10 = r1.f31236g     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            int r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x00e4
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            if (r0 == 0) goto L_0x00d5
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            r0.a(r4, r3)     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
        L_0x00d5:
            if (r5 == 0) goto L_0x00da
            r5.disconnect()     // Catch:{ IOException -> 0x00e3 }
        L_0x00da:
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ IOException -> 0x00e3 }
            if (r0 == 0) goto L_0x00e3
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ IOException -> 0x00e3 }
            r0.a()     // Catch:{ IOException -> 0x00e3 }
        L_0x00e3:
            return
        L_0x00e4:
            long r10 = r1.f31236g     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            boolean r0 = com.tencent.liteav.basic.util.a.a((long) r10)     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            if (r0 != 0) goto L_0x010c
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            if (r0 == 0) goto L_0x00f5
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
            r0.a(r4, r3)     // Catch:{ Exception -> 0x0108, all -> 0x0104 }
        L_0x00f5:
            if (r5 == 0) goto L_0x00fa
            r5.disconnect()     // Catch:{ IOException -> 0x0103 }
        L_0x00fa:
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ IOException -> 0x0103 }
            if (r0 == 0) goto L_0x0103
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ IOException -> 0x0103 }
            r0.a()     // Catch:{ IOException -> 0x0103 }
        L_0x0103:
            return
        L_0x0104:
            r0 = move-exception
            r15 = r3
            goto L_0x01bb
        L_0x0108:
            r0 = move-exception
            r6 = r3
            goto L_0x01d9
        L_0x010c:
            java.io.InputStream r6 = r5.getInputStream()     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0178, all -> 0x0174 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0178, all -> 0x0174 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0178, all -> 0x0174 }
            r1.h = r8     // Catch:{ Exception -> 0x0170, all -> 0x016c }
        L_0x011b:
            int r8 = r6.read(r0)     // Catch:{ Exception -> 0x0170, all -> 0x016c }
            r9 = -1
            if (r8 == r9) goto L_0x0151
            r10.write(r0, r2, r8)     // Catch:{ Exception -> 0x0170, all -> 0x016c }
            boolean r9 = r1.i     // Catch:{ Exception -> 0x0170, all -> 0x016c }
            if (r9 == 0) goto L_0x011b
            long r11 = r1.h     // Catch:{ Exception -> 0x0170, all -> 0x016c }
            r13 = 100
            long r11 = r11 * r13
            long r2 = r1.f31236g     // Catch:{ Exception -> 0x0170, all -> 0x016c }
            long r11 = r11 / r2
            int r2 = (int) r11     // Catch:{ Exception -> 0x0170, all -> 0x016c }
            long r11 = r1.h     // Catch:{ Exception -> 0x0170, all -> 0x016c }
            r3 = r10
            long r9 = (long) r8
            long r11 = r11 + r9
            r1.h = r11     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            long r8 = r1.h     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            long r8 = r8 * r13
            long r10 = r1.f31236g     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            long r8 = r8 / r10
            int r9 = (int) r8     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            if (r2 == r9) goto L_0x014d
            com.tencent.liteav.basic.b.b r2 = r1.f31235f     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            if (r2 == 0) goto L_0x014d
            com.tencent.liteav.basic.b.b r2 = r1.f31235f     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            r2.a((int) r9)     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
        L_0x014d:
            r10 = r3
            r2 = 0
            r3 = 0
            goto L_0x011b
        L_0x0151:
            r3 = r10
            r3.flush()     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            if (r0 == 0) goto L_0x0165
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            r2 = 100
            r0.a((int) r2)     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            com.tencent.liteav.basic.b.b r0 = r1.f31235f     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
            r0.a((java.io.File) r4)     // Catch:{ Exception -> 0x0169, all -> 0x0167 }
        L_0x0165:
            r0 = 0
            goto L_0x0194
        L_0x0167:
            r0 = move-exception
            goto L_0x016e
        L_0x0169:
            r0 = move-exception
            goto L_0x01d9
        L_0x016c:
            r0 = move-exception
            r3 = r10
        L_0x016e:
            r15 = r6
            goto L_0x01bb
        L_0x0170:
            r0 = move-exception
            r3 = r10
            goto L_0x01d9
        L_0x0174:
            r0 = move-exception
            r15 = r6
            r3 = 0
            goto L_0x01bb
        L_0x0178:
            r0 = move-exception
            r3 = 0
            goto L_0x01d9
        L_0x017b:
            com.tencent.liteav.basic.b.d r3 = new com.tencent.liteav.basic.b.d     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            r0.<init>()     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            java.lang.String r2 = "http status got exception. code = "
            r0.append(r2)     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            r0.append(r6)     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x01ad, all -> 0x01b1 }
            r0 = r3
            r3 = 0
            r6 = 0
        L_0x0194:
            if (r3 == 0) goto L_0x0199
            r3.close()     // Catch:{ IOException -> 0x01ed }
        L_0x0199:
            if (r6 == 0) goto L_0x019e
            r6.close()     // Catch:{ IOException -> 0x01ed }
        L_0x019e:
            if (r5 == 0) goto L_0x01a3
            r5.disconnect()     // Catch:{ IOException -> 0x01ed }
        L_0x01a3:
            com.tencent.liteav.basic.b.b r2 = r1.f31235f     // Catch:{ IOException -> 0x01ed }
            if (r2 == 0) goto L_0x01ed
        L_0x01a7:
            com.tencent.liteav.basic.b.b r2 = r1.f31235f     // Catch:{ IOException -> 0x01ed }
            r2.a()     // Catch:{ IOException -> 0x01ed }
            goto L_0x01ed
        L_0x01ad:
            r0 = move-exception
            r3 = 0
            r6 = 0
            goto L_0x01d9
        L_0x01b1:
            r0 = move-exception
            r3 = 0
            goto L_0x01ba
        L_0x01b4:
            r0 = move-exception
            r3 = 0
            goto L_0x01d7
        L_0x01b7:
            r0 = move-exception
            r3 = 0
            r5 = 0
        L_0x01ba:
            r15 = 0
        L_0x01bb:
            if (r3 == 0) goto L_0x01c0
            r3.close()     // Catch:{ IOException -> 0x01d3 }
        L_0x01c0:
            if (r15 == 0) goto L_0x01c5
            r15.close()     // Catch:{ IOException -> 0x01d3 }
        L_0x01c5:
            if (r5 == 0) goto L_0x01ca
            r5.disconnect()     // Catch:{ IOException -> 0x01d3 }
        L_0x01ca:
            com.tencent.liteav.basic.b.b r2 = r1.f31235f     // Catch:{ IOException -> 0x01d3 }
            if (r2 == 0) goto L_0x01d3
            com.tencent.liteav.basic.b.b r2 = r1.f31235f     // Catch:{ IOException -> 0x01d3 }
            r2.a()     // Catch:{ IOException -> 0x01d3 }
        L_0x01d3:
            throw r0
        L_0x01d4:
            r0 = move-exception
            r3 = 0
            r5 = 0
        L_0x01d7:
            r6 = 0
        L_0x01d8:
            r7 = 0
        L_0x01d9:
            if (r3 == 0) goto L_0x01de
            r3.close()     // Catch:{ IOException -> 0x01ed }
        L_0x01de:
            if (r6 == 0) goto L_0x01e3
            r6.close()     // Catch:{ IOException -> 0x01ed }
        L_0x01e3:
            if (r5 == 0) goto L_0x01e8
            r5.disconnect()     // Catch:{ IOException -> 0x01ed }
        L_0x01e8:
            com.tencent.liteav.basic.b.b r2 = r1.f31235f     // Catch:{ IOException -> 0x01ed }
            if (r2 == 0) goto L_0x01ed
            goto L_0x01a7
        L_0x01ed:
            if (r7 == 0) goto L_0x01f1
            if (r0 == 0) goto L_0x01f9
        L_0x01f1:
            com.tencent.liteav.basic.b.b r0 = r1.f31235f
            if (r0 == 0) goto L_0x01f9
            r2 = 0
            r0.a(r4, r2)
        L_0x01f9:
            return
        L_0x01fa:
            r2 = r3
            r3 = 0
            r1.a(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.b.c.run():void");
    }

    private void a(Exception exc, int i2) {
        b bVar = this.f31235f;
        if (bVar != null) {
            bVar.a((File) null, exc);
        }
        this.f31235f = null;
    }
}
