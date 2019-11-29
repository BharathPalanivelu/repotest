package com.shopee.app.d.c.e;

import com.shopee.app.data.store.a.a;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.c.c;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16893a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<a> f16894b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<c> f16895c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<al> f16896d;

    /* renamed from: a */
    public a get() {
        return new a(this.f16893a.get(), this.f16894b.get(), this.f16895c.get(), this.f16896d.get());
    }

    public static a a(n nVar, a aVar, c cVar, al alVar) {
        return new a(nVar, aVar, cVar, alVar);
    }
}
