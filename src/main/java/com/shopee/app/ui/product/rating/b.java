package com.shopee.app.ui.product.rating;

import android.util.Pair;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.database.orm.bean.DBModelSnapshot;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.d.aq;
import com.shopee.app.network.d.au;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final bh f24723d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f24724e;

    /* renamed from: com.shopee.app.ui.product.rating.b$b  reason: collision with other inner class name */
    public static class C0380b {

        /* renamed from: a  reason: collision with root package name */
        public int f24729a;

        /* renamed from: b  reason: collision with root package name */
        public long f24730b;

        /* renamed from: c  reason: collision with root package name */
        public List<ItemCommentInfo> f24731c;

        /* renamed from: d  reason: collision with root package name */
        public int f24732d;
    }

    protected b(n nVar, ao aoVar, bh bhVar) {
        super(nVar);
        this.f24723d = bhVar;
        this.f24724e = aoVar;
    }

    public void a(int i, long j, List<ItemCommentInfo> list, int i2, int i3) {
        b(new a(i, j, list, i2, i3));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Pair> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        int i = -1;
        int i2 = 0;
        for (ItemCommentInfo itemCommentInfo : aVar.f24727c) {
            if (i2 == aVar.f24728d) {
                i = arrayList3.size() + aVar.i;
            }
            i2++;
            DBUserInfo a2 = this.f24723d.a(itemCommentInfo.getUserId());
            if (a2 == null) {
                arrayList.add(Integer.valueOf(itemCommentInfo.getUserId()));
            } else {
                itemCommentInfo.setUserName(a2.i());
                itemCommentInfo.setUserPortrait(a2.j());
            }
            if (itemCommentInfo.getModelId() > 0 && itemCommentInfo.getSnapshotId() > 0) {
                DBModelSnapshot d2 = this.f24724e.d(itemCommentInfo.getModelId());
                if (d2 == null) {
                    arrayList2.add(new Pair(Integer.valueOf(itemCommentInfo.getShopId()), Long.valueOf(itemCommentInfo.getSnapshotId())));
                } else {
                    itemCommentInfo.setVariationName(d2.h());
                }
            }
            for (String singletonList : itemCommentInfo.getImages()) {
                ItemCommentInfo copy = itemCommentInfo.getCopy();
                copy.setImages(Collections.singletonList(singletonList));
                arrayList3.add(copy);
            }
        }
        if (arrayList.size() > 0) {
            new au().a((List<Integer>) arrayList);
        }
        if (arrayList2.size() > 0) {
            for (Pair pair : arrayList2) {
                new aq().a(((Integer) pair.first).intValue(), ((Long) pair.second).longValue());
            }
        }
        C0380b bVar = new C0380b();
        bVar.f24730b = aVar.f24726b;
        bVar.f24729a = aVar.f24725a;
        bVar.f24731c = arrayList3;
        bVar.f24732d = i;
        this.f16405a.a().bT.a(bVar).a();
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f24725a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f24726b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final List<ItemCommentInfo> f24727c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f24728d;
        /* access modifiers changed from: private */
        public final int i;

        public a(int i2, long j, List<ItemCommentInfo> list, int i3, int i4) {
            super("GetRatingImageListInteractor" + i2 + j, "use_case", 0, false);
            this.f24725a = i2;
            this.f24726b = j;
            this.f24727c = list;
            this.f24728d = i3;
            this.i = i4;
        }
    }
}
