package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.an;
import com.shopee.app.data.store.g;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ba implements b<az> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16545a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bi> f16546b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<cg> f16547c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<an> f16548d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<g> f16549e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<af> f16550f;

    /* renamed from: a */
    public az get() {
        return new az(this.f16545a.get(), this.f16546b.get(), this.f16547c.get(), this.f16548d.get(), this.f16549e.get(), this.f16550f.get());
    }

    public static az a(n nVar, bi biVar, cg cgVar, an anVar, g gVar, af afVar) {
        return new az(nVar, biVar, cgVar, anVar, gVar, afVar);
    }
}
