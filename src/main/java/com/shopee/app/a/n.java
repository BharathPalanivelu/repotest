package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.i;
import javax.inject.Provider;

public final class n implements b<i> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15775a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<f.n> f15776b;

    public n(b bVar, Provider<f.n> provider) {
        this.f15775a = bVar;
        this.f15776b = provider;
    }

    /* renamed from: a */
    public i get() {
        return (i) c.a(this.f15775a.h(this.f15776b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static n a(b bVar, Provider<f.n> provider) {
        return new n(bVar, provider);
    }
}
