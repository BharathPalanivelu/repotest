package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.az;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bf implements b<be> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16567a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<az> f16568b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ah> f16569c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ao> f16570d;

    /* renamed from: a */
    public be get() {
        return new be(this.f16567a.get(), this.f16568b.get(), this.f16569c.get(), this.f16570d.get());
    }

    public static be a(n nVar, az azVar, ah ahVar, ao aoVar) {
        return new be(nVar, azVar, ahVar, aoVar);
    }
}
