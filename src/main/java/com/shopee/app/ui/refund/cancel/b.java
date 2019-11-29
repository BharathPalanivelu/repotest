package com.shopee.app.ui.refund.cancel;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.cl;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;

public class b extends q<c> {

    /* renamed from: a  reason: collision with root package name */
    private final n f24941a;

    /* renamed from: c  reason: collision with root package name */
    private final cl f24942c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f24943d;

    /* renamed from: e  reason: collision with root package name */
    private e f24944e = new g() {
        public void onEvent(a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            if (orderDetail.getOrderId() == b.this.f24943d) {
                ((c) b.this.f19220b).a(orderDetail);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f24945f = new f() {
        public void a(a aVar) {
            if (b.this.f24943d == ((Long) aVar.data).longValue()) {
                b.this.e();
            }
        }
    };

    public b(n nVar, cl clVar) {
        this.f24941a = nVar;
        this.f24942c = clVar;
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f24942c.a(this.f24943d);
    }

    public void a() {
        this.f24941a.a("ORDER_DETAIL_LOCAL_LOAD", this.f24944e);
        this.f24941a.a("ORDER_DETAILS_SERVER_SAVED", this.f24945f);
    }

    public void b() {
        this.f24941a.b("ORDER_DETAIL_LOCAL_LOAD", this.f24944e);
        this.f24941a.b("ORDER_DETAILS_SERVER_SAVED", this.f24945f);
    }
}
