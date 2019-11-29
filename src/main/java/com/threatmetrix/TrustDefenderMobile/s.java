package com.threatmetrix.TrustDefenderMobile;

class s implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static final String f32605f = "com.threatmetrix.TrustDefenderMobile.s";

    /* renamed from: a  reason: collision with root package name */
    private String f32606a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f32607b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f32608c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f32609d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f32610e = 10000;

    public s(String str, String str2, String str3, String str4, int i) {
        this.f32606a = str;
        this.f32607b = str2;
        this.f32608c = str3;
        this.f32609d = str4;
        this.f32610e = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b6 A[SYNTHETIC, Splitter:B:36:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            java.lang.String r0 = "Tidying up"
            r1 = 0
            java.net.Socket r2 = new java.net.Socket     // Catch:{ UnknownHostException -> 0x009c, IOException -> 0x008b, all -> 0x0086 }
            java.lang.String r3 = r8.f32606a     // Catch:{ UnknownHostException -> 0x009c, IOException -> 0x008b, all -> 0x0086 }
            r4 = 8080(0x1f90, float:1.1322E-41)
            r2.<init>(r3, r4)     // Catch:{ UnknownHostException -> 0x009c, IOException -> 0x008b, all -> 0x0086 }
            int r1 = r8.f32610e     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r2.setSoTimeout(r1)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.io.PrintWriter r4 = new java.io.PrintWriter     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r4.<init>(r1)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r3.<init>(r4)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r4.<init>(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r1.<init>(r4)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r4.<init>()     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r5 = "<handle sig=FF44EE55 session_id="
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r5 = r8.f32608c     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r5 = " org_id="
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r5 = r8.f32607b     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r5 = " w="
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r5 = r8.f32609d     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r5 = " />"
            r4.append(r5)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            java.lang.String r4 = r4.toString()     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r3.write(r4)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r3.flush()     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            int r4 = r1.read()     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r5 = -1
            if (r4 == r5) goto L_0x0079
            r4 = 1
            char[] r4 = new char[r4]     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            r5 = 0
            r4[r5] = r5     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
        L_0x006c:
            r6 = 15
            if (r5 >= r6) goto L_0x0076
            r3.write(r4)     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
            int r5 = r5 + 1
            goto L_0x006c
        L_0x0076:
            r1.read()     // Catch:{ UnknownHostException -> 0x0084, IOException -> 0x0082 }
        L_0x0079:
            java.lang.String r1 = f32605f
            android.util.Log.d(r1, r0)
        L_0x007e:
            r2.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00ad
        L_0x0082:
            r1 = move-exception
            goto L_0x008f
        L_0x0084:
            r1 = move-exception
            goto L_0x00a0
        L_0x0086:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x00af
        L_0x008b:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L_0x008f:
            java.lang.String r3 = "Failed to read/write to the fp server"
            android.util.Log.w(r3, r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = f32605f
            android.util.Log.d(r1, r0)
            if (r2 == 0) goto L_0x00ad
            goto L_0x007e
        L_0x009c:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L_0x00a0:
            java.lang.String r3 = "Failed to connect to the fp server"
            android.util.Log.w(r3, r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = f32605f
            android.util.Log.d(r1, r0)
            if (r2 == 0) goto L_0x00ad
            goto L_0x007e
        L_0x00ad:
            return
        L_0x00ae:
            r1 = move-exception
        L_0x00af:
            java.lang.String r3 = f32605f
            android.util.Log.d(r3, r0)
            if (r2 == 0) goto L_0x00b9
            r2.close()     // Catch:{ IOException -> 0x00b9 }
        L_0x00b9:
            goto L_0x00bb
        L_0x00ba:
            throw r1
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.s.run():void");
    }
}
