package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.bb;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class eg implements b<ef> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16915a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bb> f16916b;

    /* renamed from: a */
    public ef get() {
        return new ef(this.f16915a.get(), this.f16916b.get());
    }

    public static ef a(n nVar, bb bbVar) {
        return new ef(nVar, bbVar);
    }
}
