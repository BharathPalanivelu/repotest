package com.shopee.app.ui.refund.detail;

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
    private final n f24963a;

    /* renamed from: c  reason: collision with root package name */
    private final cl f24964c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f24965d;

    /* renamed from: e  reason: collision with root package name */
    private e f24966e = new g() {
        public void onEvent(a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            if (orderDetail.getOrderId() == b.this.f24965d) {
                ((c) b.this.f19220b).a(orderDetail);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f24967f = new f() {
        public void a(a aVar) {
            if (b.this.f24965d == ((Long) aVar.data).longValue()) {
                b.this.e();
            }
        }
    };

    public b(n nVar, cl clVar) {
        this.f24963a = nVar;
        this.f24964c = clVar;
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f24964c.a(this.f24965d);
    }

    public void a() {
        this.f24963a.a("ORDER_DETAIL_LOCAL_LOAD", this.f24966e);
        this.f24963a.a("ORDER_DETAILS_SERVER_SAVED", this.f24967f);
    }

    public void b() {
        this.f24963a.b("ORDER_DETAIL_LOCAL_LOAD", this.f24966e);
        this.f24963a.b("ORDER_DETAILS_SERVER_SAVED", this.f24967f);
    }
}
