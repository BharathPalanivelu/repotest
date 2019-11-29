package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.RegionConfigStore;

public final class aa implements b<RegionConfigStore> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15842a;

    public aa(c cVar) {
        this.f15842a = cVar;
    }

    /* renamed from: a */
    public RegionConfigStore get() {
        return (RegionConfigStore) c.a(this.f15842a.p(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static aa a(c cVar) {
        return new aa(cVar);
    }
}
