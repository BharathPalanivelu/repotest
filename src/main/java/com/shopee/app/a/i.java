package com.shopee.app.a;

import b.a.b;
import b.a.c;
import f.n;
import javax.inject.Provider;

public final class i implements b<com.shopee.app.network.http.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15766a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15767b;

    public i(b bVar, Provider<n> provider) {
        this.f15766a = bVar;
        this.f15767b = provider;
    }

    /* renamed from: a */
    public com.shopee.app.network.http.a.b get() {
        return (com.shopee.app.network.http.a.b) c.a(this.f15766a.b(this.f15767b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static i a(b bVar, Provider<n> provider) {
        return new i(bVar, provider);
    }
}
