package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.az;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ae implements b<ad> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16432a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<az> f16433b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ah> f16434c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ao> f16435d;

    /* renamed from: a */
    public ad get() {
        return new ad(this.f16432a.get(), this.f16433b.get(), this.f16434c.get(), this.f16435d.get());
    }

    public static ad a(n nVar, az azVar, ah ahVar, ao aoVar) {
        return new ad(nVar, azVar, ahVar, aoVar);
    }
}
