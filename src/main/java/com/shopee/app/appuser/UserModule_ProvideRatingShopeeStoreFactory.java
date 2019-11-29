package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.bb;

public final class UserModule_ProvideRatingShopeeStoreFactory implements b<bb> {
    private final UserModule module;

    public UserModule_ProvideRatingShopeeStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public bb get() {
        return (bb) c.a(this.module.provideRatingShopeeStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideRatingShopeeStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideRatingShopeeStoreFactory(userModule);
    }

    public static bb proxyProvideRatingShopeeStore(UserModule userModule) {
        return (bb) c.a(userModule.provideRatingShopeeStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
