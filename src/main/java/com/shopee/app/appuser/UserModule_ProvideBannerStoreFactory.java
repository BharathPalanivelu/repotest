package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.h;

public final class UserModule_ProvideBannerStoreFactory implements b<h> {
    private final UserModule module;

    public UserModule_ProvideBannerStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public h get() {
        return (h) c.a(this.module.provideBannerStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideBannerStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideBannerStoreFactory(userModule);
    }

    public static h proxyProvideBannerStore(UserModule userModule) {
        return (h) c.a(userModule.provideBannerStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
