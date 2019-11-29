package com.shopee.app.appuser;

import b.a.a;
import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.jobdispatcher.ReactJobConfigStore;
import javax.inject.Provider;

public final class UserModule_ProvideReactJobConfigStoreFactory implements b<ReactJobConfigStore> {
    private final UserModule module;
    private final Provider<SettingConfigStore> storeProvider;

    public UserModule_ProvideReactJobConfigStoreFactory(UserModule userModule, Provider<SettingConfigStore> provider) {
        this.module = userModule;
        this.storeProvider = provider;
    }

    public ReactJobConfigStore get() {
        return (ReactJobConfigStore) c.a(this.module.provideReactJobConfigStore(a.b(this.storeProvider)), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideReactJobConfigStoreFactory create(UserModule userModule, Provider<SettingConfigStore> provider) {
        return new UserModule_ProvideReactJobConfigStoreFactory(userModule, provider);
    }

    public static ReactJobConfigStore proxyProvideReactJobConfigStore(UserModule userModule, b.a<SettingConfigStore> aVar) {
        return (ReactJobConfigStore) c.a(userModule.provideReactJobConfigStore(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
