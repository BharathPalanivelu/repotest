package com.shopee.app.d.c.g;

import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.r;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.CheckoutOrderInfo;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.database.orm.bean.DBCheckoutOrder;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private final r f17032c;

    /* renamed from: d  reason: collision with root package name */
    private final bh f17033d;

    /* renamed from: e  reason: collision with root package name */
    private final q f17034e;

    /* renamed from: f  reason: collision with root package name */
    private final at f17035f;

    /* renamed from: g  reason: collision with root package name */
    private final ah f17036g;
    private final ao h;
    private final com.shopee.app.data.store.c.c i;
    private final SettingConfigStore j;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetCheckoutListInteractor";
    }

    public c(n nVar, r rVar, bh bhVar, at atVar, q qVar, ah ahVar, ao aoVar, com.shopee.app.data.store.c.c cVar, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f17032c = rVar;
        this.f17033d = bhVar;
        this.f17035f = atVar;
        this.f17034e = qVar;
        this.f17036g = ahVar;
        this.h = aoVar;
        this.i = cVar;
        this.j = settingConfigStore;
    }

    public void a(int i2) {
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<Long> b2 = this.f17034e.b();
        ArrayList arrayList = new ArrayList();
        List<Long> a2 = this.f17035f.a(new OrderKey(false, 9));
        new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Long next : b2) {
            DBCheckoutItem a3 = this.f17032c.a(next.longValue());
            if (a3 == null) {
                arrayList.add(next);
            } else {
                CheckoutItem checkoutItem = new CheckoutItem();
                List<DBOrderDetail> a4 = this.i.a(next);
                ArrayList arrayList4 = new ArrayList();
                for (DBOrderDetail next2 : a4) {
                    DBUserInfo a5 = this.f17033d.a(next2.c());
                    if (a5 == null) {
                        arrayList3.add(Integer.valueOf(next2.c()));
                    }
                    DBUserInfo a6 = this.f17033d.a(next2.E());
                    if (a6 == null) {
                        arrayList3.add(Integer.valueOf(next2.E()));
                    }
                    OrderDetail orderDetail = new OrderDetail();
                    if (this.f17033d.c(next2.E())) {
                        b.a(next2, a5, orderDetail);
                    } else {
                        b.a(next2, a6, orderDetail);
                    }
                    long firstItemSnapshotId = orderDetail.getFirstItemSnapshotId();
                    if (firstItemSnapshotId > 0) {
                        DBItemSnapShot c2 = this.f17036g.c(firstItemSnapshotId);
                        if (c2 == null) {
                            new aq().a(next2.b(), firstItemSnapshotId);
                        } else {
                            com.shopee.app.data.store.b.a.a(c2, this.h, orderDetail);
                        }
                    } else {
                        com.shopee.app.data.store.b.a.a((DBItemSnapShot) null, this.h, orderDetail);
                    }
                    if (a2.contains(Long.valueOf(orderDetail.getCheckoutId()))) {
                        orderDetail.setUnread(true);
                    } else {
                        orderDetail.setUnread(false);
                    }
                    arrayList4.add(orderDetail);
                }
                if (arrayList3.size() > 0) {
                    new au().a((List<Integer>) arrayList3);
                }
                List<DBCheckoutOrder> i2 = a3.i();
                ArrayList arrayList5 = new ArrayList();
                for (DBCheckoutOrder a7 : i2) {
                    CheckoutOrderInfo checkoutOrderInfo = new CheckoutOrderInfo();
                    b.a(a7, (String) null, checkoutOrderInfo);
                    arrayList5.add(checkoutOrderInfo);
                }
                b.a(a3, (List<OrderDetail>) arrayList4, (List<CheckoutOrderInfo>) arrayList5, this.j.getChangePaymentOption(), checkoutItem);
                if (a2.contains(Long.valueOf(checkoutItem.getCheckoutId()))) {
                    checkoutItem.setUnread(true);
                } else {
                    checkoutItem.setUnread(false);
                }
                arrayList2.add(checkoutItem);
            }
        }
        this.f16402a.a("CHECKOUT_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(arrayList2));
    }
}
