package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class df implements b<de> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16796a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f16797b;

    /* renamed from: a */
    public de get() {
        return new de(this.f16796a.get(), this.f16797b.get());
    }

    public static de a(n nVar, bh bhVar) {
        return new de(nVar, bhVar);
    }
}
