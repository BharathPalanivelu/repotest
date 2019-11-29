package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.util.s;
import f.n;
import javax.inject.Provider;

public final class UserModule_ProvideFeatureToggleManagerFactory implements b<s> {
    private final UserModule module;
    private final Provider<n> retrofitProvider;
    private final Provider<UserInfo> userInfoProvider;

    public UserModule_ProvideFeatureToggleManagerFactory(UserModule userModule, Provider<n> provider, Provider<UserInfo> provider2) {
        this.module = userModule;
        this.retrofitProvider = provider;
        this.userInfoProvider = provider2;
    }

    public s get() {
        return (s) c.a(this.module.provideFeatureToggleManager(this.retrofitProvider.get(), this.userInfoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideFeatureToggleManagerFactory create(UserModule userModule, Provider<n> provider, Provider<UserInfo> provider2) {
        return new UserModule_ProvideFeatureToggleManagerFactory(userModule, provider, provider2);
    }

    public static s proxyProvideFeatureToggleManager(UserModule userModule, n nVar, UserInfo userInfo) {
        return (s) c.a(userModule.provideFeatureToggleManager(nVar, userInfo), "Cannot return null from a non-@Nullable @Provides method");
    }
}
