package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.ui.common.a;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class f implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15761a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f15762b;

    public f(b bVar, Provider<n> provider) {
        this.f15761a = bVar;
        this.f15762b = provider;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f15761a.a(this.f15762b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static f a(b bVar, Provider<n> provider) {
        return new f(bVar, provider);
    }
}
