package com.shopee.app.d.c.j;

import com.shopee.app.data.store.aa;
import com.shopee.app.tracking.f;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import javax.inject.Provider;

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<f> f17063a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<aa> f17064b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<q> f17065c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<n> f17066d;

    public b(Provider<f> provider, Provider<aa> provider2, Provider<q> provider3, Provider<n> provider4) {
        this.f17063a = provider;
        this.f17064b = provider2;
        this.f17065c = provider3;
        this.f17066d = provider4;
    }

    /* renamed from: a */
    public a get() {
        return new a(this.f17063a.get(), this.f17064b.get(), this.f17065c.get(), this.f17066d.get());
    }

    public static b a(Provider<f> provider, Provider<aa> provider2, Provider<q> provider3, Provider<n> provider4) {
        return new b(provider, provider2, provider3, provider4);
    }
}
