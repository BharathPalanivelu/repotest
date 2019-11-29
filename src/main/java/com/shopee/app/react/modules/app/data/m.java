package com.shopee.app.react.modules.app.data;

import b.a.b;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class m implements b<l> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ThemeStore> f18762a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f18763b;

    public m(Provider<ThemeStore> provider, Provider<n> provider2) {
        this.f18762a = provider;
        this.f18763b = provider2;
    }

    /* renamed from: a */
    public l get() {
        return new l(this.f18762a.get(), this.f18763b.get());
    }

    public static m a(Provider<ThemeStore> provider, Provider<n> provider2) {
        return new m(provider, provider2);
    }
}
