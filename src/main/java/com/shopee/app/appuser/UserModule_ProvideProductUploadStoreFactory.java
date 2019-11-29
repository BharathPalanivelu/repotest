package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ba;

public final class UserModule_ProvideProductUploadStoreFactory implements b<ba> {
    private final UserModule module;

    public UserModule_ProvideProductUploadStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public ba get() {
        return (ba) c.a(this.module.provideProductUploadStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideProductUploadStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideProductUploadStoreFactory(userModule);
    }

    public static ba proxyProvideProductUploadStore(UserModule userModule) {
        return (ba) c.a(userModule.provideProductUploadStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
