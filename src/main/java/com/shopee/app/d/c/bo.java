package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.c;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bo implements b<bn> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16613a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.shopee.app.data.store.b> f16614b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<c> f16615c;

    /* renamed from: a */
    public bn get() {
        return new bn(this.f16613a.get(), this.f16614b.get(), this.f16615c.get());
    }

    public static bn a(n nVar, com.shopee.app.data.store.b bVar, c cVar) {
        return new bn(nVar, bVar, cVar);
    }
}
