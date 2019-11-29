package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.d;
import f.n;
import javax.inject.Provider;

public final class j implements b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15768a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15769b;

    public j(b bVar, Provider<n> provider) {
        this.f15768a = bVar;
        this.f15769b = provider;
    }

    /* renamed from: a */
    public d get() {
        return (d) c.a(this.f15768a.f(this.f15769b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static j a(b bVar, Provider<n> provider) {
        return new j(bVar, provider);
    }
}
