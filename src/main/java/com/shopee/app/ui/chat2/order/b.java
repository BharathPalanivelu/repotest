package com.shopee.app.ui.chat2.order;

import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.bm;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.h.j;
import com.shopee.app.network.d.h.k;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import java.util.ArrayList;
import java.util.List;

public class b extends q<f> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    private final bm f20646a;

    /* renamed from: c  reason: collision with root package name */
    private i f20647c = com.garena.a.a.a.b.a(this);

    /* renamed from: d  reason: collision with root package name */
    private int f20648d;

    /* renamed from: e  reason: collision with root package name */
    private int f20649e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<OrderDetail> f20650f;

    /* renamed from: g  reason: collision with root package name */
    private int f20651g;
    private int h;

    public b(bm bmVar) {
        this.f20646a = bmVar;
    }

    public void a(int i, int i2) {
        this.f20649e = i;
        this.h = i2;
        a(false);
        f();
    }

    private void f() {
        if (this.f20649e > 0) {
            k kVar = new k();
            o.a().a((az) kVar);
            kVar.a(this.f20649e, this.f20648d, 20);
        } else if (this.h > 0) {
            j jVar = new j();
            o.a().a((az) jVar);
            jVar.a(this.h, this.f20648d, 20);
        }
    }

    private void a(boolean z) {
        ((f) this.f19220b).g();
        this.f20646a.a(this.f20649e, this.h, 20, z);
    }

    public void a() {
        this.f20647c.a();
    }

    public void b() {
        this.f20647c.b();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void a(bm.b bVar) {
        if (bVar.f16601b == this.f20649e || bVar.f16600a == this.h) {
            this.f20650f = new ArrayList<>(bVar.f16602c);
            ((f) this.f19220b).a((List<OrderDetail>) this.f20650f);
            if (this.f20650f.size() + 1 == this.f20651g) {
                ((f) this.f19220b).e();
            } else {
                ((f) this.f19220b).f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        if (this.f20649e == i) {
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        if (this.h == i) {
            a(true);
        }
    }

    public void c(int i) {
        this.f20651g = i;
        this.f20648d += 20;
        f();
    }
}
