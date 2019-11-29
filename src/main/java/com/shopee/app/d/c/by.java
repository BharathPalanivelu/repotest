package com.shopee.app.d.c;

import b.a.a;
import b.a.b;
import com.shopee.app.data.store.be;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class by implements b<bx> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16645a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<be> f16646b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.garena.sticker.b> f16647c;

    /* renamed from: a */
    public bx get() {
        return new bx(this.f16645a.get(), a.b(this.f16646b), a.b(this.f16647c));
    }

    public static bx a(n nVar, b.a<be> aVar, b.a<com.garena.sticker.b> aVar2) {
        return new bx(nVar, aVar, aVar2);
    }
}
