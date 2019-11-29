package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.viewmodel.ChatCounter;

public final class UserModule_ProvideChatCounterFactory implements b<ChatCounter> {
    private final UserModule module;

    public UserModule_ProvideChatCounterFactory(UserModule userModule) {
        this.module = userModule;
    }

    public ChatCounter get() {
        return (ChatCounter) c.a(this.module.provideChatCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideChatCounterFactory create(UserModule userModule) {
        return new UserModule_ProvideChatCounterFactory(userModule);
    }

    public static ChatCounter proxyProvideChatCounter(UserModule userModule) {
        return (ChatCounter) c.a(userModule.provideChatCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
