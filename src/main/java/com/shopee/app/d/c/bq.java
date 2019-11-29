package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bq implements b<bp> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16617a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f16618b;

    /* renamed from: a */
    public bp get() {
        return new bp(this.f16617a.get(), this.f16618b.get());
    }

    public static bp a(n nVar, bh bhVar) {
        return new bp(nVar, bhVar);
    }
}
