package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.p;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ah implements b<ag> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16455a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ao> f16456b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<p> f16457c;

    /* renamed from: a */
    public ag get() {
        return new ag(this.f16455a.get(), this.f16456b.get(), this.f16457c.get());
    }

    public static ag a(n nVar, ao aoVar, p pVar) {
        return new ag(nVar, aoVar, pVar);
    }
}
