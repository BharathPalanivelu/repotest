package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.az;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ShopItemId;
import java.util.ArrayList;
import java.util.List;

public class ad extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final ah f16425d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f16426e;

    /* renamed from: f  reason: collision with root package name */
    private final az f16427f;

    protected ad(n nVar, az azVar, ah ahVar, ao aoVar) {
        super(nVar);
        this.f16425d = ahVar;
        this.f16426e = aoVar;
        this.f16427f = azVar;
    }

    public void a(int i, int i2, boolean z, String str) {
        b(new a(i, i2, z, str));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<ShopItemId> a2 = this.f16427f.a(aVar.f16428a);
        int i = (aVar.f16429b + 1) * 20;
        int i2 = 0;
        if (a2.size() > i) {
            a2 = a2.subList(0, i);
        }
        if (!af.a(a2)) {
            ArrayList arrayList3 = new ArrayList();
            for (ShopItemId shopItemId : a2) {
                arrayList3.add(shopItemId.itemid);
            }
            List<DBItemDetail> c2 = this.f16425d.c((List<Long>) arrayList3);
            for (ShopItemId next : a2) {
                ItemDetail itemDetail = new ItemDetail();
                DBItemDetail dBItemDetail = i2 < c2.size() ? c2.get(i2) : null;
                if (dBItemDetail == null || dBItemDetail.a() != next.itemid.longValue() || dBItemDetail.k() < next.mtime.intValue()) {
                    b.a(DBItemDetail.a(next.shopid.intValue(), next.itemid.longValue(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail);
                    arrayList2.add(new Pair(next.shopid, next.itemid));
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.addAll(this.f16426e.b(dBItemDetail.a()));
                    b.a(dBItemDetail, (List<IModelDetail>) arrayList4, itemDetail);
                    i2++;
                }
                if (!arrayList.contains(itemDetail) && itemDetail.getItemName() != null && itemDetail.getItemName().toLowerCase().contains(aVar.f16431d)) {
                    arrayList.add(itemDetail);
                }
            }
        }
        if (!af.a(arrayList2) && aVar.f16430c) {
            new com.shopee.app.network.d.ad().a(arrayList2);
        }
        this.f16405a.a("CHAT_ITEM_BY_USER_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(aVar.f16428a), arrayList)));
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public int f16428a;

        /* renamed from: b  reason: collision with root package name */
        public int f16429b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16430c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f16431d;

        public a(int i, int i2, boolean z, String str) {
            super("GetChatItemListByUserInteractor" + i + i2 + z, "use_case", 0, false);
            this.f16428a = i;
            this.f16429b = i2;
            this.f16430c = z;
            this.f16431d = str;
        }
    }
}
