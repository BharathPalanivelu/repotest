package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.instagram.e;

public final class UserModule_ProvideInstagramClientFactory implements b<e> {
    private final UserModule module;

    public UserModule_ProvideInstagramClientFactory(UserModule userModule) {
        this.module = userModule;
    }

    public e get() {
        return (e) c.a(this.module.provideInstagramClient(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideInstagramClientFactory create(UserModule userModule) {
        return new UserModule_ProvideInstagramClientFactory(userModule);
    }

    public static e proxyProvideInstagramClient(UserModule userModule) {
        return (e) c.a(userModule.provideInstagramClient(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
