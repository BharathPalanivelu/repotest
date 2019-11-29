package com.shopee.app.d.c;

import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.b.a;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.b;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.c.e;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBRefund;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class bd extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bh f16557c;

    /* renamed from: d  reason: collision with root package name */
    private final c f16558d;

    /* renamed from: e  reason: collision with root package name */
    private final ah f16559e;

    /* renamed from: f  reason: collision with root package name */
    private final ao f16560f;

    /* renamed from: g  reason: collision with root package name */
    private final at f16561g;
    private final b h;
    private final e i;
    private final bb j;
    private int k;
    private OrderKey l;

    /* access modifiers changed from: protected */
    public String d() {
        return "MyOrdersInteractor";
    }

    public bd(n nVar, bh bhVar, c cVar, e eVar, b bVar, ah ahVar, ao aoVar, at atVar, bb bbVar) {
        super(nVar);
        this.f16557c = bhVar;
        this.f16558d = cVar;
        this.i = eVar;
        this.h = bVar;
        this.f16559e = ahVar;
        this.f16560f = aoVar;
        this.f16561g = atVar;
        this.j = bbVar;
    }

    public void a(OrderKey orderKey, int i2) {
        this.l = orderKey;
        this.k = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<Long> a2 = this.h.a(this.l);
        List<Long> a3 = this.f16561g.a(this.l);
        List<DBOrderDetail> d2 = this.f16558d.d(a2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (DBOrderDetail next : d2) {
            if (next != null) {
                List<DBRefund> c2 = this.i.c(next.a());
                DBReturnItem d3 = this.i.d(next.a());
                OrderDetail orderDetail = new OrderDetail();
                DBUserInfo a4 = this.f16557c.a(next.c());
                if (a4 == null) {
                    arrayList3.add(Integer.valueOf(next.c()));
                }
                DBUserInfo a5 = this.f16557c.a(next.E());
                if (a5 == null) {
                    arrayList3.add(Integer.valueOf(next.E()));
                }
                if (this.f16557c.c(next.E())) {
                    com.shopee.app.d.b.b.a(next, a4, orderDetail);
                } else {
                    com.shopee.app.d.b.b.a(next, a5, orderDetail);
                }
                long firstItemSnapshotId = orderDetail.getFirstItemSnapshotId();
                if (firstItemSnapshotId > 0) {
                    DBItemSnapShot c3 = this.f16559e.c(firstItemSnapshotId);
                    if (c3 == null) {
                        new aq().a(next.b(), firstItemSnapshotId);
                    } else {
                        a.a(c3, this.f16560f, orderDetail);
                    }
                } else {
                    a.a((DBItemSnapShot) null, this.f16560f, orderDetail);
                }
                int i2 = -1;
                if (orderDetail.isComplete() && !orderDetail.isSelling() && this.j.d(orderDetail.getOrderId())) {
                    i2 = this.j.b();
                }
                orderDetail.setShowRating(i2);
                orderDetail.setReturnItem(d3);
                orderDetail.setRefunds(c2);
                if (a3.contains(Long.valueOf(next.a()))) {
                    orderDetail.setUnread(true);
                    arrayList2.add(orderDetail);
                } else {
                    orderDetail.setUnread(false);
                    arrayList2.add(orderDetail);
                }
            }
        }
        if (arrayList3.size() > 0) {
            new au().a((List<Integer>) arrayList3);
        }
        arrayList.addAll(arrayList2);
        this.f16402a.a("ORDER_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.a) new com.shopee.app.ui.order.a.b(this.l, arrayList));
    }
}
