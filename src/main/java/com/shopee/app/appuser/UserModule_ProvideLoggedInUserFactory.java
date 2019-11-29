package com.shopee.app.appuser;

import b.a.b;
import b.a.c;

public final class UserModule_ProvideLoggedInUserFactory implements b<UserInfo> {
    private final UserModule module;

    public UserModule_ProvideLoggedInUserFactory(UserModule userModule) {
        this.module = userModule;
    }

    public UserInfo get() {
        return (UserInfo) c.a(this.module.provideLoggedInUser(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideLoggedInUserFactory create(UserModule userModule) {
        return new UserModule_ProvideLoggedInUserFactory(userModule);
    }

    public static UserInfo proxyProvideLoggedInUser(UserModule userModule) {
        return (UserInfo) c.a(userModule.provideLoggedInUser(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
