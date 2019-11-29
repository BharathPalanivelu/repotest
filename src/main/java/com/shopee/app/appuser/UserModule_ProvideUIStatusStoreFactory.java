package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.be;

public final class UserModule_ProvideUIStatusStoreFactory implements b<be> {
    private final UserModule module;

    public UserModule_ProvideUIStatusStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public be get() {
        return (be) c.a(this.module.provideUIStatusStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideUIStatusStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideUIStatusStoreFactory(userModule);
    }

    public static be proxyProvideUIStatusStore(UserModule userModule) {
        return (be) c.a(userModule.provideUIStatusStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
