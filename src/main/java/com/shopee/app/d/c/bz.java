package com.shopee.app.d.c;

import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.util.n;

public class bz extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final bh f16648d;

    protected bz(n nVar, bh bhVar) {
        super(nVar);
        this.f16648d = bhVar;
    }

    public void a(int i) {
        b(new a(i));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        DBUserInfo a2 = this.f16648d.a(aVar.f16649a);
        if (a2 != null) {
            UserData userData = new UserData();
            b.a(a2, userData);
            this.f16405a.a().aI.a(userData).a();
        }
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public int f16649a;

        public a(int i) {
            super("GetUserInfoInteractor" + i, "use_case", 1000, true);
            this.f16649a = i;
        }
    }
}
