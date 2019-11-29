package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.react.a.a;
import javax.inject.Provider;

public final class k implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18608a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingConfigStore> f18609b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<al> f18610c;

    public k(e eVar, Provider<SettingConfigStore> provider, Provider<al> provider2) {
        this.f18608a = eVar;
        this.f18609b = provider;
        this.f18610c = provider2;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f18608a.a(this.f18609b.get(), this.f18610c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static k a(e eVar, Provider<SettingConfigStore> provider, Provider<al> provider2) {
        return new k(eVar, provider, provider2);
    }
}
