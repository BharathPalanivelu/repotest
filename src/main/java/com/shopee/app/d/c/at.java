package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class at implements b<as> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16512a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ao> f16513b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ah> f16514c;

    /* renamed from: a */
    public as get() {
        return new as(this.f16512a.get(), this.f16513b.get(), this.f16514c.get());
    }

    public static as a(n nVar, ao aoVar, ah ahVar) {
        return new as(nVar, aoVar, ahVar);
    }
}
