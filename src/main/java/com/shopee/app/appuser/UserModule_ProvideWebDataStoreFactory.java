package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.WebDataStore;

public final class UserModule_ProvideWebDataStoreFactory implements b<WebDataStore> {
    private final UserModule module;

    public UserModule_ProvideWebDataStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public WebDataStore get() {
        return (WebDataStore) c.a(this.module.provideWebDataStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideWebDataStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideWebDataStoreFactory(userModule);
    }

    public static WebDataStore proxyProvideWebDataStore(UserModule userModule) {
        return (WebDataStore) c.a(userModule.provideWebDataStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
