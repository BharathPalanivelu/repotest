package com.shopee.app.d.c.h;

import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17046a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ah> f17047b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ao> f17048c;

    /* renamed from: a */
    public a get() {
        return new a(this.f17046a.get(), this.f17047b.get(), this.f17048c.get());
    }

    public static a a(n nVar, ah ahVar, ao aoVar) {
        return new a(nVar, ahVar, aoVar);
    }
}
