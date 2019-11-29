package com.bca.xco.widget.d.a.a.g;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.f.i;
import com.bca.xco.widget.d.a.a.f.j;
import com.bca.xco.widget.d.a.a.f.l;
import com.bca.xco.widget.d.a.aa;
import com.bca.xco.widget.d.a.r;
import com.bca.xco.widget.d.a.s;
import com.bca.xco.widget.d.a.v;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.z;
import com.bca.xco.widget.d.b.d;
import com.bca.xco.widget.d.b.h;
import com.bca.xco.widget.d.b.m;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class g implements com.bca.xco.widget.d.a.a.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final h f4937a = h.a("connection");

    /* renamed from: b  reason: collision with root package name */
    private static final h f4938b = h.a("host");

    /* renamed from: c  reason: collision with root package name */
    private static final h f4939c = h.a("keep-alive");

    /* renamed from: d  reason: collision with root package name */
    private static final h f4940d = h.a("proxy-connection");

    /* renamed from: e  reason: collision with root package name */
    private static final h f4941e = h.a("transfer-encoding");

    /* renamed from: f  reason: collision with root package name */
    private static final h f4942f = h.a("te");

    /* renamed from: g  reason: collision with root package name */
    private static final h f4943g = h.a("encoding");
    private static final h h = h.a("upgrade");
    private static final List<h> i = c.a((T[]) new h[]{f4937a, f4938b, f4939c, f4940d, f4942f, f4941e, f4943g, h, d.f4911b, d.f4912c, d.f4913d, d.f4914e});
    private static final List<h> j = c.a((T[]) new h[]{f4937a, f4938b, f4939c, f4940d, f4942f, f4941e, f4943g, h});
    private final s k;
    /* access modifiers changed from: private */
    public final com.bca.xco.widget.d.a.a.a.g l;
    private final h m;
    private i n;

    public g(s sVar, com.bca.xco.widget.d.a.a.a.g gVar, h hVar) {
        this.k = sVar;
        this.l = gVar;
        this.m = hVar;
    }

    public com.bca.xco.widget.d.b.c a(x xVar, long j2) {
        return this.n.h();
    }

    public void a(x xVar) {
        if (this.n == null) {
            boolean c2 = com.bca.xco.widget.d.a.a.f.g.c(xVar.b());
            this.n = this.m.a(b(xVar), c2);
            this.n.e().a((long) this.k.b(), TimeUnit.MILLISECONDS);
            this.n.f().a((long) this.k.c(), TimeUnit.MILLISECONDS);
        }
    }

    public void b() {
        this.n.h().close();
    }

    public z.a a() {
        return a(this.n.d());
    }

    public static List<d> b(x xVar) {
        r c2 = xVar.c();
        ArrayList arrayList = new ArrayList(c2.a() + 4);
        arrayList.add(new d(d.f4911b, xVar.b()));
        arrayList.add(new d(d.f4912c, j.a(xVar.a())));
        arrayList.add(new d(d.f4914e, c.a(xVar.a(), false)));
        arrayList.add(new d(d.f4913d, xVar.a().b()));
        int a2 = c2.a();
        for (int i2 = 0; i2 < a2; i2++) {
            h a3 = h.a(c2.a(i2).toLowerCase(Locale.US));
            if (!i.contains(a3)) {
                arrayList.add(new d(a3, c2.b(i2)));
            }
        }
        return arrayList;
    }

    public static z.a a(List<d> list) {
        r.a aVar = new r.a();
        int size = list.size();
        String str = null;
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = list.get(i2).f4915f;
            String a2 = list.get(i2).f4916g.a();
            if (hVar.equals(d.f4910a)) {
                str = a2;
            } else if (!j.contains(hVar)) {
                com.bca.xco.widget.d.a.a.a.f4741a.a(aVar, hVar.a(), a2);
            }
        }
        if (str != null) {
            l a3 = l.a("HTTP/1.1 " + str);
            return new z.a().a(v.HTTP_2).a(a3.f4889b).a(a3.f4890c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public aa a(z zVar) {
        return new i(zVar.d(), m.a((d) new a(this.n.g())));
    }

    class a extends com.bca.xco.widget.d.b.i {
        public a(d dVar) {
            super(dVar);
        }

        public void close() {
            g.this.l.a(false, (com.bca.xco.widget.d.a.a.f.a) g.this);
            super.close();
        }
    }
}
