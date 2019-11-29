package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class dy implements b<dx> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16874a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f16875b;

    /* renamed from: a */
    public dx get() {
        return new dx(this.f16874a.get(), this.f16875b.get());
    }

    public static dx a(n nVar, bh bhVar) {
        return new dx(nVar, bhVar);
    }
}
