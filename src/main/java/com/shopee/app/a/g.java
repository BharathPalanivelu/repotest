package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.a;
import f.n;
import javax.inject.Provider;

public final class g implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15763a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15764b;

    public g(b bVar, Provider<n> provider) {
        this.f15763a = bVar;
        this.f15764b = provider;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f15763a.a(this.f15764b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g a(b bVar, Provider<n> provider) {
        return new g(bVar, provider);
    }
}
