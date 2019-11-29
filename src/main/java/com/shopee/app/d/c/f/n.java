package com.shopee.app.d.c.f;

import b.a.b;
import com.shopee.app.data.store.o;
import javax.inject.Provider;

public final class n implements b<m> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<com.shopee.app.util.n> f16999a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<o> f17000b;

    /* renamed from: a */
    public m get() {
        return new m(this.f16999a.get(), this.f17000b.get());
    }

    public static m a(com.shopee.app.util.n nVar, o oVar) {
        return new m(nVar, oVar);
    }
}
