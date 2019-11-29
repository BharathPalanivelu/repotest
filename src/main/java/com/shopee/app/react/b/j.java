package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.garena.reactpush.d.a;
import javax.inject.Provider;

public final class j implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18606a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.shopee.app.react.a.a> f18607b;

    public j(e eVar, Provider<com.shopee.app.react.a.a> provider) {
        this.f18606a = eVar;
        this.f18607b = provider;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f18606a.b(this.f18607b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static j a(e eVar, Provider<com.shopee.app.react.a.a> provider) {
        return new j(eVar, provider);
    }
}
