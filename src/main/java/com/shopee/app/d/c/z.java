package com.shopee.app.d.c;

import android.util.Pair;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.ar;
import com.shopee.app.data.store.az;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBModelSnapshot;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import com.shopee.app.network.d.ad;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.c.c;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ShopItemId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class z extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final ah f17139d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f17140e;

    /* renamed from: f  reason: collision with root package name */
    private final az f17141f;

    /* renamed from: g  reason: collision with root package name */
    private final ar f17142g;

    protected z(n nVar, az azVar, ar arVar, ah ahVar, ao aoVar) {
        super(nVar);
        this.f17139d = ahVar;
        this.f17140e = aoVar;
        this.f17141f = azVar;
        this.f17142g = arVar;
    }

    public void a(int i, int i2, boolean z) {
        b(new a(i, i2, z));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        int i;
        Iterator<ShopItemId> it;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<Long> a2 = this.f17141f.a();
        if (!af.a(a2)) {
            for (DBOffer next : this.f17142g.a(a2)) {
                if (next.f() == aVar.f17144a) {
                    VMOfferHistory a3 = a(next, aVar.f17146c, (List<Pair<Integer, Long>>) arrayList2);
                    ItemDetail itemDetail = new ItemDetail();
                    itemDetail.setShopId(aVar.f17144a);
                    itemDetail.setOffer(a3);
                    arrayList.add(itemDetail);
                }
            }
            if (!af.a(arrayList)) {
                ItemDetail itemDetail2 = new ItemDetail();
                itemDetail2.setShopId(-2);
                itemDetail2.setItemName(b.e(R.string.sp_accepted_offers));
                arrayList.add(0, itemDetail2);
            }
        }
        if (aVar.f17146c) {
            new c().a(a2);
        }
        List<ShopItemId> c2 = this.f17141f.c(aVar.f17144a);
        if (!af.a(c2)) {
            ItemDetail itemDetail3 = new ItemDetail();
            itemDetail3.setShopId(-2);
            itemDetail3.setItemName("All Products");
            arrayList.add(itemDetail3);
            ArrayList arrayList3 = new ArrayList();
            for (ShopItemId shopItemId : c2) {
                arrayList3.add(shopItemId.itemid);
            }
            List<DBItemDetail> c3 = this.f17139d.c((List<Long>) arrayList3);
            int i2 = 0;
            for (Iterator<ShopItemId> it2 = c2.iterator(); it2.hasNext(); it2 = it) {
                ShopItemId next2 = it2.next();
                ItemDetail itemDetail4 = new ItemDetail();
                DBItemDetail dBItemDetail = i2 < c3.size() ? c3.get(i2) : null;
                if (dBItemDetail == null || dBItemDetail.a() != next2.itemid.longValue() || dBItemDetail.k() < next2.mtime.intValue()) {
                    it = it2;
                    com.shopee.app.d.b.b.a(DBItemDetail.a(aVar.f17144a, next2.itemid.longValue(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail4);
                    arrayList2.add(new Pair(Integer.valueOf(aVar.f17144a), next2.itemid));
                    i2 = i2;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.addAll(this.f17140e.b(dBItemDetail.a()));
                    com.shopee.app.d.b.b.a(dBItemDetail, (List<IModelDetail>) arrayList4, itemDetail4);
                    i2++;
                    it = it2;
                }
                if (!arrayList.contains(itemDetail4)) {
                    arrayList.add(itemDetail4);
                }
            }
        }
        List<ShopItemId> b2 = this.f17141f.b(aVar.f17144a);
        int c4 = (aVar.f17145b + 1) * 20;
        if (b2.size() > c4) {
            i = 0;
            b2 = b2.subList(0, c4);
        } else {
            i = 0;
        }
        if (!af.a(b2)) {
            if (af.a(c2)) {
                ItemDetail itemDetail5 = new ItemDetail();
                itemDetail5.setShopId(-2);
                itemDetail5.setItemName("All Products");
                arrayList.add(itemDetail5);
            }
            ArrayList arrayList5 = new ArrayList();
            for (ShopItemId shopItemId2 : b2) {
                arrayList5.add(shopItemId2.itemid);
            }
            List<DBItemDetail> c5 = this.f17139d.c((List<Long>) arrayList5);
            for (ShopItemId next3 : b2) {
                ItemDetail itemDetail6 = new ItemDetail();
                DBItemDetail dBItemDetail2 = i < c5.size() ? c5.get(i) : null;
                if (dBItemDetail2 == null || dBItemDetail2.a() != next3.itemid.longValue() || dBItemDetail2.k() < next3.mtime.intValue()) {
                    com.shopee.app.d.b.b.a(DBItemDetail.a(aVar.f17144a, next3.itemid.longValue(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail6);
                    arrayList2.add(new Pair(Integer.valueOf(aVar.f17144a), next3.itemid));
                } else {
                    ArrayList arrayList6 = new ArrayList();
                    arrayList6.addAll(this.f17140e.b(dBItemDetail2.a()));
                    com.shopee.app.d.b.b.a(dBItemDetail2, (List<IModelDetail>) arrayList6, itemDetail6);
                    i++;
                }
                if (!arrayList.contains(itemDetail6)) {
                    arrayList.add(itemDetail6);
                }
            }
        }
        if (!af.a(arrayList2) && aVar.f17146c) {
            new ad().a(arrayList2);
        }
        this.f16405a.a("BUY_ITEM_BY_SHOP_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(aVar.f17144a), arrayList)));
    }

    private VMOfferHistory a(DBOffer dBOffer, boolean z, List<Pair<Integer, Long>> list) {
        VMOfferHistory vMOfferHistory = new VMOfferHistory();
        VMOffer vMOffer = new VMOffer();
        VMOffer.map(dBOffer, vMOffer);
        vMOfferHistory.setOffer(vMOffer);
        if (dBOffer.n() > 0) {
            DBItemSnapShot c2 = this.f17139d.c(dBOffer.n());
            if (c2 != null) {
                ItemSnapshotInfo itemSnapshotInfo = new ItemSnapshotInfo();
                com.shopee.app.d.b.b.a(c2, (List<ModelDetail>) af.a(this.f17140e.e(c2.a().longValue()), new af.b<ModelDetail, DBModelSnapshot>() {
                    /* renamed from: a */
                    public ModelDetail map(DBModelSnapshot dBModelSnapshot) {
                        ModelDetail modelDetail = new ModelDetail();
                        com.shopee.app.d.b.b.a((IModelDetail) dBModelSnapshot, modelDetail);
                        return modelDetail;
                    }
                }), itemSnapshotInfo);
                vMOfferHistory.setSnapshot(itemSnapshotInfo);
            } else {
                ItemSnapshotInfo itemSnapshotInfo2 = new ItemSnapshotInfo();
                com.shopee.app.d.b.b.a(DBItemSnapShot.a(Integer.valueOf(dBOffer.f()), Long.valueOf(dBOffer.n())), (List<ModelDetail>) null, itemSnapshotInfo2);
                vMOfferHistory.setSnapshot(itemSnapshotInfo2);
                new aq().a(dBOffer.f(), dBOffer.n());
            }
        }
        ItemDetail itemDetail = new ItemDetail();
        DBItemDetail a2 = this.f17139d.a(dBOffer.g());
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f17140e.b(a2.a()));
            com.shopee.app.d.b.b.a(a2, (List<IModelDetail>) arrayList, itemDetail);
        } else {
            com.shopee.app.d.b.b.a(DBItemDetail.a(dBOffer.f(), dBOffer.g(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail);
            list.add(new Pair(Integer.valueOf(dBOffer.f()), Long.valueOf(dBOffer.g())));
        }
        vMOfferHistory.setItemDetail(itemDetail);
        return vMOfferHistory;
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f17144a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f17145b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f17146c;

        public a(int i, int i2, boolean z) {
            super("GetBuyItemListByShopInteractor" + i + z, "use_case", 0, false);
            this.f17144a = i;
            this.f17145b = i2;
            this.f17146c = z;
        }
    }
}
