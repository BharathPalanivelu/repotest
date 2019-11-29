package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.instagram.e;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cd implements b<cc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16671a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e> f16672b;

    /* renamed from: a */
    public cc get() {
        return new cc(this.f16671a.get(), this.f16672b.get());
    }

    public static cc a(n nVar, e eVar) {
        return new cc(nVar, eVar);
    }
}
