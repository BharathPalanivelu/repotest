package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.j;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ee implements b<ed> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16909a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<j> f16910b;

    /* renamed from: a */
    public ed get() {
        return new ed(this.f16909a.get(), this.f16910b.get());
    }

    public static ed a(n nVar, j jVar) {
        return new ed(nVar, jVar);
    }
}
