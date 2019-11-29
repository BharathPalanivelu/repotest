package com.shopee.app.network.c.k;

import b.a.b;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.c.e;
import com.shopee.app.network.c.k.j;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class k implements b<j.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f18019a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<c> f18020b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<e> f18021c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.shopee.app.data.store.c.b> f18022d;

    /* renamed from: a */
    public j.a get() {
        return new j.a(this.f18019a.get(), this.f18020b.get(), this.f18021c.get(), this.f18022d.get());
    }

    public static j.a a(n nVar, c cVar, e eVar, com.shopee.app.data.store.c.b bVar) {
        return new j.a(nVar, cVar, eVar, bVar);
    }
}
