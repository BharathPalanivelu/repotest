package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ChatBadgeStore;

public final class UserModule_ProvideChatBadgeStoreFactory implements b<ChatBadgeStore> {
    private final UserModule module;

    public UserModule_ProvideChatBadgeStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public ChatBadgeStore get() {
        return (ChatBadgeStore) c.a(this.module.provideChatBadgeStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideChatBadgeStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideChatBadgeStoreFactory(userModule);
    }

    public static ChatBadgeStore proxyProvideChatBadgeStore(UserModule userModule) {
        return (ChatBadgeStore) c.a(userModule.provideChatBadgeStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
