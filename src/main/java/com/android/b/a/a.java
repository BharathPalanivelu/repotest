package com.android.b.a;

import cn.tongdun.android.shell.settings.Constants;
import com.android.b.b;
import com.android.b.f;
import com.android.b.l;
import com.android.b.p;
import com.android.b.q;
import com.android.b.s;
import com.android.b.t;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f4556a = t.f4631b;

    /* renamed from: d  reason: collision with root package name */
    private static int f4557d = Constants.DEFAULT_WAIT_TIME;

    /* renamed from: e  reason: collision with root package name */
    private static int f4558e = 4096;

    /* renamed from: b  reason: collision with root package name */
    protected final f f4559b;

    /* renamed from: c  reason: collision with root package name */
    protected final b f4560c;

    public a(f fVar) {
        this(fVar, new b(f4558e));
    }

    public a(f fVar, b bVar) {
        this.f4559b = fVar;
        this.f4560c = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0087, code lost:
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008b, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0093, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0094, code lost:
        r15 = r1;
        r2 = null;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0099, code lost:
        r0 = r14.getStatusLine().getStatusCode();
        com.android.b.t.c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r18.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        if (r2 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b7, code lost:
        r1 = new com.android.b.i(r0, r2, r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00be, code lost:
        if (r0 == 401) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ca, code lost:
        throw new com.android.b.q(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cb, code lost:
        a("auth", r8, new com.android.b.a(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00dc, code lost:
        throw new com.android.b.h((com.android.b.i) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e2, code lost:
        throw new com.android.b.j(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fe, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r18.getUrl(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ff, code lost:
        a("connection", r8, new com.android.b.r());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010b, code lost:
        a("socket", r8, new com.android.b.r());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e3 A[ExcHandler: MalformedURLException (r0v2 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00dd A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.b.i a(com.android.b.l<?> r18) throws com.android.b.s {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            long r9 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r11 = 1
            r12 = 0
            r13 = 0
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0093 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0093 }
            com.android.b.b$a r2 = r18.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0093 }
            r7.a(r0, r2)     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0093 }
            com.android.b.a.f r2 = r7.f4559b     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0093 }
            org.apache.http.HttpResponse r14 = r2.a(r8, r0)     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0093 }
            org.apache.http.StatusLine r6 = r14.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008f }
            int r0 = r6.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008f }
            org.apache.http.Header[] r2 = r14.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008f }
            java.util.Map r15 = a((org.apache.http.Header[]) r2)     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008f }
            r1 = 304(0x130, float:4.26E-43)
            if (r0 != r1) goto L_0x004a
            com.android.b.i r0 = new com.android.b.i     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
            com.android.b.b$a r2 = r18.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
            if (r2 != 0) goto L_0x0040
            r2 = r13
            goto L_0x0046
        L_0x0040:
            com.android.b.b$a r2 = r18.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
            byte[] r2 = r2.f4582a     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
        L_0x0046:
            r0.<init>(r1, r2, r15, r11)     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
            return r0
        L_0x004a:
            org.apache.http.HttpEntity r1 = r14.getEntity()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
            if (r1 == 0) goto L_0x0059
            org.apache.http.HttpEntity r1 = r14.getEntity()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
            byte[] r1 = r7.a((org.apache.http.HttpEntity) r1)     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
            goto L_0x005b
        L_0x0059:
            byte[] r1 = new byte[r12]     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008d }
        L_0x005b:
            r5 = r1
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x008a }
            long r3 = r1 - r9
            r1 = r17
            r2 = r3
            r4 = r18
            r16 = r5
            r1.a(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0086 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L_0x007c
            r1 = 299(0x12b, float:4.19E-43)
            if (r0 > r1) goto L_0x007c
            com.android.b.i r1 = new com.android.b.i     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0086 }
            r2 = r16
            r1.<init>(r0, r2, r15, r12)     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0084 }
            return r1
        L_0x007c:
            r2 = r16
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0084 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0084 }
            throw r0     // Catch:{ SocketTimeoutException -> 0x010b, ConnectTimeoutException -> 0x00ff, MalformedURLException -> 0x00e3, IOException -> 0x0084 }
        L_0x0084:
            r0 = move-exception
            goto L_0x0097
        L_0x0086:
            r0 = move-exception
            r2 = r16
            goto L_0x0097
        L_0x008a:
            r0 = move-exception
            r2 = r5
            goto L_0x0097
        L_0x008d:
            r0 = move-exception
            goto L_0x0091
        L_0x008f:
            r0 = move-exception
            r15 = r1
        L_0x0091:
            r2 = r13
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r15 = r1
            r2 = r13
            r14 = r2
        L_0x0097:
            if (r14 == 0) goto L_0x00dd
            org.apache.http.StatusLine r0 = r14.getStatusLine()
            int r0 = r0.getStatusCode()
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r1[r12] = r3
            java.lang.String r3 = r18.getUrl()
            r1[r11] = r3
            java.lang.String r3 = "Unexpected response code %d for %s"
            com.android.b.t.c(r3, r1)
            if (r2 == 0) goto L_0x00d7
            com.android.b.i r1 = new com.android.b.i
            r1.<init>(r0, r2, r15, r12)
            r2 = 401(0x191, float:5.62E-43)
            if (r0 == r2) goto L_0x00cb
            r2 = 403(0x193, float:5.65E-43)
            if (r0 != r2) goto L_0x00c5
            goto L_0x00cb
        L_0x00c5:
            com.android.b.q r0 = new com.android.b.q
            r0.<init>(r1)
            throw r0
        L_0x00cb:
            com.android.b.a r0 = new com.android.b.a
            r0.<init>(r1)
            java.lang.String r1 = "auth"
            a(r1, r8, r0)
            goto L_0x0008
        L_0x00d7:
            com.android.b.h r0 = new com.android.b.h
            r0.<init>((com.android.b.i) r13)
            throw r0
        L_0x00dd:
            com.android.b.j r1 = new com.android.b.j
            r1.<init>(r0)
            throw r1
        L_0x00e3:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Bad URL "
            r2.append(r3)
            java.lang.String r3 = r18.getUrl()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00ff:
            com.android.b.r r0 = new com.android.b.r
            r0.<init>()
            java.lang.String r1 = "connection"
            a(r1, r8, r0)
            goto L_0x0008
        L_0x010b:
            com.android.b.r r0 = new com.android.b.r
            r0.<init>()
            java.lang.String r1 = "socket"
            a(r1, r8, r0)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.b.a.a.a(com.android.b.l):com.android.b.i");
    }

    private void a(long j, l<?> lVar, byte[] bArr, StatusLine statusLine) {
        if (f4556a || j > ((long) f4557d)) {
            Object[] objArr = new Object[5];
            objArr[0] = lVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(lVar.getRetryPolicy().b());
            t.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, l<?> lVar, s sVar) throws s {
        p retryPolicy = lVar.getRetryPolicy();
        int timeoutMs = lVar.getTimeoutMs();
        try {
            retryPolicy.a(sVar);
            lVar.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
        } catch (s e2) {
            lVar.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
            throw e2;
        }
    }

    private void a(Map<String, String> map, b.a aVar) {
        if (aVar != null) {
            if (aVar.f4583b != null) {
                map.put(COSRequestHeaderKey.IF_NONE_MATCH, aVar.f4583b);
            }
            if (aVar.f4584c > 0) {
                map.put(COSRequestHeaderKey.IF_MODIFIED_SINCE, DateUtils.formatDate(new Date(aVar.f4584c)));
            }
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException, q {
        k kVar = new k(this.f4560c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                bArr = this.f4560c.a(1024);
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    kVar.write(bArr, 0, read);
                }
                return kVar.toByteArray();
            }
            throw new q();
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                t.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f4560c.a(bArr);
            kVar.close();
        }
    }

    private static Map<String, String> a(Header[] headerArr) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }
}
