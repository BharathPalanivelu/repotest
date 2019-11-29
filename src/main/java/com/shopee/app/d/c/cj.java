package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ap;
import com.shopee.app.data.store.bg;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cj implements b<ci> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16689a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ap> f16690b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bg> f16691c;

    /* renamed from: a */
    public ci get() {
        return new ci(this.f16689a.get(), this.f16690b.get(), this.f16691c.get());
    }

    public static ci a(n nVar, ap apVar, bg bgVar) {
        return new ci(nVar, apVar, bgVar);
    }
}
