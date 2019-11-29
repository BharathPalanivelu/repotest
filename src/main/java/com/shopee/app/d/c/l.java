package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.b.a;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.w;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.CustomerOrderInfo;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBOrderItem;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.h.i;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class l extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bh f17088c;

    /* renamed from: d  reason: collision with root package name */
    private final w f17089d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f17090e;

    /* renamed from: f  reason: collision with root package name */
    private final ah f17091f;

    /* renamed from: g  reason: collision with root package name */
    private final c f17092g;
    private final x h;
    private final bg i;
    private int j;
    private int k;

    /* access modifiers changed from: protected */
    public String d() {
        return "CustomerOrderInteractor";
    }

    protected l(n nVar, bh bhVar, bg bgVar, x xVar, w wVar, ao aoVar, ah ahVar, c cVar) {
        super(nVar);
        this.f17088c = bhVar;
        this.f17089d = wVar;
        this.f17090e = aoVar;
        this.f17091f = ahVar;
        this.h = xVar;
        this.f17092g = cVar;
        this.i = bgVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<DBOrderDetail> d2 = this.f17092g.d(this.f17089d.b());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Pair> arrayList3 = new ArrayList<>();
        i iVar = new i();
        for (DBOrderDetail next : d2) {
            List<DBOrderItem> c2 = this.f17092g.c(next.a());
            if (c2.size() <= 0) {
                iVar.a(next.a(), next.b());
            }
            ArrayList arrayList4 = new ArrayList();
            OrderDetail orderDetail = new OrderDetail();
            a.a(next, c2, this.f17088c, this.f17091f, this.f17090e, arrayList4, arrayList3, orderDetail);
            arrayList2.addAll(arrayList4);
            if (arrayList3.size() > 0) {
                for (Pair pair : arrayList3) {
                    new aq().a(((Integer) pair.first).intValue(), ((Long) pair.second).longValue());
                }
            }
            arrayList.add(orderDetail);
        }
        if (arrayList2.size() > 0) {
            new au().a((List<Integer>) arrayList2);
        }
        Map<Integer, Integer> a2 = this.h.a();
        CustomerOrderInfo customerOrderInfo = new CustomerOrderInfo();
        int i2 = 0;
        if (a2.containsKey(Integer.valueOf(this.j))) {
            i2 = a2.get(Integer.valueOf(this.j)).intValue();
        }
        b.a(this.i.b(this.j), this.f17088c.a(this.j), (List<OrderDetail>) arrayList, i2, customerOrderInfo);
        this.f16402a.a("CUSTOMER_ORDER_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(customerOrderInfo));
    }

    public void a(int i2, int i3) {
        this.j = i2;
        this.k = i3;
        a();
    }
}
