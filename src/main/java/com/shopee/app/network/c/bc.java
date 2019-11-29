package com.shopee.app.network.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.network.c.bb;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bc implements b<bb.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ah> f17852a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f17853b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ao> f17854c;

    /* renamed from: a */
    public bb.a get() {
        return new bb.a(this.f17852a.get(), this.f17853b.get(), this.f17854c.get());
    }

    public static bb.a a(ah ahVar, n nVar, ao aoVar) {
        return new bb.a(ahVar, nVar, aoVar);
    }
}
