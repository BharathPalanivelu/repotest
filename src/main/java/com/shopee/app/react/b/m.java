package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.facebook.react.ReactInstanceManager;
import com.garena.reactpush.c.d;
import com.shopee.app.react.a.a;
import com.shopee.app.react.i;
import javax.inject.Provider;

public final class m implements b<ReactInstanceManager> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18612a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<a> f18613b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<i> f18614c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.shopee.app.react.a> f18615d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<d> f18616e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<com.garena.reactpush.e.c.a> f18617f;

    public m(e eVar, Provider<a> provider, Provider<i> provider2, Provider<com.shopee.app.react.a> provider3, Provider<d> provider4, Provider<com.garena.reactpush.e.c.a> provider5) {
        this.f18612a = eVar;
        this.f18613b = provider;
        this.f18614c = provider2;
        this.f18615d = provider3;
        this.f18616e = provider4;
        this.f18617f = provider5;
    }

    /* renamed from: a */
    public ReactInstanceManager get() {
        return (ReactInstanceManager) c.a(this.f18612a.a(this.f18613b.get(), this.f18614c.get(), this.f18615d.get(), this.f18616e.get(), this.f18617f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static m a(e eVar, Provider<a> provider, Provider<i> provider2, Provider<com.shopee.app.react.a> provider3, Provider<d> provider4, Provider<com.garena.reactpush.e.c.a> provider5) {
        return new m(eVar, provider, provider2, provider3, provider4, provider5);
    }
}
