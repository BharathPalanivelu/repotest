package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bs implements b<br> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16623a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ao> f16624b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ah> f16625c;

    /* renamed from: a */
    public br get() {
        return new br(this.f16623a.get(), this.f16624b.get(), this.f16625c.get());
    }

    public static br a(n nVar, ao aoVar, ah ahVar) {
        return new br(nVar, aoVar, ahVar);
    }
}
