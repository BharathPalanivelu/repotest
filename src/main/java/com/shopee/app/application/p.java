package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import com.shopee.app.util.datapoint.a.d;
import f.n;
import javax.inject.Provider;

public final class p implements b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15898a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15899b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<aa> f15900c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<z> f15901d;

    public p(c cVar, Provider<n> provider, Provider<aa> provider2, Provider<z> provider3) {
        this.f15898a = cVar;
        this.f15899b = provider;
        this.f15900c = provider2;
        this.f15901d = provider3;
    }

    /* renamed from: a */
    public d get() {
        return (d) c.a(this.f15898a.b(this.f15899b.get(), this.f15900c.get(), this.f15901d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static p a(c cVar, Provider<n> provider, Provider<aa> provider2, Provider<z> provider3) {
        return new p(cVar, provider, provider2, provider3);
    }
}
