package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.be;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cx implements b<cw> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16747a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<be> f16748b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserInfo> f16749c;

    /* renamed from: a */
    public cw get() {
        return new cw(this.f16747a.get(), this.f16748b.get(), this.f16749c.get());
    }

    public static cw a(n nVar, be beVar, UserInfo userInfo) {
        return new cw(nVar, beVar, userInfo);
    }
}
