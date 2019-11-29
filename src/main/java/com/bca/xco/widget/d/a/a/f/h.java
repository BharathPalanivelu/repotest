package com.bca.xco.widget.d.a.a.f;

import com.bca.xco.widget.d.a.d;
import com.bca.xco.widget.d.a.g;
import com.bca.xco.widget.d.a.t;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.z;
import java.util.List;

public final class h implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<g> f4875a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bca.xco.widget.d.a.a.a.g f4876b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4877c;

    /* renamed from: d  reason: collision with root package name */
    private final d f4878d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4879e;

    /* renamed from: f  reason: collision with root package name */
    private final x f4880f;

    /* renamed from: g  reason: collision with root package name */
    private int f4881g;

    public h(List<g> list, com.bca.xco.widget.d.a.a.a.g gVar, a aVar, d dVar, int i, x xVar) {
        this.f4875a = list;
        this.f4878d = dVar;
        this.f4876b = gVar;
        this.f4877c = aVar;
        this.f4879e = i;
        this.f4880f = xVar;
    }

    public com.bca.xco.widget.d.a.a.a.g b() {
        return this.f4876b;
    }

    public a c() {
        return this.f4877c;
    }

    public x a() {
        return this.f4880f;
    }

    public z a(x xVar) {
        return a(xVar, this.f4876b, this.f4877c, this.f4878d);
    }

    public z a(x xVar, com.bca.xco.widget.d.a.a.a.g gVar, a aVar, d dVar) {
        if (this.f4879e < this.f4875a.size()) {
            this.f4881g++;
            if (this.f4877c != null && !a(xVar.a())) {
                throw new IllegalStateException("network interceptor " + this.f4875a.get(this.f4879e - 1) + " must retain the same host and port");
            } else if (this.f4877c == null || this.f4881g <= 1) {
                h hVar = new h(this.f4875a, gVar, aVar, dVar, this.f4879e + 1, xVar);
                g gVar2 = this.f4875a.get(this.f4879e);
                z a2 = gVar2.a(hVar);
                if (aVar != null && this.f4879e + 1 < this.f4875a.size() && hVar.f4881g != 1) {
                    throw new IllegalStateException("network interceptor " + gVar2 + " must call proceed() exactly once");
                } else if (a2 != null) {
                    return a2;
                } else {
                    throw new NullPointerException("interceptor " + gVar2 + " returned null");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f4875a.get(this.f4879e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    private boolean a(t tVar) {
        return tVar.f().equals(this.f4878d.a().a().a().f()) && tVar.g() == this.f4878d.a().a().a().g();
    }
}
