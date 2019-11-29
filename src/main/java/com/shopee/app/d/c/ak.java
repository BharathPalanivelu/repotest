package com.shopee.app.d.c;

import com.garena.android.appkit.d.a;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.m;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.CategoryPath;
import com.shopee.protocol.shop.ItemExtInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ak extends a {

    /* renamed from: c  reason: collision with root package name */
    private final ah f16481c;

    /* renamed from: d  reason: collision with root package name */
    private final m f16482d;

    /* renamed from: e  reason: collision with root package name */
    private long f16483e;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetEditProductInfoInteractor";
    }

    protected ak(n nVar, m mVar, ah ahVar) {
        super(nVar);
        this.f16482d = mVar;
        this.f16481c = ahVar;
    }

    public void a(long j) {
        this.f16483e = j;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBItemDetail a2 = this.f16481c.a(this.f16483e);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            try {
                ItemExtInfo itemExtInfo = (ItemExtInfo) f.f18486a.parseFrom(a2.s(), 0, a2.s().length, ItemExtInfo.class);
                if (!(itemExtInfo == null || itemExtInfo.cats == null || itemExtInfo.cats.isEmpty())) {
                    CategoryPath categoryPath = itemExtInfo.cats.get(0);
                    if (categoryPath != null) {
                        i = categoryPath.catid.get(categoryPath.catid.size() - 1).intValue();
                    }
                }
            } catch (IOException e2) {
                a.a(e2);
            }
            DBCategory a3 = this.f16482d.a(i);
            if (a3 != null) {
                arrayList.add(a3);
                while (a3.d() != 0) {
                    a3 = this.f16482d.a(a3.d());
                    if (a3 == null) {
                        break;
                    }
                    arrayList.add(a3);
                }
            }
            AddProductInfo addProductInfo = new AddProductInfo();
            b.a(a2, (List<DBCategory>) arrayList, addProductInfo);
            this.f16402a.a("ITEM_LOADED", new com.garena.android.appkit.b.a(addProductInfo));
        }
    }
}
