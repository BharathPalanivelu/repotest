package com.shopee.app.ui.follow.following.recommend;

import com.shopee.app.d.c.a;
import com.shopee.app.data.store.t;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.util.n;
import java.util.List;

public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    private int f21708c;

    /* renamed from: d  reason: collision with root package name */
    private final t f21709d;

    /* access modifiers changed from: protected */
    public String d() {
        return "FollowAllDBInteractor";
    }

    public g(n nVar, t tVar) {
        super(nVar);
        this.f21709d = tVar;
    }

    public void a(int i) {
        this.f21708c = i;
        c();
    }

    /* access modifiers changed from: protected */
    public void c() {
        e();
    }

    private void e() {
        List<DBContactInfo> b2 = this.f21709d.b(this.f21708c);
        for (DBContactInfo a2 : b2) {
            a2.a(true);
        }
        this.f21709d.a(b2);
    }
}
