package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class dr implements b<dq> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16839a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<p> f16840b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<av> f16841c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserInfo> f16842d;

    /* renamed from: a */
    public dq get() {
        return new dq(this.f16839a.get(), this.f16840b.get(), this.f16841c.get(), this.f16842d.get());
    }

    public static dq a(n nVar, p pVar, av avVar, UserInfo userInfo) {
        return new dq(nVar, pVar, avVar, userInfo);
    }
}
