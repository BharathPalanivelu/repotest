package com.shopee.app.ui.order.detail;

import b.a.b;
import com.shopee.app.d.c.c;
import com.shopee.app.ui.order.k;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class d implements b<b> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f23603a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bi> f23604b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<k> f23605c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<c> f23606d;

    /* renamed from: a */
    public b get() {
        return new b(this.f23603a.get(), this.f23604b.get(), this.f23605c.get(), this.f23606d.get());
    }

    public static b a(n nVar, bi biVar, k kVar, c cVar) {
        return new b(nVar, biVar, kVar, cVar);
    }
}
