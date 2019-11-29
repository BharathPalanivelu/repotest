package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import com.shopee.app.util.datapoint.a.a;
import f.n;
import javax.inject.Provider;

public final class m implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15886a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15887b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<aa> f15888c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<z> f15889d;

    public m(c cVar, Provider<n> provider, Provider<aa> provider2, Provider<z> provider3) {
        this.f15886a = cVar;
        this.f15887b = provider;
        this.f15888c = provider2;
        this.f15889d = provider3;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f15886a.a(this.f15887b.get(), this.f15888c.get(), this.f15889d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static m a(c cVar, Provider<n> provider, Provider<aa> provider2, Provider<z> provider3) {
        return new m(cVar, provider, provider2, provider3);
    }
}
