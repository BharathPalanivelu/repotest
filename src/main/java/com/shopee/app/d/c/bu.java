package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.bh;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class bu implements b<bt> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16631a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f16632b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16633c;

    /* renamed from: a */
    public bt get() {
        return new bt(this.f16631a.get(), this.f16632b.get(), this.f16633c.get());
    }

    public static bt a(n nVar, bh bhVar, SettingConfigStore settingConfigStore) {
        return new bt(nVar, bhVar, settingConfigStore);
    }
}
