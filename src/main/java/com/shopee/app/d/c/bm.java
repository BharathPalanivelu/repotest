package com.shopee.app.d.c;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.c.e;
import com.shopee.app.data.store.r;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.CheckoutOrderInfo;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBRefund;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.h.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class bm extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final bh f16592d;

    /* renamed from: e  reason: collision with root package name */
    private final c f16593e;

    /* renamed from: f  reason: collision with root package name */
    private final ah f16594f;

    /* renamed from: g  reason: collision with root package name */
    private final ao f16595g;
    private final com.shopee.app.data.store.c.b h;
    private final r i;
    private final SettingConfigStore j;
    private final e k;
    private final bb l;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f16600a = -99;

        /* renamed from: b  reason: collision with root package name */
        public int f16601b = -99;

        /* renamed from: c  reason: collision with root package name */
        public List<OrderDetail> f16602c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16603d = false;
    }

    public bm(n nVar, bh bhVar, c cVar, r rVar, e eVar, SettingConfigStore settingConfigStore, com.shopee.app.data.store.c.b bVar, ah ahVar, ao aoVar, bb bbVar) {
        super(nVar);
        this.f16592d = bhVar;
        this.f16593e = cVar;
        this.i = rVar;
        this.k = eVar;
        this.j = settingConfigStore;
        this.h = bVar;
        this.f16594f = ahVar;
        this.f16595g = aoVar;
        this.l = bbVar;
    }

    public void a(int i2, int i3, int i4, boolean z) {
        b(new a(i2, i3, false, false, z));
    }

    public void a(int i2, int i3, int i4, boolean z, boolean z2) {
        b(new a(i2, i3, z, z2, true));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        List arrayList = new ArrayList();
        if (aVar.f16596a > 0) {
            arrayList = this.h.a(aVar.f16596a);
        } else if (aVar.f16597b > 0) {
            arrayList = this.h.b(aVar.f16597b);
        }
        List<DBOrderDetail> d2 = this.f16593e.d(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (DBOrderDetail next : d2) {
            if (next != null) {
                List<DBRefund> c2 = this.k.c(next.a());
                OrderDetail orderDetail = new OrderDetail();
                DBUserInfo a2 = this.f16592d.a(next.c());
                if (a2 == null) {
                    arrayList4.add(Integer.valueOf(next.c()));
                }
                DBUserInfo a3 = this.f16592d.a(next.E());
                if (a3 == null) {
                    arrayList4.add(Integer.valueOf(next.E()));
                }
                if (this.f16592d.c(next.E())) {
                    com.shopee.app.d.b.b.a(next, a2, orderDetail);
                } else {
                    com.shopee.app.d.b.b.a(next, a3, orderDetail);
                }
                long firstItemSnapshotId = orderDetail.getFirstItemSnapshotId();
                if (firstItemSnapshotId > 0) {
                    DBItemSnapShot c3 = this.f16594f.c(firstItemSnapshotId);
                    if (c3 == null) {
                        new aq().a(next.b(), firstItemSnapshotId);
                    } else {
                        com.shopee.app.data.store.b.a.a(c3, this.f16595g, orderDetail);
                    }
                } else {
                    com.shopee.app.data.store.b.a.a((DBItemSnapShot) null, this.f16595g, orderDetail);
                }
                if (orderDetail.getCheckoutId() > 0) {
                    DBCheckoutItem a4 = this.i.a(orderDetail.getCheckoutId());
                    if (a4 == null) {
                        arrayList5.add(Long.valueOf(orderDetail.getCheckoutId()));
                    } else {
                        CheckoutItem checkoutItem = new CheckoutItem();
                        com.shopee.app.d.b.b.a(a4, (List<OrderDetail>) null, (List<CheckoutOrderInfo>) new ArrayList(), this.j.getChangePaymentOption(), checkoutItem);
                        orderDetail.setCheckoutItem(checkoutItem);
                    }
                }
                int i2 = -1;
                if (orderDetail.isComplete() && !orderDetail.isSelling() && this.l.d(orderDetail.getOrderId())) {
                    i2 = this.l.b();
                }
                orderDetail.setShowRating(i2);
                orderDetail.setRefunds(c2);
                orderDetail.setUnread(false);
                arrayList3.add(orderDetail);
            }
        }
        if (arrayList4.size() > 0) {
            new au().a((List<Integer>) arrayList4);
        }
        if (!af.a(arrayList5) && aVar.i) {
            new f().a(arrayList5);
        }
        arrayList2.addAll(arrayList3);
        b bVar = new b();
        bVar.f16600a = aVar.f16597b;
        bVar.f16601b = aVar.f16596a;
        bVar.f16602c = arrayList3;
        bVar.f16603d = aVar.f16599d;
        this.f16405a.a().di.a(bVar).a();
        if (aVar.f16598c) {
            this.f16405a.a().bb.a(bVar).a();
        }
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public int f16596a;

        /* renamed from: b  reason: collision with root package name */
        public int f16597b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean f16598c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16599d;
        /* access modifiers changed from: private */
        public final boolean i;

        public a(int i2, int i3, boolean z, boolean z2, boolean z3) {
            super("GetOrderListForXXInteractor" + i2 + i3 + z + z2, "use_case", 500, true);
            this.f16596a = i2;
            this.f16597b = i3;
            this.f16598c = z;
            this.f16599d = z2;
            this.i = z3;
        }
    }
}
