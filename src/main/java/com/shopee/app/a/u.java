package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.j;
import f.n;
import javax.inject.Provider;

public final class u implements b<j> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15784a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15785b;

    public u(b bVar, Provider<n> provider) {
        this.f15784a = bVar;
        this.f15785b = provider;
    }

    /* renamed from: a */
    public j get() {
        return (j) c.a(this.f15784a.e(this.f15785b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static u a(b bVar, Provider<n> provider) {
        return new u(bVar, provider);
    }
}
