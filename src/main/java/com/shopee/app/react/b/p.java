package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.garena.reactpush.d.h;
import com.shopee.app.react.a.a;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class p implements b<h> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18629a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f18630b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.garena.reactpush.b.b> f18631c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<a> f18632d;

    public p(e eVar, Provider<OkHttpClient> provider, Provider<com.garena.reactpush.b.b> provider2, Provider<a> provider3) {
        this.f18629a = eVar;
        this.f18630b = provider;
        this.f18631c = provider2;
        this.f18632d = provider3;
    }

    /* renamed from: a */
    public h get() {
        return (h) c.a(this.f18629a.a(this.f18630b.get(), this.f18631c.get(), this.f18632d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static p a(e eVar, Provider<OkHttpClient> provider, Provider<com.garena.reactpush.b.b> provider2, Provider<a> provider3) {
        return new p(eVar, provider, provider2, provider3);
    }
}
