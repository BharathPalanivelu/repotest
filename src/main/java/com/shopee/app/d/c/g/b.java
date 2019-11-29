package com.shopee.app.d.c.g;

import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.c.d;
import com.shopee.app.data.store.c.e;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17025a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e> f17026b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<d> f17027c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<c> f17028d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<at> f17029e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ao> f17030f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<bh> f17031g;
    private final Provider<ah> h;

    /* renamed from: a */
    public a get() {
        return new a(this.f17025a.get(), this.f17026b.get(), this.f17027c.get(), this.f17028d.get(), this.f17029e.get(), this.f17030f.get(), this.f17031g.get(), this.h.get());
    }

    public static a a(n nVar, e eVar, d dVar, c cVar, at atVar, ao aoVar, bh bhVar, ah ahVar) {
        return new a(nVar, eVar, dVar, cVar, atVar, aoVar, bhVar, ahVar);
    }
}
