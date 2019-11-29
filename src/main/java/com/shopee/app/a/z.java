package com.shopee.app.a;

import b.a.b;
import com.shopee.app.react.modules.app.FirebasePerf.a;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.util.i.c;
import com.shopee.app.web.bridge.WebBridge;
import javax.inject.Provider;

public final class z implements b<WebBridge> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15793a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<a> f15794b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<g> f15795c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<c> f15796d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<com.shopee.app.util.e.a> f15797e;

    public z(b bVar, Provider<a> provider, Provider<g> provider2, Provider<c> provider3, Provider<com.shopee.app.util.e.a> provider4) {
        this.f15793a = bVar;
        this.f15794b = provider;
        this.f15795c = provider2;
        this.f15796d = provider3;
        this.f15797e = provider4;
    }

    /* renamed from: a */
    public WebBridge get() {
        return (WebBridge) b.a.c.a(this.f15793a.a(this.f15794b.get(), this.f15795c.get(), this.f15796d.get(), this.f15797e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static z a(b bVar, Provider<a> provider, Provider<g> provider2, Provider<c> provider3, Provider<com.shopee.app.util.e.a> provider4) {
        return new z(bVar, provider, provider2, provider3, provider4);
    }
}
