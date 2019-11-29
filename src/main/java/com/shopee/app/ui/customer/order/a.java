package com.shopee.app.ui.customer.order;

import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.cm;
import com.shopee.app.d.c.l;
import com.shopee.app.data.viewmodel.CustomerOrderInfo;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.network.d.aa;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.order.k;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class a extends q<c> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    private final n f21427a;

    /* renamed from: c  reason: collision with root package name */
    private final bi f21428c;

    /* renamed from: d  reason: collision with root package name */
    private final l f21429d;

    /* renamed from: e  reason: collision with root package name */
    private final k f21430e;

    /* renamed from: f  reason: collision with root package name */
    private final cm f21431f;

    /* renamed from: g  reason: collision with root package name */
    private final int f21432g = 1;
    private final int h = 6;
    private int i;
    private int j;
    /* access modifiers changed from: private */
    public List<OrderDetail> k = new ArrayList();
    /* access modifiers changed from: private */
    public int l;
    private int m = 0;
    private e n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            CustomerOrderInfo customerOrderInfo = (CustomerOrderInfo) aVar.data;
            List unused = a.this.k = customerOrderInfo.getOrderDetailList();
            ((c) a.this.f19220b).a(customerOrderInfo);
            if (a.this.k.size() + 1 == a.this.l) {
                ((c) a.this.f19220b).e();
            } else {
                ((c) a.this.f19220b).f();
            }
        }
    };
    private e o = new f() {
        public void a(com.garena.android.appkit.b.a aVar) {
            a.this.f();
        }
    };

    public a(n nVar, bi biVar, k kVar, cm cmVar, l lVar) {
        this.f21427a = nVar;
        this.f21428c = biVar;
        this.f21430e = kVar;
        this.f21431f = cmVar;
        this.f21429d = lVar;
    }

    public void a(int i2, int i3) {
        this.i = i2;
        this.j = i3;
        e();
        f();
    }

    /* access modifiers changed from: private */
    public void f() {
        ((c) this.f19220b).d();
        this.f21429d.a(this.i, this.j);
    }

    public void e() {
        aa aaVar = new aa();
        aaVar.h();
        List<OrderDetail> list = this.k;
        if (list == null || list.isEmpty()) {
            aaVar.a(this.i, 0, 20);
        } else {
            aaVar.a(this.i, this.m, 20);
        }
    }

    public void a() {
        this.f21427a.a("ORDER_DETAILS_SERVER_SAVED", this.o);
        this.f21427a.a("CUSTOMER_ORDER_LIST_SAVED", this.o);
        this.f21427a.a("CUSTOMER_ORDER_LIST_LOCAL_LOAD", this.n);
        this.f21427a.a("BATCH_ITEM_LOAD", this.o);
        this.f21427a.a("ITEM_SNAPSHOT_LOAD", this.o);
        this.f21427a.a("GET_USER_INFO_LOAD", this.o);
        this.f21427a.a("PAYMENT_RECEIVED_SUCCESS", this.o);
        this.f21427a.a("SHIP_ORDER_SUCCESS", this.o);
        this.f21427a.a("SHIPMENT_RECEIVED_SUCCESS", this.o);
    }

    public void c() {
        this.f21430e.a();
    }

    public void d() {
        this.f21430e.b();
    }

    public void b() {
        this.f21427a.b("CUSTOMER_ORDER_LIST_LOCAL_LOAD", this.n);
        this.f21427a.b("CUSTOMER_ORDER_LIST_SAVED", this.o);
        this.f21427a.b("ORDER_DETAILS_SERVER_SAVED", this.o);
        this.f21427a.b("BATCH_ITEM_LOAD", this.o);
        this.f21427a.b("ITEM_SNAPSHOT_LOAD", this.o);
        this.f21427a.b("GET_USER_INFO_LOAD", this.o);
        this.f21427a.b("PAYMENT_RECEIVED_SUCCESS", this.o);
        this.f21427a.b("SHIP_ORDER_SUCCESS", this.o);
        this.f21427a.b("SHIPMENT_RECEIVED_SUCCESS", this.o);
    }

    public void c(int i2) {
        this.l = i2;
        this.m += 20;
        e();
    }
}
