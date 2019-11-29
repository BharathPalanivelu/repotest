package com.shopee.app.application;

import b.a.b;
import b.a.c;
import f.n;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ab implements b<n> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15843a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f15844b;

    public ab(c cVar, Provider<OkHttpClient> provider) {
        this.f15843a = cVar;
        this.f15844b = provider;
    }

    /* renamed from: a */
    public n get() {
        return (n) c.a(this.f15843a.a(this.f15844b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ab a(c cVar, Provider<OkHttpClient> provider) {
        return new ab(cVar, provider);
    }
}
