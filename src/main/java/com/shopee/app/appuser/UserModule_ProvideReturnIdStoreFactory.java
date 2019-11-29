package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.c.d;

public final class UserModule_ProvideReturnIdStoreFactory implements b<d> {
    private final UserModule module;

    public UserModule_ProvideReturnIdStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public d get() {
        return (d) c.a(this.module.provideReturnIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideReturnIdStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideReturnIdStoreFactory(userModule);
    }

    public static d proxyProvideReturnIdStore(UserModule userModule) {
        return (d) c.a(userModule.provideReturnIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
