package com.shopee.app.ui.chat.order;

import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.cl;
import com.shopee.app.d.c.dq;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.order.detail.h;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;

public class a extends q<b> {

    /* renamed from: a  reason: collision with root package name */
    e f20168a = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            OrderDetail unused = a.this.m = orderDetail;
            if (orderDetail.getOrderId() == a.this.j) {
                ((b) a.this.f19220b).setOrderInfo(orderDetail);
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    e f20169c = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (((h) aVar).f23629b == 4) {
                ((b) a.this.f19220b).e();
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    e f20170d = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (((Long) aVar.data).longValue() == a.this.j) {
                a aVar2 = a.this;
                aVar2.a(aVar2.j);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    e f20171e = new f() {
        public void a(com.garena.android.appkit.b.a aVar) {
            a aVar2 = a.this;
            aVar2.a(aVar2.j);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final cl f20172f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final dq f20173g;
    private final n h;
    private final bi i;
    /* access modifiers changed from: private */
    public long j;
    /* access modifiers changed from: private */
    public long k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public OrderDetail m;
    private e n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.f20173g.a(a.this.k, a.this.j, a.this.l, (OrderItemInfo) aVar.data);
        }
    };

    public a(bi biVar, n nVar, cl clVar, dq dqVar) {
        this.f20172f = clVar;
        this.f20173g = dqVar;
        this.h = nVar;
        this.i = biVar;
    }

    /* access modifiers changed from: private */
    public void a(long j2) {
        this.f20172f.a(j2);
    }

    public void a() {
        this.h.a("ORDER_DETAIL_LOCAL_LOAD", this.f20168a);
        this.h.a("ORDER_DETAILS_SERVER_SAVED", this.f20170d);
        this.h.a("ITEM_DETAIL_ITEMS_ERROR", this.f20169c);
        this.h.a("BATCH_ITEM_LOAD", this.f20171e);
        this.h.a("ITEM_SNAPSHOT_LOAD", this.f20171e);
    }

    public void c() {
        this.i.a("ORDER_CHAT_PRODUCT_SEND", this.n);
    }

    public void d() {
        this.i.b("ORDER_CHAT_PRODUCT_SEND", this.n);
    }

    public void b() {
        this.h.b("ORDER_DETAIL_LOCAL_LOAD", this.f20168a);
        this.h.b("ORDER_DETAILS_SERVER_SAVED", this.f20170d);
        this.h.b("ITEM_DETAIL_ITEMS_ERROR", this.f20169c);
        this.h.b("BATCH_ITEM_LOAD", this.f20171e);
        this.h.b("ITEM_SNAPSHOT_LOAD", this.f20171e);
    }
}
