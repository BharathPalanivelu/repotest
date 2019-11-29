package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.c.a;

public final class UserModule_ProvideOrderCountStoreFactory implements b<a> {
    private final UserModule module;

    public UserModule_ProvideOrderCountStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public a get() {
        return (a) c.a(this.module.provideOrderCountStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideOrderCountStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideOrderCountStoreFactory(userModule);
    }

    public static a proxyProvideOrderCountStore(UserModule userModule) {
        return (a) c.a(userModule.provideOrderCountStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
