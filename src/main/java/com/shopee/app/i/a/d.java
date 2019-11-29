package com.shopee.app.i.a;

import b.a.b;
import b.a.c;
import com.shopee.sdk.modules.ui.b.a;
import javax.inject.Provider;

public final class d implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f17716a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.shopee.app.application.a.b> f17717b;

    public d(c cVar, Provider<com.shopee.app.application.a.b> provider) {
        this.f17716a = cVar;
        this.f17717b = provider;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f17716a.a(this.f17717b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static d a(c cVar, Provider<com.shopee.app.application.a.b> provider) {
        return new d(cVar, provider);
    }
}
