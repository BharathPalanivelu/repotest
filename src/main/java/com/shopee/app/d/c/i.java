package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.at;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class i implements b<h> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17049a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<at> f17050b;

    /* renamed from: a */
    public h get() {
        return new h(this.f17049a.get(), this.f17050b.get());
    }

    public static h a(n nVar, at atVar) {
        return new h(nVar, atVar);
    }
}
