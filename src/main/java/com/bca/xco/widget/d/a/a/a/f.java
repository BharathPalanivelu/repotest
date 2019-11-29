package com.bca.xco.widget.d.a.a.a;

import com.bca.xco.widget.d.a.ab;
import com.bca.xco.widget.d.a.h;
import com.bca.xco.widget.d.a.t;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final h f4757a;

    /* renamed from: b  reason: collision with root package name */
    private final d f4758b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f4759c;

    /* renamed from: d  reason: collision with root package name */
    private InetSocketAddress f4760d;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f4761e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private int f4762f;

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f4763g = Collections.emptyList();
    private int h;
    private final List<ab> i = new ArrayList();

    public f(h hVar, d dVar) {
        this.f4757a = hVar;
        this.f4758b = dVar;
        a(hVar.a(), hVar.h());
    }

    public boolean a() {
        return e() || c() || g();
    }

    public ab b() {
        if (!e()) {
            if (c()) {
                this.f4759c = d();
            } else if (g()) {
                return h();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.f4760d = f();
        ab abVar = new ab(this.f4757a, this.f4759c, this.f4760d);
        if (!this.f4758b.c(abVar)) {
            return abVar;
        }
        this.i.add(abVar);
        return b();
    }

    public void a(ab abVar, IOException iOException) {
        if (!(abVar.b().type() == Proxy.Type.DIRECT || this.f4757a.g() == null)) {
            this.f4757a.g().connectFailed(this.f4757a.a().a(), abVar.b().address(), iOException);
        }
        this.f4758b.a(abVar);
    }

    private void a(t tVar, Proxy proxy) {
        if (proxy != null) {
            this.f4761e = Collections.singletonList(proxy);
        } else {
            this.f4761e = new ArrayList();
            List<Proxy> select = this.f4757a.g().select(tVar.a());
            if (select != null) {
                this.f4761e.addAll(select);
            }
            this.f4761e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f4761e.add(Proxy.NO_PROXY);
        }
        this.f4762f = 0;
    }

    private boolean c() {
        return this.f4762f < this.f4761e.size();
    }

    private Proxy d() {
        if (c()) {
            List<Proxy> list = this.f4761e;
            int i2 = this.f4762f;
            this.f4762f = i2 + 1;
            Proxy proxy = list.get(i2);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f4757a.a().f() + "; exhausted proxy configurations: " + this.f4761e);
    }

    private void a(Proxy proxy) {
        String str;
        int i2;
        this.f4763g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f4757a.a().f();
            i2 = this.f4757a.a().g();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = a(inetSocketAddress);
                i2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i2 < 1 || i2 > 65535) {
            throw new SocketException("No route to " + str + ":" + i2 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f4763g.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            List<InetAddress> a2 = this.f4757a.b().a(str);
            int size = a2.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f4763g.add(new InetSocketAddress(a2.get(i3), i2));
            }
        }
        this.h = 0;
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean e() {
        return this.h < this.f4763g.size();
    }

    private InetSocketAddress f() {
        if (e()) {
            List<InetSocketAddress> list = this.f4763g;
            int i2 = this.h;
            this.h = i2 + 1;
            return list.get(i2);
        }
        throw new SocketException("No route to " + this.f4757a.a().f() + "; exhausted inet socket addresses: " + this.f4763g);
    }

    private boolean g() {
        return !this.i.isEmpty();
    }

    private ab h() {
        return this.i.remove(0);
    }
}
