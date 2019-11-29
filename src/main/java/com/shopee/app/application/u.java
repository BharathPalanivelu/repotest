package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.aa;
import com.shopee.app.util.datapoint.b.a;
import f.n;
import javax.inject.Provider;

public final class u implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15907a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15908b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<aa> f15909c;

    public u(c cVar, Provider<n> provider, Provider<aa> provider2) {
        this.f15907a = cVar;
        this.f15908b = provider;
        this.f15909c = provider2;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f15907a.a(this.f15908b.get(), this.f15909c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static u a(c cVar, Provider<n> provider, Provider<aa> provider2) {
        return new u(cVar, provider, provider2);
    }
}
