package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.al;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ak implements b<com.garena.sticker.b> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15858a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<aa> f15859b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<al> f15860c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OkHttpClient> f15861d;

    public ak(c cVar, Provider<aa> provider, Provider<al> provider2, Provider<OkHttpClient> provider3) {
        this.f15858a = cVar;
        this.f15859b = provider;
        this.f15860c = provider2;
        this.f15861d = provider3;
    }

    /* renamed from: a */
    public com.garena.sticker.b get() {
        return (com.garena.sticker.b) c.a(this.f15858a.a(this.f15859b.get(), this.f15860c.get(), this.f15861d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ak a(c cVar, Provider<aa> provider, Provider<al> provider2, Provider<OkHttpClient> provider3) {
        return new ak(cVar, provider, provider2, provider3);
    }
}
