package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import javax.inject.Provider;

public final class q implements b<RegionConfig> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15779a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RegionConfigStore> f15780b;

    public q(b bVar, Provider<RegionConfigStore> provider) {
        this.f15779a = bVar;
        this.f15780b = provider;
    }

    /* renamed from: a */
    public RegionConfig get() {
        return (RegionConfig) c.a(this.f15779a.a(this.f15780b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static q a(b bVar, Provider<RegionConfigStore> provider) {
        return new q(bVar, provider);
    }
}
