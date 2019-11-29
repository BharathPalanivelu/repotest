package com.shopee.app.ui.product.add;

import b.a.b;
import com.shopee.app.data.store.be;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ak implements b<aj> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f24004a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<be> f24005b;

    /* renamed from: a */
    public aj get() {
        return new aj(this.f24004a.get(), this.f24005b.get());
    }

    public static aj a(n nVar, be beVar) {
        return new aj(nVar, beVar);
    }
}
