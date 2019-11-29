package com.shopee.app.d.c;

import b.a.a;
import b.a.b;
import com.shopee.app.data.store.be;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class q implements b<p> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17114a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<be> f17115b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.garena.sticker.b> f17116c;

    /* renamed from: a */
    public p get() {
        return new p(this.f17114a.get(), a.b(this.f17115b), a.b(this.f17116c));
    }

    public static p a(n nVar, b.a<be> aVar, b.a<com.garena.sticker.b> aVar2) {
        return new p(nVar, aVar, aVar2);
    }
}
