package com.shopee.app.ui.product.comment;

import com.garena.a.a.a.b;
import com.shopee.app.c.a;
import com.shopee.app.d.c.aj;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.y;
import com.shopee.app.ui.a.q;

public class i extends q<p> {

    /* renamed from: a  reason: collision with root package name */
    private final aj f24515a;

    /* renamed from: c  reason: collision with root package name */
    private int f24516c;

    /* renamed from: d  reason: collision with root package name */
    private long f24517d;

    /* renamed from: e  reason: collision with root package name */
    private final com.garena.android.appkit.b.i f24518e = b.a(this);

    /* renamed from: f  reason: collision with root package name */
    private int f24519f;

    /* renamed from: g  reason: collision with root package name */
    private int f24520g;

    i(aj ajVar) {
        this.f24515a = ajVar;
    }

    public void a() {
        this.f24518e.a();
    }

    public void b() {
        this.f24518e.b();
    }

    public void c() {
        this.f24518e.c();
    }

    public void d() {
        this.f24518e.d();
        a.a(((p) this.f19220b).getContext());
    }

    /* access modifiers changed from: package-private */
    public void a(int i, long j) {
        this.f24516c = i;
        this.f24517d = j;
        this.f24519f = 10;
        this.f24520g = 0;
        o.a().a((az) new y().a(i).a(this.f24517d).b(0).a(false).c(0).b(true).a());
        e();
    }

    private void e() {
        this.f24515a.a(this.f24516c, this.f24517d, this.f24519f != 10, this.f24519f, this.f24520g);
    }

    /* access modifiers changed from: package-private */
    public void a(aj.b bVar) {
        ((p) this.f19220b).a(bVar);
    }
}
