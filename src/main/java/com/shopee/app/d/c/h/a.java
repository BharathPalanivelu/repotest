package com.shopee.app.d.c.h;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.d.ad;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class a extends com.shopee.app.d.c.a.a<C0256a> {

    /* renamed from: d  reason: collision with root package name */
    private final ah f17041d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f17042e;

    protected a(n nVar, ah ahVar, ao aoVar) {
        super(nVar);
        this.f17041d = ahVar;
        this.f17042e = aoVar;
    }

    public void a(int i, List<Pair<Integer, Long>> list, boolean z) {
        super.b(new C0256a(i, new ArrayList(list), z));
    }

    /* access modifiers changed from: protected */
    public void a(C0256a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Pair pair : aVar.f17043a) {
            arrayList3.add(pair.second);
        }
        List<DBItemDetail> c2 = this.f17041d.c((List<Long>) arrayList3);
        int i = 0;
        for (Pair pair2 : aVar.f17043a) {
            ItemDetail itemDetail = new ItemDetail();
            DBItemDetail dBItemDetail = i < c2.size() ? c2.get(i) : null;
            if (dBItemDetail == null || dBItemDetail.a() != ((Long) pair2.second).longValue()) {
                b.a(DBItemDetail.a(((Integer) pair2.first).intValue(), ((Long) pair2.second).longValue(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail);
                arrayList2.add(new Pair(pair2.first, pair2.second));
            } else {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.addAll(this.f17042e.b(dBItemDetail.a()));
                b.a(dBItemDetail, (List<IModelDetail>) arrayList4, itemDetail);
                arrayList2.add(new Pair(pair2.first, pair2.second));
                i++;
            }
            if (!arrayList.contains(itemDetail)) {
                arrayList.add(itemDetail);
            }
        }
        if (!af.a(arrayList2) && aVar.f17044b) {
            new ad().a(arrayList2);
        }
        this.f16405a.a().aC.a(new Pair(Integer.valueOf(aVar.f17045c), arrayList)).a();
    }

    /* renamed from: com.shopee.app.d.c.h.a$a  reason: collision with other inner class name */
    public static class C0256a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<Pair<Integer, Long>> f17043a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f17044b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f17045c;

        public C0256a(int i, List<Pair<Integer, Long>> list, boolean z) {
            super("GetItemsByIdListInteractor", "use_case", 0, false);
            this.f17045c = i;
            this.f17043a = list;
            this.f17044b = z;
        }
    }
}
