package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.az;

public final class UserModule_ProvideProductIdListStoreFactory implements b<az> {
    private final UserModule module;

    public UserModule_ProvideProductIdListStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public az get() {
        return (az) c.a(this.module.provideProductIdListStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideProductIdListStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideProductIdListStoreFactory(userModule);
    }

    public static az proxyProvideProductIdListStore(UserModule userModule) {
        return (az) c.a(userModule.provideProductIdListStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
