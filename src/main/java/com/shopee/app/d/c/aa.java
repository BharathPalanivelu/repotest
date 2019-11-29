package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.ar;
import com.shopee.app.data.store.az;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class aa implements b<z> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16416a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<az> f16417b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ar> f16418c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ah> f16419d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ao> f16420e;

    /* renamed from: a */
    public z get() {
        return new z(this.f16416a.get(), this.f16417b.get(), this.f16418c.get(), this.f16419d.get(), this.f16420e.get());
    }

    public static z a(n nVar, az azVar, ar arVar, ah ahVar, ao aoVar) {
        return new z(nVar, azVar, arVar, ahVar, aoVar);
    }
}
