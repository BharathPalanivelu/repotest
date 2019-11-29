package com.shopee.app.appuser;

import b.a.a;
import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.jobdispatcher.DataPointJobConfigStore;
import javax.inject.Provider;

public final class UserModule_ProvideDataPointJobConfigStoreFactory implements b<DataPointJobConfigStore> {
    private final UserModule module;
    private final Provider<SettingConfigStore> storeProvider;

    public UserModule_ProvideDataPointJobConfigStoreFactory(UserModule userModule, Provider<SettingConfigStore> provider) {
        this.module = userModule;
        this.storeProvider = provider;
    }

    public DataPointJobConfigStore get() {
        return (DataPointJobConfigStore) c.a(this.module.provideDataPointJobConfigStore(a.b(this.storeProvider)), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideDataPointJobConfigStoreFactory create(UserModule userModule, Provider<SettingConfigStore> provider) {
        return new UserModule_ProvideDataPointJobConfigStoreFactory(userModule, provider);
    }

    public static DataPointJobConfigStore proxyProvideDataPointJobConfigStore(UserModule userModule, b.a<SettingConfigStore> aVar) {
        return (DataPointJobConfigStore) c.a(userModule.provideDataPointJobConfigStore(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
