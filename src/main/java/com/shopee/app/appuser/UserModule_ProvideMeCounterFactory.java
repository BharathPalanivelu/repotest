package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.viewmodel.MeCounter;

public final class UserModule_ProvideMeCounterFactory implements b<MeCounter> {
    private final UserModule module;

    public UserModule_ProvideMeCounterFactory(UserModule userModule) {
        this.module = userModule;
    }

    public MeCounter get() {
        return (MeCounter) c.a(this.module.provideMeCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideMeCounterFactory create(UserModule userModule) {
        return new UserModule_ProvideMeCounterFactory(userModule);
    }

    public static MeCounter proxyProvideMeCounter(UserModule userModule) {
        return (MeCounter) c.a(userModule.provideMeCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
