package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.x;

public final class UserModule_CustomerOrderCountStoreFactory implements b<x> {
    private final UserModule module;

    public UserModule_CustomerOrderCountStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public x get() {
        return (x) c.a(this.module.customerOrderCountStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_CustomerOrderCountStoreFactory create(UserModule userModule) {
        return new UserModule_CustomerOrderCountStoreFactory(userModule);
    }

    public static x proxyCustomerOrderCountStore(UserModule userModule) {
        return (x) c.a(userModule.customerOrderCountStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
