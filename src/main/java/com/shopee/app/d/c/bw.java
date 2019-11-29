package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.c;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bw implements b<bv> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16637a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<c> f16638b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.shopee.app.data.store.b> f16639c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.shopee.app.g.b> f16640d;

    /* renamed from: a */
    public bv get() {
        return new bv(this.f16637a.get(), this.f16638b.get(), this.f16639c.get(), this.f16640d.get());
    }

    public static bv a(n nVar, c cVar, com.shopee.app.data.store.b bVar, com.shopee.app.g.b bVar2) {
        return new bv(nVar, cVar, bVar, bVar2);
    }
}
