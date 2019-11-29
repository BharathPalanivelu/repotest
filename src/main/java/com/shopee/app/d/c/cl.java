package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.b.a;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.c.e;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBOrderItem;
import com.shopee.app.database.orm.bean.DBRefund;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.h.i;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class cl extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bh f16692c;

    /* renamed from: d  reason: collision with root package name */
    private final ah f16693d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f16694e;

    /* renamed from: f  reason: collision with root package name */
    private final c f16695f;

    /* renamed from: g  reason: collision with root package name */
    private final e f16696g;
    private long h;

    /* access modifiers changed from: protected */
    public String d() {
        return "OrderDetailInteractor";
    }

    public cl(n nVar, bh bhVar, e eVar, ah ahVar, ao aoVar, c cVar) {
        super(nVar);
        this.f16692c = bhVar;
        this.f16696g = eVar;
        this.f16693d = ahVar;
        this.f16694e = aoVar;
        this.f16695f = cVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBOrderDetail b2 = this.f16695f.b(this.h);
        if (b2 != null) {
            ArrayList arrayList = new ArrayList();
            OrderDetail orderDetail = new OrderDetail();
            ArrayList<Pair> arrayList2 = new ArrayList<>();
            i iVar = new i();
            List<DBOrderItem> c2 = this.f16695f.c(b2.a());
            if (c2.size() <= 0) {
                iVar.a(b2.a(), b2.b());
            }
            List<DBRefund> c3 = this.f16696g.c(b2.a());
            a.a(b2, c2, this.f16692c, this.f16693d, this.f16694e, arrayList, arrayList2, orderDetail);
            orderDetail.setRefunds(c3);
            if (arrayList.size() > 0) {
                new au().a((List<Integer>) arrayList);
            }
            if (arrayList2.size() > 0) {
                for (Pair pair : arrayList2) {
                    new aq().a(((Integer) pair.first).intValue(), ((Long) pair.second).longValue());
                }
            }
            this.f16402a.a("ORDER_DETAIL_LOCAL_LOAD", new com.garena.android.appkit.b.a(orderDetail));
        }
    }

    public void a(long j) {
        this.h = j;
        a();
    }
}
