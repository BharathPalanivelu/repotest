package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class z implements b<k> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15914a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15915b;

    public z(c cVar, Provider<n> provider) {
        this.f15914a = cVar;
        this.f15915b = provider;
    }

    /* renamed from: a */
    public k get() {
        return (k) c.a(this.f15914a.a(this.f15915b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static z a(c cVar, Provider<n> provider) {
        return new z(cVar, provider);
    }
}
