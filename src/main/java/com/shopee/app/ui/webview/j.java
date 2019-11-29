package com.shopee.app.ui.webview;

import android.webkit.CookieManager;
import android.webkit.WebView;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.f.f;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.shopee.app.ui.webview.i;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.ugc.TXRecordCommon;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.LinkedList;
import org.apache.commons.c.d;

class j implements Runnable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final LinkedList<j> f26050a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private String f26051b;

    /* renamed from: c  reason: collision with root package name */
    private String f26052c;

    /* renamed from: d  reason: collision with root package name */
    private WebView f26053d;

    /* renamed from: e  reason: collision with root package name */
    private g f26054e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f26055f = new byte[8192];

    static {
        new Thread() {
            /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|6)|7|8|9) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r2 = this;
                L_0x0000:
                    java.util.LinkedList r0 = com.shopee.app.ui.webview.j.f26050a
                    monitor-enter(r0)
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.j.f26050a     // Catch:{ all -> 0x0025 }
                    boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0025 }
                    if (r1 == 0) goto L_0x0016
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.j.f26050a     // Catch:{ Exception -> 0x0016 }
                    r1.wait()     // Catch:{ Exception -> 0x0016 }
                L_0x0016:
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.j.f26050a     // Catch:{ all -> 0x0025 }
                    java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0025 }
                    com.shopee.app.ui.webview.j r1 = (com.shopee.app.ui.webview.j) r1     // Catch:{ all -> 0x0025 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                    r1.run()
                    goto L_0x0000
                L_0x0025:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                    goto L_0x0029
                L_0x0028:
                    throw r1
                L_0x0029:
                    goto L_0x0028
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.j.AnonymousClass1.run():void");
            }
        }.start();
    }

    public static void a(j jVar) {
        synchronized (f26050a) {
            if (!f26050a.contains(jVar)) {
                f26050a.addLast(jVar);
                f26050a.notifyAll();
            }
        }
    }

    public j(String str, String str2, WebView webView, g gVar) {
        this.f26051b = str;
        this.f26052c = str2;
        this.f26053d = webView;
        this.f26054e = gVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        String str = this.f26051b;
        if (str != null) {
            return str.equals(((j) obj).f26051b);
        }
        if (str == ((j) obj).f26051b) {
            return true;
        }
        return false;
    }

    public void run() {
        boolean[] zArr = {false};
        a(this.f26051b, this.f26052c, CookieManager.getInstance().getCookie(this.f26051b), this.f26055f, zArr);
        if (zArr[0] && this.f26054e.getCurrentUrl().equals(this.f26051b)) {
            this.f26054e.h(this.f26051b);
        }
    }

    public static i.a a(String str, String str2, String str3, byte[] bArr, boolean[] zArr) {
        return a(str, str2, str3, bArr, zArr, (InputStream[]) null, (String[]) null, (int[]) null, (HttpURLConnection[]) null, (int[]) null);
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2, byte[] bArr) {
        if (!i.b(str)) {
            i.a(str, str2, bArr);
            return true;
        }
        byte[] c2 = i.c(str);
        if (c2 != null && Arrays.equals(bArr, c2)) {
            return false;
        }
        i.a(str, str2, bArr);
        return true;
    }

    private static HttpURLConnection a(URL url, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        httpURLConnection.setConnectTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        httpURLConnection.setRequestProperty(HttpConstants.Header.USER_AGENT, str2);
        if (str != null) {
            httpURLConnection.setRequestProperty("Cookie", str);
        }
        httpURLConnection.setRequestProperty(COSRequestHeaderKey.CACHE_CONTROL, "no-cache");
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.Object} */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:76|(1:78)|(1:80)|81|(1:83)|(1:85)|(2:87|(2:89|(1:91)(2:92|(1:94)(2:95|(2:97|(1:99)(2:100|(2:102|(1:104)(2:105|(2:107|(1:109)(3:110|111|(2:113|114)))))))))))|115|116|(6:118|119|(1:121)|(1:123)|(1:125)|126)(3:127|(2:128|(1:130)(1:158))|131)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:41|42|43|(1:(1:45))|47|48|(1:(5:63|(1:65)|(1:67)|(1:69)|70)(1:71))(1:(5:52|(1:54)|(1:56)|(1:58)|59)(2:60|61))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x0180 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x009c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0186 A[SYNTHETIC, Splitter:B:118:0x0186] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0195 A[Catch:{ Exception -> 0x01ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01c3 A[SYNTHETIC, Splitter:B:144:0x01c3] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bb A[Catch:{ Exception -> 0x01b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ce A[Catch:{ Exception -> 0x01b1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.shopee.app.ui.webview.i.a a(java.lang.String r16, java.lang.String r17, java.lang.String r18, byte[] r19, boolean[] r20, java.io.InputStream[] r21, java.lang.String[] r22, int[] r23, java.net.HttpURLConnection[] r24, int[] r25) {
        /*
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r20
            java.lang.String r4 = "\""
            r5 = 0
            if (r3 == 0) goto L_0x0012
            int r6 = r3.length
            if (r6 <= 0) goto L_0x0012
            r3[r5] = r5
        L_0x0012:
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r19 != 0) goto L_0x001b
            if (r21 != 0) goto L_0x001b
            byte[] r7 = new byte[r6]
            goto L_0x001d
        L_0x001b:
            r7 = r19
        L_0x001d:
            r8 = 0
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r10 = com.shopee.app.ui.webview.i.a((java.lang.String) r16)     // Catch:{ Exception -> 0x01b9 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01b9 }
            boolean r10 = com.shopee.app.ui.webview.i.a((java.lang.String) r1, (java.lang.String) r8)     // Catch:{ Exception -> 0x01b9 }
            r11 = 400(0x190, float:5.6E-43)
            r12 = 300(0x12c, float:4.2E-43)
            r13 = 200(0xc8, float:2.8E-43)
            r15 = 1
            if (r10 == 0) goto L_0x0074
            java.net.HttpURLConnection r10 = a((java.net.URL) r9, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = "HEAD"
            r10.setRequestMethod(r6)     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r6 = "Accept-Encoding"
            java.lang.String r14 = "Identity"
            r10.setRequestProperty(r6, r14)     // Catch:{ Exception -> 0x01b4 }
            r10.setDoInput(r15)     // Catch:{ Exception -> 0x01b4 }
            r10.connect()     // Catch:{ Exception -> 0x01b4 }
            int r6 = r10.getResponseCode()     // Catch:{ Exception -> 0x01b4 }
            if (r6 != r13) goto L_0x0055
            int r14 = r10.getContentLength()     // Catch:{ Exception -> 0x01b4 }
            goto L_0x0070
        L_0x0055:
            if (r6 < r12) goto L_0x006f
            if (r6 >= r11) goto L_0x006f
            if (r21 == 0) goto L_0x006b
            r21[r5] = r8     // Catch:{ Exception -> 0x01b4 }
            if (r24 == 0) goto L_0x0061
            r24[r5] = r10     // Catch:{ Exception -> 0x01b4 }
        L_0x0061:
            if (r23 == 0) goto L_0x0066
            r0 = -1
            r23[r5] = r0     // Catch:{ Exception -> 0x01b4 }
        L_0x0066:
            if (r25 == 0) goto L_0x006a
            r25[r5] = r6     // Catch:{ Exception -> 0x01b4 }
        L_0x006a:
            return r8
        L_0x006b:
            r10.disconnect()     // Catch:{ Exception -> 0x01b4 }
            return r8
        L_0x006f:
            r14 = -1
        L_0x0070:
            r10.disconnect()     // Catch:{ Exception -> 0x01b4 }
            goto L_0x0076
        L_0x0074:
            r10 = r8
            r14 = -1
        L_0x0076:
            java.net.HttpURLConnection r2 = a((java.net.URL) r9, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r0 = "GET"
            r2.setRequestMethod(r0)     // Catch:{ Exception -> 0x01b1 }
            r2.setDoInput(r15)     // Catch:{ Exception -> 0x01b1 }
            r2.connect()     // Catch:{ Exception -> 0x01b1 }
            int r0 = r2.getResponseCode()     // Catch:{ Exception -> 0x01b1 }
            if (r0 == r13) goto L_0x00d3
            r6 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r6]     // Catch:{ Exception -> 0x009c }
            java.io.InputStream r6 = r2.getErrorStream()     // Catch:{ Exception -> 0x009c }
            if (r6 == 0) goto L_0x009c
        L_0x0095:
            int r7 = r6.read(r4)     // Catch:{ Exception -> 0x009c }
            if (r7 <= 0) goto L_0x009c
            goto L_0x0095
        L_0x009c:
            com.shopee.app.ui.webview.i.h(r16)     // Catch:{ Exception -> 0x01b1 }
            if (r0 < r12) goto L_0x00b9
            if (r0 >= r11) goto L_0x00b9
            if (r21 == 0) goto L_0x00b5
            r21[r5] = r8     // Catch:{ Exception -> 0x01b1 }
            if (r24 == 0) goto L_0x00ab
            r24[r5] = r2     // Catch:{ Exception -> 0x01b1 }
        L_0x00ab:
            if (r23 == 0) goto L_0x00b0
            r4 = -1
            r23[r5] = r4     // Catch:{ Exception -> 0x01b1 }
        L_0x00b0:
            if (r25 == 0) goto L_0x00b4
            r25[r5] = r0     // Catch:{ Exception -> 0x01b1 }
        L_0x00b4:
            return r8
        L_0x00b5:
            r2.disconnect()     // Catch:{ Exception -> 0x01b1 }
            return r8
        L_0x00b9:
            if (r21 == 0) goto L_0x00ce
            r2.disconnect()     // Catch:{ Exception -> 0x01b1 }
            r21[r5] = r8     // Catch:{ Exception -> 0x01b1 }
            if (r24 == 0) goto L_0x00c4
            r24[r5] = r8     // Catch:{ Exception -> 0x01b1 }
        L_0x00c4:
            if (r23 == 0) goto L_0x00c9
            r4 = -1
            r23[r5] = r4     // Catch:{ Exception -> 0x01b1 }
        L_0x00c9:
            if (r25 == 0) goto L_0x00cd
            r25[r5] = r0     // Catch:{ Exception -> 0x01b1 }
        L_0x00cd:
            return r8
        L_0x00ce:
            r0 = r8
            r4 = r0
            r9 = r4
            goto L_0x01c1
        L_0x00d3:
            java.util.Map r6 = r2.getHeaderFields()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r9 = r2.getContentType()     // Catch:{ Exception -> 0x01b1 }
            if (r9 != 0) goto L_0x00e4
            com.shopee.app.ui.webview.i.h(r16)     // Catch:{ Exception -> 0x01ae }
            r0 = r8
            r4 = r0
            goto L_0x01c1
        L_0x00e4:
            r10 = 59
            int r10 = r9.indexOf(r10)     // Catch:{ Exception -> 0x01ae }
            if (r10 <= 0) goto L_0x00f0
            java.lang.String r9 = r9.substring(r5, r10)     // Catch:{ Exception -> 0x01ae }
        L_0x00f0:
            if (r22 == 0) goto L_0x00f4
            r22[r5] = r9     // Catch:{ Exception -> 0x01ae }
        L_0x00f4:
            java.lang.String r10 = "Set-Cookie"
            java.lang.Object r10 = r6.get(r10)     // Catch:{ Exception -> 0x01ae }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x01ae }
            if (r10 == 0) goto L_0x010a
            com.garena.android.appkit.f.f r11 = com.garena.android.appkit.f.f.a()     // Catch:{ Exception -> 0x01ae }
            com.shopee.app.ui.webview.j$2 r12 = new com.shopee.app.ui.webview.j$2     // Catch:{ Exception -> 0x01ae }
            r12.<init>(r10, r1)     // Catch:{ Exception -> 0x01ae }
            r11.a(r12)     // Catch:{ Exception -> 0x01ae }
        L_0x010a:
            if (r14 >= 0) goto L_0x0110
            int r14 = r2.getContentLength()     // Catch:{ Exception -> 0x01ae }
        L_0x0110:
            if (r14 >= 0) goto L_0x0180
            java.lang.String r10 = "Server"
            java.lang.Object r10 = r6.get(r10)     // Catch:{ Exception -> 0x01ae }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x01ae }
            if (r10 == 0) goto L_0x0180
            int r11 = r10.size()     // Catch:{ Exception -> 0x01ae }
            if (r11 > 0) goto L_0x0123
            goto L_0x0180
        L_0x0123:
            java.lang.Object r10 = r10.get(r5)     // Catch:{ Exception -> 0x01ae }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x01ae }
            java.lang.String r11 = "nginx"
            boolean r10 = r11.equals(r10)     // Catch:{ Exception -> 0x01ae }
            if (r10 != 0) goto L_0x0132
            goto L_0x0180
        L_0x0132:
            java.lang.String r10 = "ETag"
            java.lang.Object r6 = r6.get(r10)     // Catch:{ Exception -> 0x01ae }
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x01ae }
            if (r6 == 0) goto L_0x0180
            int r10 = r6.size()     // Catch:{ Exception -> 0x01ae }
            if (r10 > 0) goto L_0x0143
            goto L_0x0180
        L_0x0143:
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x01ae }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x01ae }
            boolean r10 = org.apache.commons.c.d.a(r6)     // Catch:{ Exception -> 0x01ae }
            if (r10 != 0) goto L_0x0180
            int r10 = r6.length()     // Catch:{ Exception -> 0x01ae }
            r11 = 3
            if (r10 >= r11) goto L_0x0157
            goto L_0x0180
        L_0x0157:
            boolean r10 = r6.startsWith(r4)     // Catch:{ Exception -> 0x01ae }
            if (r10 == 0) goto L_0x0180
            boolean r4 = r6.endsWith(r4)     // Catch:{ Exception -> 0x01ae }
            if (r4 != 0) goto L_0x0164
            goto L_0x0180
        L_0x0164:
            int r4 = r6.length()     // Catch:{ Exception -> 0x01ae }
            int r4 = r4 - r15
            java.lang.String r4 = r6.substring(r15, r4)     // Catch:{ Exception -> 0x01ae }
            java.lang.String r6 = "-"
            java.lang.String[] r4 = r4.split(r6)     // Catch:{ Exception -> 0x01ae }
            int r6 = r4.length     // Catch:{ Exception -> 0x01ae }
            r10 = 2
            if (r6 == r10) goto L_0x0178
            goto L_0x0180
        L_0x0178:
            r4 = r4[r15]     // Catch:{ Exception -> 0x0180 }
            r6 = 16
            int r14 = java.lang.Integer.parseInt(r4, r6)     // Catch:{ Exception -> 0x0180 }
        L_0x0180:
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ Exception -> 0x01ae }
            if (r21 == 0) goto L_0x0195
            r21[r5] = r4     // Catch:{ Exception -> 0x01ac }
            if (r24 == 0) goto L_0x018c
            r24[r5] = r2     // Catch:{ Exception -> 0x01ac }
        L_0x018c:
            if (r23 == 0) goto L_0x0190
            r23[r5] = r14     // Catch:{ Exception -> 0x01ac }
        L_0x0190:
            if (r25 == 0) goto L_0x0194
            r25[r5] = r0     // Catch:{ Exception -> 0x01ac }
        L_0x0194:
            return r8
        L_0x0195:
            java.util.Arrays.fill(r7, r5)     // Catch:{ Exception -> 0x01ac }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x01ac }
            r0.<init>()     // Catch:{ Exception -> 0x01ac }
        L_0x019d:
            int r6 = r4.read(r7)     // Catch:{ Exception -> 0x01ac }
            if (r6 <= 0) goto L_0x01a7
            r0.write(r7, r5, r6)     // Catch:{ Exception -> 0x01ac }
            goto L_0x019d
        L_0x01a7:
            byte[] r0 = r0.toByteArray()     // Catch:{ Exception -> 0x01ac }
            goto L_0x01c1
        L_0x01ac:
            r0 = move-exception
            goto L_0x01bd
        L_0x01ae:
            r0 = move-exception
            r4 = r8
            goto L_0x01bd
        L_0x01b1:
            r0 = move-exception
            r4 = r8
            goto L_0x01bc
        L_0x01b4:
            r0 = move-exception
            r4 = r8
            r9 = r4
            r2 = r10
            goto L_0x01bd
        L_0x01b9:
            r0 = move-exception
            r2 = r8
            r4 = r2
        L_0x01bc:
            r9 = r4
        L_0x01bd:
            r0.printStackTrace()
            r0 = r8
        L_0x01c1:
            if (r4 == 0) goto L_0x01c8
            r4.close()     // Catch:{ Exception -> 0x01c7 }
            goto L_0x01c8
        L_0x01c7:
        L_0x01c8:
            if (r2 == 0) goto L_0x01cd
            r2.disconnect()
        L_0x01cd:
            if (r0 != 0) goto L_0x01d0
            return r8
        L_0x01d0:
            boolean r2 = b(r1, r9, r0)
            if (r3 == 0) goto L_0x01db
            int r4 = r3.length
            if (r4 <= 0) goto L_0x01db
            r3[r5] = r2
        L_0x01db:
            com.shopee.app.ui.webview.i$a r2 = new com.shopee.app.ui.webview.i$a
            r2.<init>(r1, r9, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.j.a(java.lang.String, java.lang.String, java.lang.String, byte[], boolean[], java.io.InputStream[], java.lang.String[], int[], java.net.HttpURLConnection[], int[]):com.shopee.app.ui.webview.i$a");
    }

    public static class a extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private ByteArrayOutputStream f26058a = new ByteArrayOutputStream();

        /* renamed from: b  reason: collision with root package name */
        private InputStream f26059b = null;

        /* renamed from: c  reason: collision with root package name */
        private HttpURLConnection f26060c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f26061d = null;

        /* renamed from: e  reason: collision with root package name */
        private int f26062e = -1;

        /* renamed from: f  reason: collision with root package name */
        private String f26063f = null;

        /* renamed from: g  reason: collision with root package name */
        private String f26064g = null;
        private String h = null;
        /* access modifiers changed from: private */
        public WebView i = null;
        private boolean j = false;
        private boolean k = false;

        public a(String str, String str2, String str3, WebView webView) {
            this.f26061d = str;
            this.f26064g = str2;
            this.h = str3;
            this.i = webView;
        }

        private void a() {
            this.k = true;
        }

        private boolean b() {
            String str;
            if (this.f26059b != null && this.f26060c != null) {
                return true;
            }
            if (this.j) {
                return false;
            }
            InputStream[] inputStreamArr = {null};
            HttpURLConnection[] httpURLConnectionArr = {null};
            int[] iArr = {-1};
            String[] strArr = {""};
            int[] iArr2 = {-1};
            j.a(this.f26061d, this.f26064g, this.h, (byte[]) null, (boolean[]) null, inputStreamArr, strArr, iArr, httpURLConnectionArr, iArr2);
            this.f26059b = inputStreamArr[0];
            this.f26060c = httpURLConnectionArr[0];
            this.f26062e = iArr[0];
            this.f26063f = strArr[0];
            int i2 = iArr2[0];
            HttpURLConnection httpURLConnection = this.f26060c;
            if (httpURLConnection == null) {
                a();
                return false;
            } else if (i2 >= 300 && i2 < 400) {
                final String headerField = httpURLConnection.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
                if (headerField != null) {
                    String lowerCase = headerField.toLowerCase();
                    if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                        try {
                            URL url = new URL(this.f26061d);
                            if (!lowerCase.startsWith(Constants.URL_PATH_DELIMITER)) {
                                String path = url.getPath();
                                str = url.getProtocol() + "://" + url.getHost() + path.substring(0, path.lastIndexOf(47)) + Constants.URL_PATH_DELIMITER + headerField;
                            } else {
                                str = url.getProtocol() + "://" + url.getHost() + headerField;
                            }
                            headerField = str;
                        } catch (Exception unused) {
                        }
                    }
                }
                if (!d.a((CharSequence) headerField, (CharSequence) this.f26061d)) {
                    a();
                    this.j = true;
                    f.a().a(new Runnable() {
                        public void run() {
                            if (!d.a((CharSequence) a.this.i.getUrl(), (CharSequence) headerField)) {
                                a.this.i.loadUrl(headerField);
                            }
                        }
                    });
                }
                a();
                return false;
            } else if (this.f26059b != null) {
                return true;
            } else {
                a();
                return false;
            }
        }

        private void c() {
            ByteArrayOutputStream byteArrayOutputStream = this.f26058a;
            if (byteArrayOutputStream != null) {
                int size = byteArrayOutputStream.size();
                int i2 = this.f26062e;
                if ((i2 <= 0 || size == i2) && !this.k) {
                    boolean unused = j.b(this.f26061d, this.f26063f, this.f26058a.toByteArray());
                }
                this.f26058a = null;
            }
        }

        private boolean d() {
            ByteArrayOutputStream byteArrayOutputStream = this.f26058a;
            if (byteArrayOutputStream == null) {
                return true;
            }
            int size = byteArrayOutputStream.size();
            int i2 = this.f26062e;
            if (i2 < 0 || size < i2) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            return -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0021 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized int read() throws java.io.IOException {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.d()     // Catch:{ all -> 0x0026 }
                r1 = -1
                if (r0 == 0) goto L_0x000a
                monitor-exit(r3)
                return r1
            L_0x000a:
                boolean r0 = r3.b()     // Catch:{ all -> 0x0026 }
                if (r0 != 0) goto L_0x0012
                monitor-exit(r3)
                return r1
            L_0x0012:
                java.io.InputStream r0 = r3.f26059b     // Catch:{ Throwable -> 0x0021 }
                int r0 = r0.read()     // Catch:{ Throwable -> 0x0021 }
                if (r0 <= 0) goto L_0x001f
                java.io.ByteArrayOutputStream r2 = r3.f26058a     // Catch:{ Throwable -> 0x0021 }
                r2.write(r0)     // Catch:{ Throwable -> 0x0021 }
            L_0x001f:
                monitor-exit(r3)
                return r0
            L_0x0021:
                r3.a()     // Catch:{ all -> 0x0026 }
                monitor-exit(r3)
                return r1
            L_0x0026:
                r0 = move-exception
                monitor-exit(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.j.a.read():int");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0026, code lost:
            return -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0022 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized int read(byte[] r5) throws java.io.IOException {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r4.d()     // Catch:{ all -> 0x0027 }
                r1 = -1
                if (r0 == 0) goto L_0x000a
                monitor-exit(r4)
                return r1
            L_0x000a:
                boolean r0 = r4.b()     // Catch:{ all -> 0x0027 }
                if (r0 != 0) goto L_0x0012
                monitor-exit(r4)
                return r1
            L_0x0012:
                java.io.InputStream r0 = r4.f26059b     // Catch:{ Throwable -> 0x0022 }
                int r0 = r0.read(r5)     // Catch:{ Throwable -> 0x0022 }
                if (r0 <= 0) goto L_0x0020
                java.io.ByteArrayOutputStream r2 = r4.f26058a     // Catch:{ Throwable -> 0x0022 }
                r3 = 0
                r2.write(r5, r3, r0)     // Catch:{ Throwable -> 0x0022 }
            L_0x0020:
                monitor-exit(r4)
                return r0
            L_0x0022:
                r4.a()     // Catch:{ all -> 0x0027 }
                monitor-exit(r4)
                return r1
            L_0x0027:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.j.a.read(byte[]):int");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
            return r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            return -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0021 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized int read(byte[] r3, int r4, int r5) throws java.io.IOException {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.d()     // Catch:{ all -> 0x0026 }
                r1 = -1
                if (r0 == 0) goto L_0x000a
                monitor-exit(r2)
                return r1
            L_0x000a:
                boolean r0 = r2.b()     // Catch:{ all -> 0x0026 }
                if (r0 != 0) goto L_0x0012
                monitor-exit(r2)
                return r1
            L_0x0012:
                java.io.InputStream r0 = r2.f26059b     // Catch:{ Throwable -> 0x0021 }
                int r5 = r0.read(r3, r4, r5)     // Catch:{ Throwable -> 0x0021 }
                if (r5 <= 0) goto L_0x001f
                java.io.ByteArrayOutputStream r0 = r2.f26058a     // Catch:{ Throwable -> 0x0021 }
                r0.write(r3, r4, r5)     // Catch:{ Throwable -> 0x0021 }
            L_0x001f:
                monitor-exit(r2)
                return r5
            L_0x0021:
                r2.a()     // Catch:{ all -> 0x0026 }
                monitor-exit(r2)
                return r1
            L_0x0026:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.j.a.read(byte[], int, int):int");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0016, code lost:
            return -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0012 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized int available() throws java.io.IOException {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.b()     // Catch:{ all -> 0x0017 }
                r1 = -1
                if (r0 != 0) goto L_0x000a
                monitor-exit(r2)
                return r1
            L_0x000a:
                java.io.InputStream r0 = r2.f26059b     // Catch:{ Throwable -> 0x0012 }
                int r0 = r0.available()     // Catch:{ Throwable -> 0x0012 }
                monitor-exit(r2)
                return r0
            L_0x0012:
                r2.a()     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)
                return r1
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.j.a.available():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            a();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0022 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void close() throws java.io.IOException {
            /*
                r2 = this;
                monitor-enter(r2)
                java.io.InputStream r0 = r2.f26059b     // Catch:{ Throwable -> 0x0022 }
                r1 = 0
                if (r0 == 0) goto L_0x000d
                java.io.InputStream r0 = r2.f26059b     // Catch:{ Throwable -> 0x0022 }
                r0.close()     // Catch:{ Throwable -> 0x0022 }
                r2.f26059b = r1     // Catch:{ Throwable -> 0x0022 }
            L_0x000d:
                java.net.HttpURLConnection r0 = r2.f26060c     // Catch:{ Throwable -> 0x0022 }
                if (r0 == 0) goto L_0x0018
                java.net.HttpURLConnection r0 = r2.f26060c     // Catch:{ Throwable -> 0x0022 }
                r0.disconnect()     // Catch:{ Throwable -> 0x0022 }
                r2.f26060c = r1     // Catch:{ Throwable -> 0x0022 }
            L_0x0018:
                java.io.ByteArrayOutputStream r0 = r2.f26058a     // Catch:{ Throwable -> 0x0022 }
                if (r0 == 0) goto L_0x0025
                r2.c()     // Catch:{ Throwable -> 0x0022 }
                goto L_0x0025
            L_0x0020:
                r0 = move-exception
                goto L_0x002a
            L_0x0022:
                r2.a()     // Catch:{ all -> 0x0020 }
            L_0x0025:
                r0 = 0
                r2.j = r0     // Catch:{ all -> 0x0020 }
                monitor-exit(r2)
                return
            L_0x002a:
                monitor-exit(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.j.a.close():void");
        }
    }
}
