package com.shopee.app.i.a;

import b.a.b;
import b.a.c;
import com.shopee.sdk.modules.a;
import javax.inject.Provider;

public final class f implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f17719a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.shopee.sdk.modules.ui.b.a> f17720b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.shopee.sdk.modules.ui.navigator.b> f17721c;

    public f(c cVar, Provider<com.shopee.sdk.modules.ui.b.a> provider, Provider<com.shopee.sdk.modules.ui.navigator.b> provider2) {
        this.f17719a = cVar;
        this.f17720b = provider;
        this.f17721c = provider2;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f17719a.a(this.f17720b.get(), this.f17721c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static f a(c cVar, Provider<com.shopee.sdk.modules.ui.b.a> provider, Provider<com.shopee.sdk.modules.ui.navigator.b> provider2) {
        return new f(cVar, provider, provider2);
    }
}
