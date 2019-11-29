package com.shopee.app.a;

import b.a.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.tracking.c;
import javax.inject.Provider;

public final class v implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15786a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingConfigStore> f15787b;

    public v(b bVar, Provider<SettingConfigStore> provider) {
        this.f15786a = bVar;
        this.f15787b = provider;
    }

    /* renamed from: a */
    public c get() {
        return (c) b.a.c.a(this.f15786a.a(this.f15787b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static v a(b bVar, Provider<SettingConfigStore> provider) {
        return new v(bVar, provider);
    }
}
