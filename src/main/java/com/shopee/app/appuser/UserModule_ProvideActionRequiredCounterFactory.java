package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;

public final class UserModule_ProvideActionRequiredCounterFactory implements b<ActionRequiredCounter> {
    private final UserModule module;

    public UserModule_ProvideActionRequiredCounterFactory(UserModule userModule) {
        this.module = userModule;
    }

    public ActionRequiredCounter get() {
        return (ActionRequiredCounter) c.a(this.module.provideActionRequiredCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideActionRequiredCounterFactory create(UserModule userModule) {
        return new UserModule_ProvideActionRequiredCounterFactory(userModule);
    }

    public static ActionRequiredCounter proxyProvideActionRequiredCounter(UserModule userModule) {
        return (ActionRequiredCounter) c.a(userModule.provideActionRequiredCounter(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
