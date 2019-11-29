package com.shopee.app.ui.product.b;

import b.a.b;
import com.shopee.app.network.http.a.g;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class e implements b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f24392a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<g> f24393b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<a> f24394c;

    public e(Provider<n> provider, Provider<g> provider2, Provider<a> provider3) {
        this.f24392a = provider;
        this.f24393b = provider2;
        this.f24394c = provider3;
    }

    /* renamed from: a */
    public d get() {
        return new d(this.f24392a.get(), this.f24393b.get(), this.f24394c.get());
    }

    public static e a(Provider<n> provider, Provider<g> provider2, Provider<a> provider3) {
        return new e(provider, provider2, provider3);
    }
}
