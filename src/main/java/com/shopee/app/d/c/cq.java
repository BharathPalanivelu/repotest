package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.c;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cq implements b<cp> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16712a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<c> f16713b;

    /* renamed from: a */
    public cp get() {
        return new cp(this.f16712a.get(), this.f16713b.get());
    }

    public static cp a(n nVar, c cVar) {
        return new cp(nVar, cVar);
    }
}
