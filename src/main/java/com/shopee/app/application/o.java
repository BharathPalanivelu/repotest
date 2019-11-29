package com.shopee.app.application;

import b.a.b;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import com.shopee.app.util.datapoint.a.c;
import f.n;
import javax.inject.Provider;

public final class o implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15894a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15895b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<aa> f15896c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<z> f15897d;

    public o(c cVar, Provider<n> provider, Provider<aa> provider2, Provider<z> provider3) {
        this.f15894a = cVar;
        this.f15895b = provider;
        this.f15896c = provider2;
        this.f15897d = provider3;
    }

    /* renamed from: a */
    public c get() {
        return (c) b.a.c.a(this.f15894a.c(this.f15895b.get(), this.f15896c.get(), this.f15897d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static o a(c cVar, Provider<n> provider, Provider<aa> provider2, Provider<z> provider3) {
        return new o(cVar, provider, provider2, provider3);
    }
}
