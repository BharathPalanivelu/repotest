package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.t;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    final t f5044a;

    /* renamed from: b  reason: collision with root package name */
    final f f5045b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f5046c;

    /* renamed from: d  reason: collision with root package name */
    final a f5047d;

    /* renamed from: e  reason: collision with root package name */
    final List<v> f5048e;

    /* renamed from: f  reason: collision with root package name */
    final List<n> f5049f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f5050g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final k k;

    public h(String str, int i2, f fVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, a aVar, Proxy proxy, List<v> list, List<n> list2, ProxySelector proxySelector) {
        this.f5044a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        if (fVar != null) {
            this.f5045b = fVar;
            if (socketFactory != null) {
                this.f5046c = socketFactory;
                if (aVar != null) {
                    this.f5047d = aVar;
                    if (list != null) {
                        this.f5048e = c.a(list);
                        if (list2 != null) {
                            this.f5049f = c.a(list2);
                            if (proxySelector != null) {
                                this.f5050g = proxySelector;
                                this.h = proxy;
                                this.i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = kVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public t a() {
        return this.f5044a;
    }

    public f b() {
        return this.f5045b;
    }

    public SocketFactory c() {
        return this.f5046c;
    }

    public a d() {
        return this.f5047d;
    }

    public List<v> e() {
        return this.f5048e;
    }

    public List<n> f() {
        return this.f5049f;
    }

    public ProxySelector g() {
        return this.f5050g;
    }

    public Proxy h() {
        return this.h;
    }

    public SSLSocketFactory i() {
        return this.i;
    }

    public HostnameVerifier j() {
        return this.j;
    }

    public k k() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f5044a.equals(hVar.f5044a) || !this.f5045b.equals(hVar.f5045b) || !this.f5047d.equals(hVar.f5047d) || !this.f5048e.equals(hVar.f5048e) || !this.f5049f.equals(hVar.f5049f) || !this.f5050g.equals(hVar.f5050g) || !c.a((Object) this.h, (Object) hVar.h) || !c.a((Object) this.i, (Object) hVar.i) || !c.a((Object) this.j, (Object) hVar.j) || !c.a((Object) this.k, (Object) hVar.k)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f5044a.hashCode()) * 31) + this.f5045b.hashCode()) * 31) + this.f5047d.hashCode()) * 31) + this.f5048e.hashCode()) * 31) + this.f5049f.hashCode()) * 31) + this.f5050g.hashCode()) * 31;
        Proxy proxy = this.h;
        int i2 = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        if (kVar != null) {
            i2 = kVar.hashCode();
        }
        return hashCode4 + i2;
    }
}
