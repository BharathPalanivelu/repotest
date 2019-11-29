package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.m;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class al implements b<ak> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16484a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<m> f16485b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ah> f16486c;

    /* renamed from: a */
    public ak get() {
        return new ak(this.f16484a.get(), this.f16485b.get(), this.f16486c.get());
    }

    public static ak a(n nVar, m mVar, ah ahVar) {
        return new ak(nVar, mVar, ahVar);
    }
}
