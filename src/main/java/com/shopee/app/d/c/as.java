package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBModel;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class as extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f16508c;

    /* renamed from: d  reason: collision with root package name */
    private final ah f16509d;

    /* renamed from: e  reason: collision with root package name */
    private long f16510e;

    /* renamed from: f  reason: collision with root package name */
    private final ao f16511f;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetItemDetailInteractor";
    }

    protected as(n nVar, ao aoVar, ah ahVar) {
        super(nVar);
        this.f16508c = nVar;
        this.f16509d = ahVar;
        this.f16511f = aoVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBItemDetail a2 = this.f16509d.a(this.f16510e);
        if (a2 != null) {
            ItemDetail itemDetail = new ItemDetail();
            List<DBModel> b2 = this.f16511f.b(this.f16510e);
            ArrayList arrayList = new ArrayList();
            for (DBModel add : b2) {
                arrayList.add(add);
            }
            b.a(a2, (List<IModelDetail>) arrayList, itemDetail);
            this.f16508c.a("ITEM_DETAIL", new a(itemDetail));
        }
    }

    public void a(long j) {
        this.f16510e = j;
        a();
    }
}
