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
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class bg extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final ah f16571d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f16572e;

    /* renamed from: f  reason: collision with root package name */
    private final az f16573f;

    /* renamed from: g  reason: collision with root package name */
    private final ar f16574g;

    protected bg(n nVar, az azVar, ar arVar, ah ahVar, ao aoVar) {
        super(nVar);
        this.f16571d = ahVar;
        this.f16572e = aoVar;
        this.f16573f = azVar;
        this.f16574g = arVar;
    }

    public void a(int i, boolean z) {
        b(new a(i, z));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<Long> a2 = this.f16573f.a(aVar.f16576a, true);
        List<DBOffer> a3 = this.f16574g.a(a2);
        if (!af.a(a2)) {
            VMOfferHistory vMOfferHistory = new VMOfferHistory();
            vMOfferHistory.setType(-2);
            vMOfferHistory.setTitle(b.e(R.string.sp_label_offers_received));
            arrayList.add(vMOfferHistory);
        }
        for (DBOffer a4 : a3) {
            arrayList.add(a(a4, aVar.f16577b, arrayList2));
        }
        List<Long> a5 = this.f16573f.a(aVar.f16576a, false);
        List<DBOffer> a6 = this.f16574g.a(a5);
        if (!af.a(a5)) {
            VMOfferHistory vMOfferHistory2 = new VMOfferHistory();
            vMOfferHistory2.setType(-2);
            vMOfferHistory2.setTitle(b.e(R.string.sp_label_offers_sent));
            arrayList.add(vMOfferHistory2);
        }
        for (DBOffer a7 : a6) {
            arrayList.add(a(a7, aVar.f16577b, arrayList2));
        }
        if (!af.a(arrayList2) && aVar.f16577b) {
            new ad().a(arrayList2);
        }
        this.f16405a.a("GET_OFFER_LIST_BY_USER_LOAD", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(aVar.f16576a), arrayList)));
    }

    private VMOfferHistory a(DBOffer dBOffer, boolean z, List<Pair<Integer, Long>> list) {
        VMOfferHistory vMOfferHistory = new VMOfferHistory();
        VMOffer vMOffer = new VMOffer();
        VMOffer.map(dBOffer, vMOffer);
        vMOfferHistory.setOffer(vMOffer);
        if (dBOffer.n() > 0) {
            DBItemSnapShot c2 = this.f16571d.c(dBOffer.n());
            if (c2 != null) {
                ItemSnapshotInfo itemSnapshotInfo = new ItemSnapshotInfo();
                com.shopee.app.d.b.b.a(c2, (List<ModelDetail>) af.a(this.f16572e.e(c2.a().longValue()), new af.b<ModelDetail, DBModelSnapshot>() {
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
                if (z) {
                    new aq().a(dBOffer.f(), dBOffer.n());
                }
            }
        }
        ItemDetail itemDetail = new ItemDetail();
        DBItemDetail a2 = this.f16571d.a(dBOffer.g());
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f16572e.b(a2.a()));
            com.shopee.app.d.b.b.a(a2, (List<IModelDetail>) arrayList, itemDetail);
        } else {
            com.shopee.app.d.b.b.a(DBItemDetail.a(dBOffer.f(), dBOffer.g(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail);
            list.add(new Pair(Integer.valueOf(dBOffer.f()), Long.valueOf(dBOffer.g())));
        }
        vMOfferHistory.setItemDetail(itemDetail);
        return vMOfferHistory;
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public int f16576a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f16577b;

        public a(int i, boolean z) {
            super("GetOfferListByUserInteractor" + i, "use_case", 0, false);
            this.f16576a = i;
            this.f16577b = z;
        }
    }
}
