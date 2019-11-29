package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.al;
import com.shopee.app.tracking.f;
import javax.inject.Provider;

public final class UserModule_ProvideTrackerFactory implements b<f> {
    private final Provider<ar> applicationProvider;
    private final Provider<al> loginStoreProvider;
    private final UserModule module;

    public UserModule_ProvideTrackerFactory(UserModule userModule, Provider<ar> provider, Provider<al> provider2) {
        this.module = userModule;
        this.applicationProvider = provider;
        this.loginStoreProvider = provider2;
    }

    public f get() {
        return (f) c.a(this.module.provideTracker(this.applicationProvider.get(), this.loginStoreProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideTrackerFactory create(UserModule userModule, Provider<ar> provider, Provider<al> provider2) {
        return new UserModule_ProvideTrackerFactory(userModule, provider, provider2);
    }

    public static f proxyProvideTracker(UserModule userModule, ar arVar, al alVar) {
        return (f) c.a(userModule.provideTracker(arVar, alVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
