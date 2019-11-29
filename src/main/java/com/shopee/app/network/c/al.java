package com.shopee.app.network.c;

import b.a.b;
import com.shopee.app.data.store.ap;
import com.shopee.app.data.store.bg;
import com.shopee.app.network.c.ak;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class al implements b<ak.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17806a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ap> f17807b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bg> f17808c;

    /* renamed from: a */
    public ak.a get() {
        return new ak.a(this.f17806a.get(), this.f17807b.get(), this.f17808c.get());
    }

    public static ak.a a(n nVar, ap apVar, bg bgVar) {
        return new ak.a(nVar, apVar, bgVar);
    }
}
