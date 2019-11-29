package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.o;

public final class UserModule_ProvideChatListLoadingStoreFactory implements b<o> {
    private final UserModule module;

    public UserModule_ProvideChatListLoadingStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public o get() {
        return (o) c.a(this.module.provideChatListLoadingStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideChatListLoadingStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideChatListLoadingStoreFactory(userModule);
    }

    public static o proxyProvideChatListLoadingStore(UserModule userModule) {
        return (o) c.a(userModule.provideChatListLoadingStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
