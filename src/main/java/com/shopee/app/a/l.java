package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.g;
import f.n;
import javax.inject.Provider;

public final class l implements b<g> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15772a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15773b;

    public l(b bVar, Provider<n> provider) {
        this.f15772a = bVar;
        this.f15773b = provider;
    }

    /* renamed from: a */
    public g get() {
        return (g) c.a(this.f15772a.g(this.f15773b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static l a(b bVar, Provider<n> provider) {
        return new l(bVar, provider);
    }
}
