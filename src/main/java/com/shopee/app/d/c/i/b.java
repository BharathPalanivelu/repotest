package com.shopee.app.d.c.i;

import com.shopee.app.data.store.v;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17054a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<v> f17055b;

    /* renamed from: a */
    public a get() {
        return new a(this.f17054a.get(), this.f17055b.get());
    }

    public static a a(n nVar, v vVar) {
        return new a(nVar, vVar);
    }
}
