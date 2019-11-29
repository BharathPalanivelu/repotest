package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.d.t;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.SearchItemScore;
import java.util.ArrayList;
import java.util.List;

public class au extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final ah f16515d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f16516e;

    protected au(n nVar, ah ahVar, ao aoVar) {
        super(nVar);
        this.f16515d = ahVar;
        this.f16516e = aoVar;
    }

    public void a(int i, boolean z) {
        b(new a(i, z));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        List<DBItemDetail> a2 = this.f16515d.a(aVar.f16517a);
        ArrayList arrayList = new ArrayList(a2.size());
        ArrayList<ItemDetail> arrayList2 = new ArrayList<>(a2.size());
        for (DBItemDetail next : a2) {
            ItemDetail itemDetail = new ItemDetail();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(this.f16516e.b(next.a()));
            b.a(next, (List<IModelDetail>) arrayList3, itemDetail);
            arrayList2.add(itemDetail);
        }
        for (ItemDetail itemDetail2 : arrayList2) {
            if (itemDetail2.getViewCount() < 0) {
                SearchItemScore.Builder builder = new SearchItemScore.Builder();
                builder.itemid(Long.valueOf(itemDetail2.getId())).shopid(Integer.valueOf(itemDetail2.getShopId()));
                arrayList.add(builder.build());
            }
        }
        if (!af.a(arrayList)) {
            new t().a(arrayList, aVar.f16517a);
        }
        this.f16405a.a("ITEM_BY_TYPE_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(aVar.f16517a), arrayList2)));
    }

    static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f16517a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f16518b;

        a(int i, boolean z) {
            super("GetItemListByTypeInteractor" + i + z, "use_case", 0, false);
            this.f16517a = i;
            this.f16518b = z;
        }
    }
}
