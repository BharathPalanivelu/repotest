package com.shopee.app.d.c.f;

import b.a.b;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.bg;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class j implements b<i> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16991a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bg> f16992b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<av> f16993c;

    /* renamed from: a */
    public i get() {
        return new i(this.f16991a.get(), this.f16992b.get(), this.f16993c.get());
    }

    public static i a(n nVar, bg bgVar, av avVar) {
        return new i(nVar, bgVar, avVar);
    }
}
