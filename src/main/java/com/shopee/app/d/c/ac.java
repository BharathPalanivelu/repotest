package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.m;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ac implements b<ab> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16423a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<m> f16424b;

    /* renamed from: a */
    public ab get() {
        return new ab(this.f16423a.get(), this.f16424b.get());
    }

    public static ab a(n nVar, m mVar) {
        return new ab(nVar, mVar);
    }
}
