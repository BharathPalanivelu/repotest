package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.c.a;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bl implements b<bk> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16590a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<a> f16591b;

    /* renamed from: a */
    public bk get() {
        return new bk(this.f16590a.get(), this.f16591b.get());
    }

    public static bk a(n nVar, a aVar) {
        return new bk(nVar, aVar);
    }
}
