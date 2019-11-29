package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.shopee.app.react.a.a;
import javax.inject.Provider;

public final class g implements b<com.garena.reactpush.b.b> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18601a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<a> f18602b;

    public g(e eVar, Provider<a> provider) {
        this.f18601a = eVar;
        this.f18602b = provider;
    }

    /* renamed from: a */
    public com.garena.reactpush.b.b get() {
        return (com.garena.reactpush.b.b) c.a(this.f18601a.a(this.f18602b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g a(e eVar, Provider<a> provider) {
        return new g(eVar, provider);
    }
}
