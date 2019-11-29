package com.shopee.app.appuser;

import b.a.b;
import b.a.c;

public final class UserModule_ProvideActionIdListStoreFactory implements b<com.shopee.app.data.store.b> {
    private final UserModule module;

    public UserModule_ProvideActionIdListStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public com.shopee.app.data.store.b get() {
        return (com.shopee.app.data.store.b) c.a(this.module.provideActionIdListStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideActionIdListStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideActionIdListStoreFactory(userModule);
    }

    public static com.shopee.app.data.store.b proxyProvideActionIdListStore(UserModule userModule) {
        return (com.shopee.app.data.store.b) c.a(userModule.provideActionIdListStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
