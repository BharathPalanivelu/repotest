package com.shopee.app.ui.follow.following;

import com.shopee.app.d.c.a;
import com.shopee.app.network.d.q;
import com.shopee.app.network.g;
import com.shopee.app.util.n;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    q f21632c;

    /* renamed from: d  reason: collision with root package name */
    private int f21633d;

    /* access modifiers changed from: protected */
    public String d() {
        return "FollowShopInteractor";
    }

    public c(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f21632c.a(this.f21633d);
    }

    public g a(int i) {
        this.f21633d = i;
        this.f21632c = new q();
        a();
        return this.f21632c.i();
    }
}
