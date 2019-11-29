package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.a.d;
import com.bca.xco.widget.d.a.a.a.g;
import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.c.b;
import com.bca.xco.widget.d.a.a.d.e;
import com.bca.xco.widget.d.a.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class s implements Cloneable {
    /* access modifiers changed from: private */
    public static final List<n> A = c.a((T[]) new n[]{n.f5090a, n.f5091b, n.f5092c});
    /* access modifiers changed from: private */
    public static final List<v> z = c.a((T[]) new v[]{v.HTTP_2, v.HTTP_1_1});

    /* renamed from: a  reason: collision with root package name */
    final p f5121a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f5122b;

    /* renamed from: c  reason: collision with root package name */
    final List<v> f5123c;

    /* renamed from: d  reason: collision with root package name */
    final List<n> f5124d;

    /* renamed from: e  reason: collision with root package name */
    final List<g> f5125e;

    /* renamed from: f  reason: collision with root package name */
    final List<g> f5126f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f5127g;
    final e h;
    final i i;
    final b j;
    final SocketFactory k;
    final SSLSocketFactory l;
    final com.bca.xco.widget.d.a.a.e.b m;
    final HostnameVerifier n;
    final k o;
    final a p;
    final a q;
    final m r;
    final f s;
    final boolean t;
    final boolean u;
    final boolean v;
    final int w;
    final int x;
    final int y;

    static {
        com.bca.xco.widget.d.a.a.a.f4741a = new com.bca.xco.widget.d.a.a.a() {
            public void a(r.a aVar, String str) {
                aVar.a(str);
            }

            public void a(r.a aVar, String str, String str2) {
                aVar.b(str, str2);
            }

            public boolean b(m mVar, com.bca.xco.widget.d.a.a.a.c cVar) {
                return mVar.b(cVar);
            }

            public com.bca.xco.widget.d.a.a.a.c a(m mVar, h hVar, g gVar) {
                return mVar.a(hVar, gVar);
            }

            public void a(m mVar, com.bca.xco.widget.d.a.a.a.c cVar) {
                mVar.a(cVar);
            }

            public d a(m mVar) {
                return mVar.f5084a;
            }

            public void a(n nVar, SSLSocket sSLSocket, boolean z) {
                nVar.a(sSLSocket, z);
            }
        };
    }

    public s() {
        this(new a());
    }

    private s(a aVar) {
        boolean z2;
        this.f5121a = aVar.f5128a;
        this.f5122b = aVar.f5129b;
        this.f5123c = aVar.f5130c;
        this.f5124d = aVar.f5131d;
        this.f5125e = c.a(aVar.f5132e);
        this.f5126f = c.a(aVar.f5133f);
        this.f5127g = aVar.f5134g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        Iterator<n> it = this.f5124d.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                n next = it.next();
                if (z2 || next.a()) {
                    z2 = true;
                }
            }
        }
        if (aVar.l != null || !z2) {
            this.l = aVar.l;
            this.m = aVar.m;
        } else {
            X509TrustManager z3 = z();
            this.l = a(z3);
            this.m = com.bca.xco.widget.d.a.a.e.b.a(z3);
        }
        this.n = aVar.n;
        this.o = aVar.o.a(this.m);
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = aVar.y;
    }

    private X509TrustManager z() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public int a() {
        return this.w;
    }

    public int b() {
        return this.x;
    }

    public int c() {
        return this.y;
    }

    public Proxy d() {
        return this.f5122b;
    }

    public ProxySelector e() {
        return this.f5127g;
    }

    public e f() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public b g() {
        i iVar = this.i;
        return iVar != null ? iVar.f5051a : this.j;
    }

    public f h() {
        return this.s;
    }

    public SocketFactory i() {
        return this.k;
    }

    public SSLSocketFactory j() {
        return this.l;
    }

    public HostnameVerifier k() {
        return this.n;
    }

    public k l() {
        return this.o;
    }

    public a m() {
        return this.q;
    }

    public a n() {
        return this.p;
    }

    public m o() {
        return this.r;
    }

    public boolean p() {
        return this.t;
    }

    public boolean q() {
        return this.u;
    }

    public boolean r() {
        return this.v;
    }

    public p s() {
        return this.f5121a;
    }

    public List<v> t() {
        return this.f5123c;
    }

    public List<n> u() {
        return this.f5124d;
    }

    public List<g> v() {
        return this.f5125e;
    }

    public List<g> w() {
        return this.f5126f;
    }

    public b a(x xVar) {
        return new w(this, xVar);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        p f5128a = new p();

        /* renamed from: b  reason: collision with root package name */
        Proxy f5129b;

        /* renamed from: c  reason: collision with root package name */
        List<v> f5130c = s.z;

        /* renamed from: d  reason: collision with root package name */
        List<n> f5131d = s.A;

        /* renamed from: e  reason: collision with root package name */
        final List<g> f5132e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List<g> f5133f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        ProxySelector f5134g = ProxySelector.getDefault();
        e h = e.f5042a;
        i i;
        b j;
        SocketFactory k = SocketFactory.getDefault();
        SSLSocketFactory l;
        com.bca.xco.widget.d.a.a.e.b m;
        HostnameVerifier n = com.bca.xco.widget.d.a.a.e.d.f4866a;
        k o = k.f5067a;
        a p = a.f4740a;
        a q = a.f4740a;
        m r = new m();
        f s = f.f5043a;
        boolean t = true;
        boolean u = true;
        boolean v = true;
        int w = 10000;
        int x = 10000;
        int y = 10000;

        public a a(long j2, TimeUnit timeUnit) {
            if (j2 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j2);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || j2 <= 0) {
                    this.w = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public a b(long j2, TimeUnit timeUnit) {
            if (j2 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j2);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || j2 <= 0) {
                    this.x = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                X509TrustManager a2 = e.b().a(sSLSocketFactory);
                if (a2 != null) {
                    this.l = sSLSocketFactory;
                    this.m = com.bca.xco.widget.d.a.a.e.b.a(a2);
                    return this;
                }
                throw new IllegalStateException("Unable to extract the trust manager on " + e.b() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public a a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.n = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public a a(boolean z) {
            this.v = z;
            return this;
        }

        public a a(List<n> list) {
            this.f5131d = c.a(list);
            return this;
        }

        public s a() {
            return new s(this);
        }
    }
}
