package com.shopee.app.d.c;

import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.h.b;
import com.shopee.app.network.d.h.c;
import com.shopee.app.network.d.h.d;
import com.shopee.app.network.d.h.e;
import com.shopee.app.network.d.h.r;
import com.shopee.app.network.d.h.s;
import com.shopee.app.util.n;

public class cm extends a {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16697c;

    /* renamed from: d  reason: collision with root package name */
    private long f16698d;

    /* renamed from: e  reason: collision with root package name */
    private int f16699e;

    /* access modifiers changed from: protected */
    public String d() {
        return "OrderUpdateInteractor";
    }

    protected cm(n nVar) {
        super(nVar);
    }

    public void a(OrderDetail orderDetail, long j) {
        this.f16697c = orderDetail;
        this.f16698d = j;
        this.f16699e = 0;
        a();
    }

    public void a(OrderDetail orderDetail) {
        this.f16697c = orderDetail;
        this.f16699e = 1;
        a();
    }

    public void b(OrderDetail orderDetail) {
        this.f16697c = orderDetail;
        this.f16699e = 2;
        a();
    }

    public void c(OrderDetail orderDetail) {
        this.f16697c = orderDetail;
        this.f16699e = 4;
        a();
    }

    public void d(OrderDetail orderDetail) {
        this.f16697c = orderDetail;
        this.f16699e = 5;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        int i = this.f16699e;
        if (i == 0) {
            h();
        } else if (i == 1) {
            f();
        } else if (i == 2) {
            e();
        } else if (i == 3) {
            g();
        } else if (i == 4) {
            i();
        } else if (i == 5) {
            j();
        }
    }

    private void e() {
        new d().a(this.f16697c.getShopId(), this.f16697c.getOrderId());
    }

    private void f() {
        new s().a(this.f16697c.getOrderId(), this.f16697c.getActualCarrier(), this.f16697c.getShippingTraceNo(), this.f16697c.getRemark());
    }

    private void g() {
        new b().a(this.f16697c.getOrderId(), this.f16697c.getShopId(), 2);
    }

    private void h() {
        new r().a(this.f16697c.getShopId(), this.f16697c.getOrderId(), this.f16698d);
    }

    private void i() {
        c cVar = new c();
        cVar.a(this.f16697c.getShopId(), this.f16697c.getOrderId());
        o.a().a((az) cVar);
    }

    private void j() {
        new e().a(this.f16697c.getOrderId());
    }
}
