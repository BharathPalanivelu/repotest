package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.at;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bj implements b<bi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16585a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<at> f16586b;

    /* renamed from: a */
    public bi get() {
        return new bi(this.f16585a.get(), this.f16586b.get());
    }

    public static bi a(n nVar, at atVar) {
        return new bi(nVar, atVar);
    }
}
