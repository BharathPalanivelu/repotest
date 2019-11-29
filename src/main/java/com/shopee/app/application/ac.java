package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ServerConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.h.a.a;
import com.shopee.app.util.bh;
import javax.inject.Provider;

public final class ac implements b<ServerConfigStore> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15845a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f15846b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<a> f15847c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<al> f15848d;

    public ac(c cVar, Provider<bh> provider, Provider<a> provider2, Provider<al> provider3) {
        this.f15845a = cVar;
        this.f15846b = provider;
        this.f15847c = provider2;
        this.f15848d = provider3;
    }

    /* renamed from: a */
    public ServerConfigStore get() {
        return (ServerConfigStore) c.a(this.f15845a.a(this.f15846b.get(), this.f15847c.get(), this.f15848d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ac a(c cVar, Provider<bh> provider, Provider<a> provider2, Provider<al> provider3) {
        return new ac(cVar, provider, provider2, provider3);
    }
}
