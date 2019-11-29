package com.shopee.app.network.c;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.bh;
import com.shopee.app.network.c.aw;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ax implements b<aw.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UserInfo> f17833a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f17834b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bh> f17835c;

    /* renamed from: a */
    public aw.a get() {
        return new aw.a(this.f17833a.get(), this.f17834b.get(), this.f17835c.get());
    }

    public static aw.a a(UserInfo userInfo, n nVar, bh bhVar) {
        return new aw.a(userInfo, nVar, bhVar);
    }
}
