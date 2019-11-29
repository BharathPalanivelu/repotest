package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.bh;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.util.n;

public class bp extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bh f16616c;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetProductCountInteractor";
    }

    protected bp(n nVar, bh bhVar) {
        super(nVar);
        this.f16616c = bhVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        int i = 0;
        DBShopInfo b2 = this.f16616c.b(((Integer) ak.a().i().b(0)).intValue());
        if (b2 != null) {
            i = b2.o();
        }
        this.f16402a.a("GET_PRODUCT_COUNT", new a(Integer.valueOf(i)));
    }

    public void e() {
        a();
    }
}
