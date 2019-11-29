package com.shopee.app.network.c;

import b.a.b;
import com.shopee.app.data.store.bg;
import com.shopee.app.network.c.au;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class av implements b<au.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17828a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bg> f17829b;

    /* renamed from: a */
    public au.a get() {
        return new au.a(this.f17828a.get(), this.f17829b.get());
    }

    public static au.a a(n nVar, bg bgVar) {
        return new au.a(nVar, bgVar);
    }
}
