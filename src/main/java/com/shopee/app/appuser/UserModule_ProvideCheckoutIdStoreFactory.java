package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.q;

public final class UserModule_ProvideCheckoutIdStoreFactory implements b<q> {
    private final UserModule module;

    public UserModule_ProvideCheckoutIdStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public q get() {
        return (q) c.a(this.module.provideCheckoutIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideCheckoutIdStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideCheckoutIdStoreFactory(userModule);
    }

    public static q proxyProvideCheckoutIdStore(UserModule userModule) {
        return (q) c.a(userModule.provideCheckoutIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
