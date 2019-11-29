package com.shopee.app.d.c.c;

import b.a.b;
import com.shopee.app.data.store.ar;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class d implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16663a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ar> f16664b;

    /* renamed from: a */
    public c get() {
        return new c(this.f16663a.get(), this.f16664b.get());
    }

    public static c a(n nVar, ar arVar) {
        return new c(nVar, arVar);
    }
}
