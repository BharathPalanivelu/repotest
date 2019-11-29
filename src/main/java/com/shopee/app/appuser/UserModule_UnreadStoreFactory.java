package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.bf;

public final class UserModule_UnreadStoreFactory implements b<bf> {
    private final UserModule module;

    public UserModule_UnreadStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public bf get() {
        return (bf) c.a(this.module.unreadStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_UnreadStoreFactory create(UserModule userModule) {
        return new UserModule_UnreadStoreFactory(userModule);
    }

    public static bf proxyUnreadStore(UserModule userModule) {
        return (bf) c.a(userModule.unreadStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
