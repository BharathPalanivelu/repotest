package com.shopee.app.ui.chat2.block;

import b.a.b;
import com.shopee.app.data.store.k;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class p implements b<o> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f20350a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<k> f20351b;

    /* renamed from: a */
    public o get() {
        return new o(this.f20350a.get(), this.f20351b.get());
    }

    public static o a(n nVar, k kVar) {
        return new o(nVar, kVar);
    }
}
