package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class av implements b<au> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16519a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ah> f16520b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ao> f16521c;

    /* renamed from: a */
    public au get() {
        return new au(this.f16519a.get(), this.f16520b.get(), this.f16521c.get());
    }

    public static au a(n nVar, ah ahVar, ao aoVar) {
        return new au(nVar, ahVar, aoVar);
    }
}
