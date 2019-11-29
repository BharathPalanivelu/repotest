package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.f;
import f.n;
import javax.inject.Provider;

public final class k implements b<f> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15770a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15771b;

    public k(b bVar, Provider<n> provider) {
        this.f15770a = bVar;
        this.f15771b = provider;
    }

    /* renamed from: a */
    public f get() {
        return (f) c.a(this.f15770a.d(this.f15771b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static k a(b bVar, Provider<n> provider) {
        return new k(bVar, provider);
    }
}
