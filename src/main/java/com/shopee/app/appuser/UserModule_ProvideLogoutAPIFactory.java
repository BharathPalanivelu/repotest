package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.network.http.a.h;
import f.n;
import javax.inject.Provider;

public final class UserModule_ProvideLogoutAPIFactory implements b<h> {
    private final UserModule module;
    private final Provider<n> retrofitProvider;

    public UserModule_ProvideLogoutAPIFactory(UserModule userModule, Provider<n> provider) {
        this.module = userModule;
        this.retrofitProvider = provider;
    }

    public h get() {
        return (h) c.a(this.module.provideLogoutAPI(this.retrofitProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideLogoutAPIFactory create(UserModule userModule, Provider<n> provider) {
        return new UserModule_ProvideLogoutAPIFactory(userModule, provider);
    }

    public static h proxyProvideLogoutAPI(UserModule userModule, n nVar) {
        return (h) c.a(userModule.provideLogoutAPI(nVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
