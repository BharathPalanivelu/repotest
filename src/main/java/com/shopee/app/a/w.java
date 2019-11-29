package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import javax.inject.Provider;

public final class w implements b<com.shopee.app.tracking.trackingv3.b> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15788a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingConfigStore> f15789b;

    public w(b bVar, Provider<SettingConfigStore> provider) {
        this.f15788a = bVar;
        this.f15789b = provider;
    }

    /* renamed from: a */
    public com.shopee.app.tracking.trackingv3.b get() {
        return (com.shopee.app.tracking.trackingv3.b) c.a(this.f15788a.b(this.f15789b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static w a(b bVar, Provider<SettingConfigStore> provider) {
        return new w(bVar, provider);
    }
}
