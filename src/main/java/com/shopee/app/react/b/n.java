package com.shopee.app.react.b;

import b.a.b;
import com.garena.reactpush.d.a;
import com.garena.reactpush.d.c;
import com.garena.reactpush.d.h;
import javax.inject.Provider;

public final class n implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18618a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.garena.reactpush.b.b> f18619b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<a> f18620c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.garena.reactpush.e.c.a> f18621d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<h> f18622e;

    public n(e eVar, Provider<com.garena.reactpush.b.b> provider, Provider<a> provider2, Provider<com.garena.reactpush.e.c.a> provider3, Provider<h> provider4) {
        this.f18618a = eVar;
        this.f18619b = provider;
        this.f18620c = provider2;
        this.f18621d = provider3;
        this.f18622e = provider4;
    }

    /* renamed from: a */
    public c get() {
        return (c) b.a.c.a(this.f18618a.a(this.f18619b.get(), this.f18620c.get(), this.f18621d.get(), this.f18622e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static n a(e eVar, Provider<com.garena.reactpush.b.b> provider, Provider<a> provider2, Provider<com.garena.reactpush.e.c.a> provider3, Provider<h> provider4) {
        return new n(eVar, provider, provider2, provider3, provider4);
    }
}
