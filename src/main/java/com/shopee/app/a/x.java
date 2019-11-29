package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.k;
import f.n;
import javax.inject.Provider;

public final class x implements b<k> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15790a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15791b;

    public x(b bVar, Provider<n> provider) {
        this.f15790a = bVar;
        this.f15791b = provider;
    }

    /* renamed from: a */
    public k get() {
        return (k) c.a(this.f15790a.c(this.f15791b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static x a(b bVar, Provider<n> provider) {
        return new x(bVar, provider);
    }
}
