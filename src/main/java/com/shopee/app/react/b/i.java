package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.garena.reactpush.e.c.a;
import javax.inject.Provider;

public final class i implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18604a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.shopee.app.react.a.a> f18605b;

    public i(e eVar, Provider<com.shopee.app.react.a.a> provider) {
        this.f18604a = eVar;
        this.f18605b = provider;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f18604a.c(this.f18605b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static i a(e eVar, Provider<com.shopee.app.react.a.a> provider) {
        return new i(eVar, provider);
    }
}
