package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.w;

public final class UserModule_ProvideCustomerOrderIdStoreFactory implements b<w> {
    private final UserModule module;

    public UserModule_ProvideCustomerOrderIdStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public w get() {
        return (w) c.a(this.module.provideCustomerOrderIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideCustomerOrderIdStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideCustomerOrderIdStoreFactory(userModule);
    }

    public static w proxyProvideCustomerOrderIdStore(UserModule userModule) {
        return (w) c.a(userModule.provideCustomerOrderIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
