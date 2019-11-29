package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.r;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.CheckoutOrderInfo;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.database.orm.bean.DBCheckoutOrder;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBOrderItem;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.h.t;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.at;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.h.i;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private long f16650c;

    /* renamed from: d  reason: collision with root package name */
    private final com.shopee.app.data.store.c.c f16651d;

    /* renamed from: e  reason: collision with root package name */
    private final ah f16652e;

    /* renamed from: f  reason: collision with root package name */
    private final r f16653f;

    /* renamed from: g  reason: collision with root package name */
    private final bh f16654g;
    private final ao h;
    private final SettingConfigStore i;

    /* access modifiers changed from: protected */
    public String d() {
        return "CheckoutDetailInteractor";
    }

    protected c(n nVar, com.shopee.app.data.store.c.c cVar, ah ahVar, r rVar, bh bhVar, ao aoVar, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f16651d = cVar;
        this.f16652e = ahVar;
        this.f16653f = rVar;
        this.f16654g = bhVar;
        this.h = aoVar;
        this.i = settingConfigStore;
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBCheckoutItem a2 = this.f16653f.a(this.f16650c);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (DBCheckoutOrder next : a2.i()) {
                if (next.i()) {
                    arrayList3.add(new a(next.b(), next.a()));
                    CheckoutOrderInfo checkoutOrderInfo = new CheckoutOrderInfo();
                    String str = null;
                    DBShopInfo b2 = this.f16654g.b(next.a());
                    if (b2 == null) {
                        UserBriefInfo b3 = t.a().b(next.a());
                        if (b3 == null) {
                            arrayList.add(Integer.valueOf(next.a()));
                        } else {
                            str = b3.getPortrait();
                        }
                    } else {
                        str = b2.f();
                    }
                    b.a(next, str, checkoutOrderInfo);
                    arrayList2.add(checkoutOrderInfo);
                }
            }
            if (arrayList.size() > 0) {
                new at().a(new ArrayList(), arrayList);
            }
            ArrayList<a> arrayList4 = new ArrayList<>();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList<Pair> arrayList7 = new ArrayList<>();
            i iVar = new i();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                DBOrderDetail b4 = this.f16651d.b(aVar.f16655a);
                if (b4 == null) {
                    arrayList4.add(aVar);
                } else {
                    List<DBOrderItem> c2 = this.f16651d.c(b4.a());
                    if (c2.size() <= 0) {
                        iVar.a(b4.a(), b4.b());
                    }
                    ArrayList arrayList8 = new ArrayList();
                    OrderDetail orderDetail = new OrderDetail();
                    bh bhVar = this.f16654g;
                    ah ahVar = this.f16652e;
                    DBOrderDetail dBOrderDetail = b4;
                    List<DBOrderItem> list = c2;
                    bh bhVar2 = bhVar;
                    ah ahVar2 = ahVar;
                    ao aoVar = this.h;
                    OrderDetail orderDetail2 = orderDetail;
                    Iterator it2 = it;
                    i iVar2 = iVar;
                    com.shopee.app.data.store.b.a.a(dBOrderDetail, list, bhVar2, ahVar2, aoVar, arrayList8, arrayList7, orderDetail2);
                    arrayList6.addAll(arrayList8);
                    if (arrayList7.size() > 0) {
                        for (Pair pair : arrayList7) {
                            new aq().a(((Integer) pair.first).intValue(), ((Long) pair.second).longValue());
                        }
                    }
                    arrayList5.add(orderDetail2);
                    it = it2;
                    iVar = iVar2;
                }
            }
            if (arrayList4.size() > 0) {
                i iVar3 = new i();
                for (a aVar2 : arrayList4) {
                    iVar3.a(aVar2.f16655a, aVar2.f16656b);
                }
            }
            if (arrayList6.size() > 0) {
                new au().a((List<Integer>) arrayList6);
            }
            CheckoutItem checkoutItem = new CheckoutItem();
            b.a(a2, (List<OrderDetail>) arrayList5, (List<CheckoutOrderInfo>) arrayList2, this.i.getChangePaymentOption(), checkoutItem);
            this.f16402a.a("SINGLE_CHECKOUT_LOCAL_LOAD", new com.garena.android.appkit.b.a(checkoutItem));
        }
    }

    public void a(long j) {
        this.f16650c = j;
        a();
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        long f16655a;

        /* renamed from: b  reason: collision with root package name */
        int f16656b;

        public a(long j, int i) {
            this.f16655a = j;
            this.f16656b = i;
        }
    }
}
