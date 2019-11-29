package com.shopee.app.d.c;

import com.shopee.app.d.c.b.a;
import com.shopee.app.data.store.m;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.util.n;

public class ab extends a {

    /* renamed from: c  reason: collision with root package name */
    private final m f16421c;

    /* renamed from: d  reason: collision with root package name */
    private int f16422d;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetCategoryInfoInteractor";
    }

    protected ab(n nVar, m mVar) {
        super(nVar);
        this.f16421c = mVar;
    }

    public void a(int i) {
        this.f16422d = i;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBCategory a2 = this.f16421c.a(this.f16422d);
        while (a2 != null && a2.e()) {
            a2 = this.f16421c.a(a2.d());
        }
        if (a2 != null) {
            this.f16402a.a().bY.a(a2.c()).a();
        }
        a.a(this.f16421c);
    }
}
