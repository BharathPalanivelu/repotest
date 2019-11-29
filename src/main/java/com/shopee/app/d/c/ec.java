package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.h;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ec implements b<eb> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16904a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<h> f16905b;

    /* renamed from: a */
    public eb get() {
        return new eb(this.f16904a.get(), this.f16905b.get());
    }

    public static eb a(n nVar, h hVar) {
        return new eb(nVar, hVar);
    }
}
