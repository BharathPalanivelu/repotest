package com.shopee.app.d.b.a.d;

import b.a.b;
import com.shopee.app.data.store.SettingConfigStore;
import javax.inject.Provider;

public final class k implements b<j> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16389a;

    /* renamed from: a */
    public j get() {
        return new j(this.f16389a.get());
    }

    public static j a(SettingConfigStore settingConfigStore) {
        return new j(settingConfigStore);
    }
}
