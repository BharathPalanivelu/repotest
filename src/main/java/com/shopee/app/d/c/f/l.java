package com.shopee.app.d.c.f;

import b.a.b;
import com.shopee.app.data.store.av;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class l implements b<k> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16995a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<av> f16996b;

    /* renamed from: a */
    public k get() {
        return new k(this.f16995a.get(), this.f16996b.get());
    }

    public static k a(n nVar, av avVar) {
        return new k(nVar, avVar);
    }
}
