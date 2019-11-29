package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.tracking.a;
import javax.inject.Provider;

public final class UserModule_ProvideActionTrackerFactory implements b<a> {
    private final Provider<aa> deviceStoreProvider;
    private final UserModule module;
    private final Provider<SettingConfigStore> settingConfigStoreProvider;

    public UserModule_ProvideActionTrackerFactory(UserModule userModule, Provider<SettingConfigStore> provider, Provider<aa> provider2) {
        this.module = userModule;
        this.settingConfigStoreProvider = provider;
        this.deviceStoreProvider = provider2;
    }

    public a get() {
        return (a) c.a(this.module.provideActionTracker(this.settingConfigStoreProvider.get(), this.deviceStoreProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideActionTrackerFactory create(UserModule userModule, Provider<SettingConfigStore> provider, Provider<aa> provider2) {
        return new UserModule_ProvideActionTrackerFactory(userModule, provider, provider2);
    }

    public static a proxyProvideActionTracker(UserModule userModule, SettingConfigStore settingConfigStore, aa aaVar) {
        return (a) c.a(userModule.provideActionTracker(settingConfigStore, aaVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
