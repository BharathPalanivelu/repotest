package com.bca.xco.widget.d.a.a.a;

import com.bca.xco.widget.d.a.a.d.e;
import com.bca.xco.widget.d.a.a.f.f;
import com.bca.xco.widget.d.a.a.g.h;
import com.bca.xco.widget.d.a.a.g.i;
import com.bca.xco.widget.d.a.ab;
import com.bca.xco.widget.d.a.d;
import com.bca.xco.widget.d.a.n;
import com.bca.xco.widget.d.a.q;
import com.bca.xco.widget.d.a.s;
import com.bca.xco.widget.d.a.t;
import com.bca.xco.widget.d.a.v;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.z;
import com.bca.xco.widget.d.b.a;
import com.bca.xco.widget.d.b.b;
import com.bca.xco.widget.d.b.m;
import com.facebook.common.time.Clock;
import com.facebook.react.uimanager.ViewProps;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class c extends h.b implements d {

    /* renamed from: a  reason: collision with root package name */
    public Socket f4747a;

    /* renamed from: b  reason: collision with root package name */
    public volatile h f4748b;

    /* renamed from: c  reason: collision with root package name */
    public int f4749c;

    /* renamed from: d  reason: collision with root package name */
    public b f4750d;

    /* renamed from: e  reason: collision with root package name */
    public a f4751e;

    /* renamed from: f  reason: collision with root package name */
    public int f4752f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Reference<g>> f4753g = new ArrayList();
    public boolean h;
    public long i = Clock.MAX_TIME;
    private final ab k;
    private Socket l;
    private q m;
    private v n;

    public c(ab abVar) {
        this.k = abVar;
    }

    public void a(int i2, int i3, int i4, List<n> list, boolean z) {
        if (this.n == null) {
            b bVar = new b(list);
            if (this.k.a().i() == null) {
                if (list.contains(n.f5092c)) {
                    String f2 = this.k.a().a().f();
                    if (!e.b().a(f2)) {
                        throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
                    }
                } else {
                    throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            }
            e eVar = null;
            while (this.n == null) {
                try {
                    if (this.k.d()) {
                        a(i2, i3, i4, bVar);
                    } else {
                        b(i2, i3, i4, bVar);
                    }
                } catch (IOException e2) {
                    com.bca.xco.widget.d.a.a.c.a(this.f4747a);
                    com.bca.xco.widget.d.a.a.c.a(this.l);
                    this.f4747a = null;
                    this.l = null;
                    this.f4750d = null;
                    this.f4751e = null;
                    this.m = null;
                    this.n = null;
                    if (eVar == null) {
                        eVar = new e(e2);
                    } else {
                        eVar.a(e2);
                    }
                    if (!z || !bVar.a(e2)) {
                        throw eVar;
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("already connected");
    }

    private void a(int i2, int i3, int i4, b bVar) {
        x e2 = e();
        t a2 = e2.a();
        int i5 = 0;
        while (true) {
            i5++;
            if (i5 <= 21) {
                a(i2, i3);
                e2 = a(i3, i4, e2, a2);
                if (e2 == null) {
                    a(i3, i4, bVar);
                    return;
                }
                com.bca.xco.widget.d.a.a.c.a(this.l);
                this.l = null;
                this.f4751e = null;
                this.f4750d = null;
            } else {
                throw new ProtocolException("Too many tunnel connections attempted: " + 21);
            }
        }
    }

    private void b(int i2, int i3, int i4, b bVar) {
        a(i2, i3);
        a(i3, i4, bVar);
    }

    private void a(int i2, int i3) {
        Proxy b2 = this.k.b();
        this.l = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.k.a().c().createSocket() : new Socket(b2);
        this.l.setSoTimeout(i3);
        try {
            e.b().a(this.l, this.k.c(), i2);
            this.f4750d = m.a(m.b(this.l));
            this.f4751e = m.a(m.a(this.l));
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.k.c());
        }
    }

    private void a(int i2, int i3, b bVar) {
        if (this.k.a().i() != null) {
            b(i2, i3, bVar);
        } else {
            this.n = v.HTTP_1_1;
            this.f4747a = this.l;
        }
        if (this.n == v.HTTP_2) {
            this.f4747a.setSoTimeout(0);
            h a2 = new h.a(true).a(this.f4747a, this.k.a().a().f(), this.f4750d, this.f4751e).a((h.b) this).a();
            a2.c();
            this.f4752f = a2.a();
            this.f4748b = a2;
            return;
        }
        this.f4752f = 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v2, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0115 A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011b A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r6, int r7, com.bca.xco.widget.d.a.a.a.b r8) {
        /*
            r5 = this;
            com.bca.xco.widget.d.a.ab r6 = r5.k
            com.bca.xco.widget.d.a.h r6 = r6.a()
            javax.net.ssl.SSLSocketFactory r7 = r6.i()
            r0 = 0
            java.net.Socket r1 = r5.l     // Catch:{ AssertionError -> 0x010e }
            com.bca.xco.widget.d.a.t r2 = r6.a()     // Catch:{ AssertionError -> 0x010e }
            java.lang.String r2 = r2.f()     // Catch:{ AssertionError -> 0x010e }
            com.bca.xco.widget.d.a.t r3 = r6.a()     // Catch:{ AssertionError -> 0x010e }
            int r3 = r3.g()     // Catch:{ AssertionError -> 0x010e }
            r4 = 1
            java.net.Socket r7 = r7.createSocket(r1, r2, r3, r4)     // Catch:{ AssertionError -> 0x010e }
            javax.net.ssl.SSLSocket r7 = (javax.net.ssl.SSLSocket) r7     // Catch:{ AssertionError -> 0x010e }
            com.bca.xco.widget.d.a.n r8 = r8.a((javax.net.ssl.SSLSocket) r7)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            boolean r1 = r8.d()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            if (r1 == 0) goto L_0x0041
            com.bca.xco.widget.d.a.a.d.e r1 = com.bca.xco.widget.d.a.a.d.e.b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.a.t r2 = r6.a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r2 = r2.f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.util.List r3 = r6.e()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r1.a((javax.net.ssl.SSLSocket) r7, (java.lang.String) r2, (java.util.List<com.bca.xco.widget.d.a.v>) r3)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        L_0x0041:
            r7.startHandshake()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            javax.net.ssl.SSLSession r1 = r7.getSession()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.a.q r1 = com.bca.xco.widget.d.a.q.a(r1)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            javax.net.ssl.HostnameVerifier r2 = r6.j()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.a.t r3 = r6.a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r3 = r3.f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            javax.net.ssl.SSLSession r4 = r7.getSession()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            boolean r2 = r2.verify(r3, r4)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            if (r2 == 0) goto L_0x00b4
            com.bca.xco.widget.d.a.k r2 = r6.k()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.a.t r6 = r6.a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = r6.f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.util.List r3 = r1.b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r2.a(r6, r3)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            boolean r6 = r8.d()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            if (r6 == 0) goto L_0x0083
            com.bca.xco.widget.d.a.a.d.e r6 = com.bca.xco.widget.d.a.a.d.e.b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r0 = r6.a((javax.net.ssl.SSLSocket) r7)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        L_0x0083:
            r5.f4747a = r7     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.net.Socket r6 = r5.f4747a     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.b.d r6 = com.bca.xco.widget.d.b.m.b(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.b.b r6 = com.bca.xco.widget.d.b.m.a((com.bca.xco.widget.d.b.d) r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r5.f4750d = r6     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.net.Socket r6 = r5.f4747a     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.b.c r6 = com.bca.xco.widget.d.b.m.a((java.net.Socket) r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.b.a r6 = com.bca.xco.widget.d.b.m.a((com.bca.xco.widget.d.b.c) r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r5.f4751e = r6     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r5.m = r1     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            if (r0 == 0) goto L_0x00a6
            com.bca.xco.widget.d.a.v r6 = com.bca.xco.widget.d.a.v.a(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            goto L_0x00a8
        L_0x00a6:
            com.bca.xco.widget.d.a.v r6 = com.bca.xco.widget.d.a.v.HTTP_1_1     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        L_0x00a8:
            r5.n = r6     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            if (r7 == 0) goto L_0x00b3
            com.bca.xco.widget.d.a.a.d.e r6 = com.bca.xco.widget.d.a.a.d.e.b()
            r6.b((javax.net.ssl.SSLSocket) r7)
        L_0x00b3:
            return
        L_0x00b4:
            java.util.List r8 = r1.b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r0 = 0
            java.lang.Object r8 = r8.get(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            javax.net.ssl.SSLPeerUnverifiedException r0 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r1.<init>()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r2 = "Hostname "
            r1.append(r2)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            com.bca.xco.widget.d.a.t r6 = r6.a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = r6.f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = " not verified:\n    certificate: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = com.bca.xco.widget.d.a.k.a((java.security.cert.Certificate) r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = "\n    DN: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.security.Principal r6 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = r6.getName()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = "\n    subjectAltNames: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.util.List r6 = com.bca.xco.widget.d.a.a.e.d.a(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            java.lang.String r6 = r1.toString()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            r0.<init>(r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
            throw r0     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        L_0x0106:
            r6 = move-exception
            goto L_0x011c
        L_0x0108:
            r6 = move-exception
            r0 = r7
            goto L_0x010f
        L_0x010b:
            r6 = move-exception
            r7 = r0
            goto L_0x011c
        L_0x010e:
            r6 = move-exception
        L_0x010f:
            boolean r7 = com.bca.xco.widget.d.a.a.c.a((java.lang.AssertionError) r6)     // Catch:{ all -> 0x010b }
            if (r7 == 0) goto L_0x011b
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x010b }
            r7.<init>(r6)     // Catch:{ all -> 0x010b }
            throw r7     // Catch:{ all -> 0x010b }
        L_0x011b:
            throw r6     // Catch:{ all -> 0x010b }
        L_0x011c:
            if (r7 == 0) goto L_0x0125
            com.bca.xco.widget.d.a.a.d.e r8 = com.bca.xco.widget.d.a.a.d.e.b()
            r8.b((javax.net.ssl.SSLSocket) r7)
        L_0x0125:
            com.bca.xco.widget.d.a.a.c.a((java.net.Socket) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.a.c.b(int, int, com.bca.xco.widget.d.a.a.a.b):void");
    }

    private x a(int i2, int i3, x xVar, t tVar) {
        String str = "CONNECT " + com.bca.xco.widget.d.a.a.c.a(tVar, true) + " HTTP/1.1";
        while (true) {
            com.bca.xco.widget.d.a.a.b.a aVar = new com.bca.xco.widget.d.a.a.b.a((s) null, (g) null, this.f4750d, this.f4751e);
            this.f4750d.a().a((long) i2, TimeUnit.MILLISECONDS);
            this.f4751e.a().a((long) i3, TimeUnit.MILLISECONDS);
            aVar.a(xVar.c(), str);
            aVar.b();
            z a2 = aVar.c().a(xVar).a();
            long a3 = f.a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            com.bca.xco.widget.d.b.d b2 = aVar.b(a3);
            com.bca.xco.widget.d.a.a.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int b3 = a2.b();
            if (b3 != 200) {
                if (b3 == 407) {
                    x a4 = this.k.a().d().a(this.k, a2);
                    if (a4 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(a2.a(HttpConstants.Header.CONNECTION))) {
                        return a4;
                    } else {
                        xVar = a4;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + a2.b());
                }
            } else if (this.f4750d.b().d() && this.f4751e.b().d()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private x e() {
        return new x.a().a(this.k.a().a()).a(HttpConstants.Header.HOST, com.bca.xco.widget.d.a.a.c.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a(HttpConstants.Header.USER_AGENT, com.bca.xco.widget.d.a.a.d.a()).b();
    }

    public ab a() {
        return this.k;
    }

    public Socket b() {
        return this.f4747a;
    }

    public boolean a(boolean z) {
        int soTimeout;
        if (this.f4747a.isClosed() || this.f4747a.isInputShutdown() || this.f4747a.isOutputShutdown()) {
            return false;
        }
        if (this.f4748b == null && z) {
            try {
                soTimeout = this.f4747a.getSoTimeout();
                this.f4747a.setSoTimeout(1);
                if (this.f4750d.d()) {
                    this.f4747a.setSoTimeout(soTimeout);
                    return false;
                }
                this.f4747a.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f4747a.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public void a(i iVar) {
        iVar.a(com.bca.xco.widget.d.a.a.g.c.REFUSED_STREAM);
    }

    public void a(h hVar) {
        this.f4752f = hVar.a();
    }

    public q c() {
        return this.m;
    }

    public boolean d() {
        return this.f4748b != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.k.a().a().f());
        sb.append(":");
        sb.append(this.k.a().a().g());
        sb.append(", proxy=");
        sb.append(this.k.b());
        sb.append(" hostAddress=");
        sb.append(this.k.c());
        sb.append(" cipherSuite=");
        q qVar = this.m;
        sb.append(qVar != null ? qVar.a() : ViewProps.NONE);
        sb.append(" protocol=");
        sb.append(this.n);
        sb.append('}');
        return sb.toString();
    }
}
