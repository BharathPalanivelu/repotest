package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.j;

public final class UserModule_ProvideBlacklistStoreFactory implements b<j> {
    private final UserModule module;

    public UserModule_ProvideBlacklistStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public j get() {
        return (j) c.a(this.module.provideBlacklistStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideBlacklistStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideBlacklistStoreFactory(userModule);
    }

    public static j proxyProvideBlacklistStore(UserModule userModule) {
        return (j) c.a(userModule.provideBlacklistStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
