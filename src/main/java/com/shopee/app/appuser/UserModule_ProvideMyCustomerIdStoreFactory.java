package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ap;

public final class UserModule_ProvideMyCustomerIdStoreFactory implements b<ap> {
    private final UserModule module;

    public UserModule_ProvideMyCustomerIdStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public ap get() {
        return (ap) c.a(this.module.provideMyCustomerIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideMyCustomerIdStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideMyCustomerIdStoreFactory(userModule);
    }

    public static ap proxyProvideMyCustomerIdStore(UserModule userModule) {
        return (ap) c.a(userModule.provideMyCustomerIdStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
