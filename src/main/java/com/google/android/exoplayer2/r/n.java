package com.google.android.exoplayer2.r;

import android.net.Uri;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.google.android.exoplayer2.r.q;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class n implements q {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11348b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<byte[]> f11349c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11350d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11351e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11352f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11353g;
    private final com.google.android.exoplayer2.s.n<String> h;
    private final q.f i;
    private final q.f j = new q.f();
    private final u<? super n> k;
    private i l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;

    public n(String str, com.google.android.exoplayer2.s.n<String> nVar, u<? super n> uVar, int i2, int i3, boolean z, q.f fVar) {
        this.f11353g = a.a(str);
        this.h = nVar;
        this.k = uVar;
        this.f11351e = i2;
        this.f11352f = i3;
        this.f11350d = z;
        this.i = fVar;
    }

    public Uri b() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public long a(i iVar) throws q.c {
        this.l = iVar;
        long j2 = 0;
        this.s = 0;
        this.r = 0;
        try {
            this.m = b(iVar);
            try {
                int responseCode = this.m.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = this.m.getHeaderFields();
                    e();
                    q.e eVar = new q.e(responseCode, headerFields, iVar);
                    if (responseCode == 416) {
                        eVar.initCause(new g(0));
                    }
                    throw eVar;
                }
                String contentType = this.m.getContentType();
                com.google.android.exoplayer2.s.n<String> nVar = this.h;
                if (nVar == null || nVar.a(contentType)) {
                    if (responseCode == 200 && iVar.f11316d != 0) {
                        j2 = iVar.f11316d;
                    }
                    this.p = j2;
                    if (!iVar.a(1)) {
                        long j3 = -1;
                        if (iVar.f11317e != -1) {
                            this.q = iVar.f11317e;
                        } else {
                            long a2 = a(this.m);
                            if (a2 != -1) {
                                j3 = a2 - this.p;
                            }
                            this.q = j3;
                        }
                    } else {
                        this.q = iVar.f11317e;
                    }
                    try {
                        this.n = this.m.getInputStream();
                        this.o = true;
                        u<? super n> uVar = this.k;
                        if (uVar != null) {
                            uVar.a(this, iVar);
                        }
                        return this.q;
                    } catch (IOException e2) {
                        e();
                        throw new q.c(e2, iVar, 1);
                    }
                } else {
                    e();
                    throw new q.d(contentType, iVar);
                }
            } catch (IOException e3) {
                e();
                throw new q.c("Unable to connect to " + iVar.f11313a.toString(), e3, iVar, 1);
            }
        } catch (IOException e4) {
            throw new q.c("Unable to connect to " + iVar.f11313a.toString(), e4, iVar, 1);
        }
    }

    public int a(byte[] bArr, int i2, int i3) throws q.c {
        try {
            d();
            return b(bArr, i2, i3);
        } catch (IOException e2) {
            throw new q.c(e2, this.l, 2);
        }
    }

    public void a() throws q.c {
        try {
            if (this.n != null) {
                a(this.m, c());
                this.n.close();
            }
            this.n = null;
            e();
            if (this.o) {
                this.o = false;
                u<? super n> uVar = this.k;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        } catch (IOException e2) {
            throw new q.c(e2, this.l, 3);
        } catch (Throwable th) {
            this.n = null;
            e();
            if (this.o) {
                this.o = false;
                u<? super n> uVar2 = this.k;
                if (uVar2 != null) {
                    uVar2.a(this);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final long c() {
        long j2 = this.q;
        return j2 == -1 ? j2 : j2 - this.s;
    }

    private HttpURLConnection b(i iVar) throws IOException {
        HttpURLConnection a2;
        i iVar2 = iVar;
        URL url = new URL(iVar2.f11313a.toString());
        byte[] bArr = iVar2.f11314b;
        long j2 = iVar2.f11316d;
        long j3 = iVar2.f11317e;
        boolean a3 = iVar2.a(1);
        if (!this.f11350d) {
            return a(url, bArr, j2, j3, a3, true);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 <= 20) {
                long j4 = j2;
                int i4 = i3;
                a2 = a(url, bArr, j2, j3, a3, false);
                int responseCode = a2.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    bArr = null;
                    String headerField = a2.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
                    a2.disconnect();
                    url = a(url, headerField);
                    i2 = i4;
                    j2 = j4;
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i3);
            }
        }
        return a2;
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setConnectTimeout(this.f11351e);
        httpURLConnection.setReadTimeout(this.f11352f);
        q.f fVar = this.i;
        if (fVar != null) {
            for (Map.Entry next : fVar.a().entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        for (Map.Entry next2 : this.j.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) next2.getKey(), (String) next2.getValue());
        }
        if (!(j2 == 0 && j3 == -1)) {
            String str = "bytes=" + j2 + "-";
            if (j3 != -1) {
                str = str + ((j2 + j3) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty(HttpConstants.Header.USER_AGENT, this.f11353g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL a(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            throw new ProtocolException("Unsupported protocol redirect: " + protocol);
        }
        throw new ProtocolException("Null location redirect");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "DefaultHttpDataSource"
            if (r1 != 0) goto L_0x002c
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0015 }
            goto L_0x002e
        L_0x0015:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Unexpected Content-Length ["
            r1.append(r4)
            r1.append(r0)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r3, r1)
        L_0x002c:
            r4 = -1
        L_0x002e:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00a4
            java.util.regex.Pattern r1 = f11348b
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r6 = r1.find()
            if (r6 == 0) goto L_0x00a4
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch:{ NumberFormatException -> 0x008d }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x008d }
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch:{ NumberFormatException -> 0x008d }
            long r8 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x008d }
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0064
            r4 = r6
            goto L_0x00a4
        L_0x0064:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00a4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x008d }
            r1.<init>()     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r8 = "Inconsistent headers ["
            r1.append(r8)     // Catch:{ NumberFormatException -> 0x008d }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r0 = "] ["
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x008d }
            r1.append(r10)     // Catch:{ NumberFormatException -> 0x008d }
            r1.append(r2)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r0 = r1.toString()     // Catch:{ NumberFormatException -> 0x008d }
            android.util.Log.w(r3, r0)     // Catch:{ NumberFormatException -> 0x008d }
            long r0 = java.lang.Math.max(r4, r6)     // Catch:{ NumberFormatException -> 0x008d }
            r4 = r0
            goto L_0x00a4
        L_0x008d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected Content-Range ["
            r0.append(r1)
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
            android.util.Log.e(r3, r10)
        L_0x00a4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.r.n.a(java.net.HttpURLConnection):long");
    }

    private void d() throws IOException {
        if (this.r != this.p) {
            byte[] andSet = f11349c.getAndSet((Object) null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (true) {
                long j2 = this.r;
                long j3 = this.p;
                if (j2 != j3) {
                    int read = this.n.read(andSet, 0, (int) Math.min(j3 - j2, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.r += (long) read;
                        u<? super n> uVar = this.k;
                        if (uVar != null) {
                            uVar.a(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    f11349c.set(andSet);
                    return;
                }
            }
        }
    }

    private int b(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.q;
        if (j2 != -1) {
            long j3 = j2 - this.s;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = this.n.read(bArr, i2, i3);
        if (read != -1) {
            this.s += (long) read;
            u<? super n> uVar = this.k;
            if (uVar != null) {
                uVar.a(this, read);
            }
            return read;
        } else if (this.q == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private static void a(HttpURLConnection httpURLConnection, long j2) {
        if (v.f11449a == 19 || v.f11449a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= IjkMediaMeta.AV_CH_TOP_CENTER) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void e() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.m = null;
        }
    }
}
