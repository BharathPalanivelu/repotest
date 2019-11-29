package com.shopee.app.d.c.g;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.c.d;
import com.shopee.app.data.store.c.e;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBModelSnapshot;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.h.g;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a extends com.shopee.app.d.c.a {

    /* renamed from: c  reason: collision with root package name */
    private final n f17019c;

    /* renamed from: d  reason: collision with root package name */
    private final e f17020d;

    /* renamed from: e  reason: collision with root package name */
    private final d f17021e;

    /* renamed from: f  reason: collision with root package name */
    private c f17022f;

    /* renamed from: g  reason: collision with root package name */
    private final at f17023g;
    private final ao h;
    private final bh i;
    private final ah j;
    private boolean k;
    private int l;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetReturnListInteractor";
    }

    protected a(n nVar, e eVar, d dVar, c cVar, at atVar, ao aoVar, bh bhVar, ah ahVar) {
        super(nVar);
        this.f17019c = nVar;
        this.f17020d = eVar;
        this.f17021e = dVar;
        this.f17022f = cVar;
        this.f17023g = atVar;
        this.h = aoVar;
        this.i = bhVar;
        this.j = ahVar;
    }

    public void a(boolean z, int i2) {
        this.k = z;
        this.l = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBItemSnapShot dBItemSnapShot;
        DBReturnItem dBReturnItem;
        ItemSnapshotInfo itemSnapshotInfo;
        List<DBReturnItem> b2 = this.f17020d.b(this.f17021e.b(this.l));
        List<Long> a2 = this.f17023g.a(new OrderKey(this.k, 5));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Pair> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        int intValue = ((Integer) ak.a().d().b(0)).intValue();
        for (DBReturnItem next : b2) {
            if (next != null) {
                int e2 = next.e();
                if (e2 == intValue) {
                    int d2 = next.d();
                    DBShopInfo b3 = this.i.b(d2);
                    if (b3 == null) {
                        new com.shopee.app.network.d.ao().a(d2);
                        e2 = 0;
                    } else {
                        e2 = b3.c();
                    }
                }
                DBUserInfo a3 = this.i.a(e2);
                if (a3 == null) {
                    arrayList.add(Integer.valueOf(e2));
                }
                DBReturnItem.ReturnFirstItem n = next.n();
                if (n != null) {
                    ah ahVar = this.j;
                    Long[] lArr = new Long[1];
                    lArr[i2] = Long.valueOf(n.a());
                    List<DBItemSnapShot> d3 = ahVar.d(Arrays.asList(lArr));
                    if (d3.isEmpty()) {
                        arrayList3.add(new Pair(Integer.valueOf(n.b()), Long.valueOf(n.a())));
                        dBItemSnapShot = null;
                    } else {
                        dBItemSnapShot = d3.get(i2);
                    }
                    if (dBItemSnapShot != null) {
                        dBReturnItem = next;
                        List<T> a4 = af.a(this.h.e(dBItemSnapShot.a().longValue()), new af.b<ModelDetail, DBModelSnapshot>() {
                            /* renamed from: a */
                            public ModelDetail map(DBModelSnapshot dBModelSnapshot) {
                                ModelDetail modelDetail = new ModelDetail();
                                b.a((IModelDetail) dBModelSnapshot, modelDetail);
                                return modelDetail;
                            }
                        });
                        ItemSnapshotInfo itemSnapshotInfo2 = new ItemSnapshotInfo();
                        b.a(dBItemSnapShot, (List<ModelDetail>) a4, itemSnapshotInfo2);
                        itemSnapshotInfo = itemSnapshotInfo2;
                    } else {
                        dBReturnItem = next;
                        itemSnapshotInfo = null;
                    }
                    DBOrderDetail b4 = this.f17022f.b(dBReturnItem.c());
                    if (b4 == null) {
                        arrayList2.add(Long.valueOf(dBReturnItem.c()));
                    }
                    ReturnItem returnItem = new ReturnItem();
                    b.a(dBReturnItem, b4, n, itemSnapshotInfo, a3, returnItem);
                    if (a2.contains(Long.valueOf(dBReturnItem.b()))) {
                        returnItem.setUnread(true);
                    } else {
                        returnItem.setUnread(false);
                    }
                    arrayList4.add(returnItem);
                    i2 = 0;
                }
            }
        }
        if (arrayList2.size() > 0) {
            new g().a((List<Long>) arrayList2);
        }
        if (arrayList.size() > 0) {
            new au().a((List<Integer>) arrayList);
        }
        if (arrayList3.size() > 0) {
            for (Pair pair : arrayList3) {
                new aq().a(((Integer) pair.first).intValue(), ((Long) pair.second).longValue());
            }
        }
        this.f17019c.a("RETURN_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.a) new com.shopee.app.ui.order.a.c(this.l, arrayList4));
    }
}
