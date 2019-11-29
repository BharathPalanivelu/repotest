package com.bca.xco.widget.d.a;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    final h f5033a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f5034b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f5035c;

    public ab(h hVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (hVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f5033a = hVar;
            this.f5034b = proxy;
            this.f5035c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public h a() {
        return this.f5033a;
    }

    public Proxy b() {
        return this.f5034b;
    }

    public InetSocketAddress c() {
        return this.f5035c;
    }

    public boolean d() {
        return this.f5033a.i != null && this.f5034b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        if (!this.f5033a.equals(abVar.f5033a) || !this.f5034b.equals(abVar.f5034b) || !this.f5035c.equals(abVar.f5035c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((527 + this.f5033a.hashCode()) * 31) + this.f5034b.hashCode()) * 31) + this.f5035c.hashCode();
    }
}
