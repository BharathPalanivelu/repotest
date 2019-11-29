package com.shopee.app.network.c.i;

import b.a.b;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.network.c.i.u;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class v implements b<u.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FollowCounter> f17987a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RegionConfigStore> f17988b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<n> f17989c;

    /* renamed from: a */
    public u.a get() {
        return new u.a(this.f17987a.get(), this.f17988b.get(), this.f17989c.get());
    }

    public static u.a a(FollowCounter followCounter, RegionConfigStore regionConfigStore, n nVar) {
        return new u.a(followCounter, regionConfigStore, nVar);
    }
}
