package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ca implements b<bz> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16665a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f16666b;

    /* renamed from: a */
    public bz get() {
        return new bz(this.f16665a.get(), this.f16666b.get());
    }

    public static bz a(n nVar, bh bhVar) {
        return new bz(nVar, bhVar);
    }
}
