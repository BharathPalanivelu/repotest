package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import javax.inject.Provider;

public final class n implements b<com.shopee.app.util.datapoint.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15890a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<f.n> f15891b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<aa> f15892c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<z> f15893d;

    public n(c cVar, Provider<f.n> provider, Provider<aa> provider2, Provider<z> provider3) {
        this.f15890a = cVar;
        this.f15891b = provider;
        this.f15892c = provider2;
        this.f15893d = provider3;
    }

    /* renamed from: a */
    public com.shopee.app.util.datapoint.a.b get() {
        return (com.shopee.app.util.datapoint.a.b) c.a(this.f15890a.d(this.f15891b.get(), this.f15892c.get(), this.f15893d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static n a(c cVar, Provider<f.n> provider, Provider<aa> provider2, Provider<z> provider3) {
        return new n(cVar, provider, provider2, provider3);
    }
}
