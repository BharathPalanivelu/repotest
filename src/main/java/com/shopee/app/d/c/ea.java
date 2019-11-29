package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ea implements b<dz> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16897a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f16898b;

    /* renamed from: a */
    public dz get() {
        return new dz(this.f16897a.get(), this.f16898b.get());
    }

    public static dz a(n nVar, bh bhVar) {
        return new dz(nVar, bhVar);
    }
}
