package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.g;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ch implements b<cg> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16685a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<g> f16686b;

    /* renamed from: a */
    public cg get() {
        return new cg(this.f16685a.get(), this.f16686b.get());
    }

    public static cg a(n nVar, g gVar) {
        return new cg(nVar, gVar);
    }
}
