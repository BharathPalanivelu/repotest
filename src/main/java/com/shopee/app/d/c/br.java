package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.d.ax;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class br extends a {

    /* renamed from: c  reason: collision with root package name */
    private final ao f16619c;

    /* renamed from: d  reason: collision with root package name */
    private final ah f16620d;

    /* renamed from: e  reason: collision with root package name */
    private long f16621e;

    /* renamed from: f  reason: collision with root package name */
    private int f16622f;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetProductInfoInteractor";
    }

    protected br(n nVar, ao aoVar, ah ahVar) {
        super(nVar);
        this.f16619c = aoVar;
        this.f16620d = ahVar;
    }

    public void a(int i, long j) {
        this.f16622f = i;
        this.f16621e = j;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBItemDetail a2 = this.f16620d.a(this.f16621e);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f16619c.b(this.f16621e));
        ItemDetail itemDetail = new ItemDetail();
        b.a(a2, (List<IModelDetail>) arrayList, itemDetail);
        this.f16402a.a("ITEM_DETAIL_LOAD", new a(itemDetail));
        new ax(this.f16622f, this.f16621e).g();
    }
}
