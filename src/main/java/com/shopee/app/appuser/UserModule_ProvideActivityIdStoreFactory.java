package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.d;

public final class UserModule_ProvideActivityIdStoreFactory implements b<d> {
    private final UserModule module;

    public UserModule_ProvideActivityIdStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public d get() {
        return (d) c.a(this.module.provideActivityIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideActivityIdStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideActivityIdStoreFactory(userModule);
    }

    public static d proxyProvideActivityIdStore(UserModule userModule) {
        return (d) c.a(userModule.provideActivityIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
