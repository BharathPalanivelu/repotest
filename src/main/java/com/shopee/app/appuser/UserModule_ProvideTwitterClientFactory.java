package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.ui.product.twitter.e;

public final class UserModule_ProvideTwitterClientFactory implements b<e> {
    private final UserModule module;

    public UserModule_ProvideTwitterClientFactory(UserModule userModule) {
        this.module = userModule;
    }

    public e get() {
        return (e) c.a(this.module.provideTwitterClient(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideTwitterClientFactory create(UserModule userModule) {
        return new UserModule_ProvideTwitterClientFactory(userModule);
    }

    public static e proxyProvideTwitterClient(UserModule userModule) {
        return (e) c.a(userModule.provideTwitterClient(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
