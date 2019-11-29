package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ba;
import com.shopee.app.util.k.h;
import javax.inject.Provider;

public final class UserModule_ProvideProductUploadMangerFactory implements b<h> {
    private final UserModule module;
    private final Provider<ba> uploadStoreProvider;

    public UserModule_ProvideProductUploadMangerFactory(UserModule userModule, Provider<ba> provider) {
        this.module = userModule;
        this.uploadStoreProvider = provider;
    }

    public h get() {
        return (h) c.a(this.module.provideProductUploadManger(this.uploadStoreProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideProductUploadMangerFactory create(UserModule userModule, Provider<ba> provider) {
        return new UserModule_ProvideProductUploadMangerFactory(userModule, provider);
    }

    public static h proxyProvideProductUploadManger(UserModule userModule, ba baVar) {
        return (h) c.a(userModule.provideProductUploadManger(baVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
