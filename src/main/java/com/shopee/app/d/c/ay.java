package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.g;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ay implements b<ax> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16532a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<g> f16533b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<af> f16534c;

    /* renamed from: a */
    public ax get() {
        return new ax(this.f16532a.get(), this.f16533b.get(), this.f16534c.get());
    }

    public static ax a(n nVar, g gVar, af afVar) {
        return new ax(nVar, gVar, afVar);
    }
}
