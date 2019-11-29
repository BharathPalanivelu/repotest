package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.viewmodel.ActivityCounter;

public final class UserModule_ProvideActivityCounterFactory implements b<ActivityCounter> {
    private final UserModule module;

    public UserModule_ProvideActivityCounterFactory(UserModule userModule) {
        this.module = userModule;
    }

    public ActivityCounter get() {
        return (ActivityCounter) c.a(this.module.provideActivityCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideActivityCounterFactory create(UserModule userModule) {
        return new UserModule_ProvideActivityCounterFactory(userModule);
    }

    public static ActivityCounter proxyProvideActivityCounter(UserModule userModule) {
        return (ActivityCounter) c.a(userModule.provideActivityCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
