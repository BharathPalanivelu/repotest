package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.m;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class y implements b<x> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17137a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<m> f17138b;

    /* renamed from: a */
    public x get() {
        return new x(this.f17137a.get(), this.f17138b.get());
    }

    public static x a(n nVar, m mVar) {
        return new x(nVar, mVar);
    }
}
