package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.q;
import java.util.ArrayList;
import java.util.List;

public class r implements b, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final String f3457a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a.C0069a> f3458b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final q.a f3459c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, Float> f3460d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, Float> f3461e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, Float> f3462f;

    public void a(List<b> list, List<b> list2) {
    }

    public r(com.airbnb.lottie.c.c.a aVar, q qVar) {
        this.f3457a = qVar.a();
        this.f3459c = qVar.b();
        this.f3460d = qVar.d().a();
        this.f3461e = qVar.c().a();
        this.f3462f = qVar.e().a();
        aVar.a((a<?, ?>) this.f3460d);
        aVar.a((a<?, ?>) this.f3461e);
        aVar.a((a<?, ?>) this.f3462f);
        this.f3460d.a((a.C0069a) this);
        this.f3461e.a((a.C0069a) this);
        this.f3462f.a((a.C0069a) this);
    }

    public void a() {
        for (int i = 0; i < this.f3458b.size(); i++) {
            this.f3458b.get(i).a();
        }
    }

    public String b() {
        return this.f3457a;
    }

    /* access modifiers changed from: package-private */
    public void a(a.C0069a aVar) {
        this.f3458b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public q.a c() {
        return this.f3459c;
    }

    public a<?, Float> d() {
        return this.f3460d;
    }

    public a<?, Float> e() {
        return this.f3461e;
    }

    public a<?, Float> f() {
        return this.f3462f;
    }
}
