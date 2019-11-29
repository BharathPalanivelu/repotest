package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.ar;
import com.shopee.app.data.store.az;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bh implements b<bg> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16578a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<az> f16579b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ar> f16580c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ah> f16581d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ao> f16582e;

    /* renamed from: a */
    public bg get() {
        return new bg(this.f16578a.get(), this.f16579b.get(), this.f16580c.get(), this.f16581d.get(), this.f16582e.get());
    }

    public static bg a(n nVar, az azVar, ar arVar, ah ahVar, ao aoVar) {
        return new bg(nVar, azVar, arVar, ahVar, aoVar);
    }
}
