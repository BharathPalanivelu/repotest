package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.viewmodel.FollowCounter;

public final class UserModule_ProvideFollowCounterFactory implements b<FollowCounter> {
    private final UserModule module;

    public UserModule_ProvideFollowCounterFactory(UserModule userModule) {
        this.module = userModule;
    }

    public FollowCounter get() {
        return (FollowCounter) c.a(this.module.provideFollowCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideFollowCounterFactory create(UserModule userModule) {
        return new UserModule_ProvideFollowCounterFactory(userModule);
    }

    public static FollowCounter proxyProvideFollowCounter(UserModule userModule) {
        return (FollowCounter) c.a(userModule.provideFollowCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
