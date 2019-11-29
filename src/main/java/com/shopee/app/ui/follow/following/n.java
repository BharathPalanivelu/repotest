package com.shopee.app.ui.follow.following;

import com.shopee.app.d.c.a;
import com.shopee.app.data.store.t;
import com.shopee.app.database.orm.bean.DBContactInfo;
import java.util.List;

public class n extends a {

    /* renamed from: c  reason: collision with root package name */
    private int f21658c;

    /* renamed from: d  reason: collision with root package name */
    private final t f21659d;

    /* renamed from: e  reason: collision with root package name */
    private final com.shopee.app.util.n f21660e;

    /* access modifiers changed from: protected */
    public String d() {
        return "QueryFBContactInteractor";
    }

    public n(com.shopee.app.util.n nVar, t tVar) {
        super(nVar);
        this.f21660e = nVar;
        this.f21659d = tVar;
    }

    public void a(int i) {
        this.f21658c = i;
        c();
    }

    /* access modifiers changed from: protected */
    public void c() {
        e();
    }

    private void e() {
        List<DBContactInfo> b2 = this.f21659d.b(this.f21658c);
        for (DBContactInfo d2 : b2) {
            d2.d(2);
        }
        this.f21660e.a("CONTACT_LOADED", (com.garena.android.appkit.b.a) new l(b2, this.f21658c));
    }
}
