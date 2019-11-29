package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.application.ar;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class s implements b<r> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17120a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ar> f17121b;

    /* renamed from: a */
    public r get() {
        return new r(this.f17120a.get(), this.f17121b.get());
    }

    public static r a(n nVar, ar arVar) {
        return new r(nVar, arVar);
    }
}
