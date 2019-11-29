package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ServerConfigStore;
import com.shopee.app.h.p;
import com.shopee.app.util.bh;
import javax.inject.Provider;

public final class ad implements b<p> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15849a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ServerConfigStore> f15850b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bh> f15851c;

    public ad(c cVar, Provider<ServerConfigStore> provider, Provider<bh> provider2) {
        this.f15849a = cVar;
        this.f15850b = provider;
        this.f15851c = provider2;
    }

    /* renamed from: a */
    public p get() {
        return (p) c.a(this.f15849a.a(this.f15850b.get(), this.f15851c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ad a(c cVar, Provider<ServerConfigStore> provider, Provider<bh> provider2) {
        return new ad(cVar, provider, provider2);
    }
}
