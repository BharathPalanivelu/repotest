package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.upload.UploadStore;

public final class UserModule_ProvideUploadStoreFactory implements b<UploadStore> {
    private final UserModule module;

    public UserModule_ProvideUploadStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public UploadStore get() {
        return (UploadStore) c.a(this.module.provideUploadStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideUploadStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideUploadStoreFactory(userModule);
    }

    public static UploadStore proxyProvideUploadStore(UserModule userModule) {
        return (UploadStore) c.a(userModule.provideUploadStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
