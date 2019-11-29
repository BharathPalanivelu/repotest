package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.SearchKeywordsStore;

public final class UserModule_ProvideSearchKeywordsStoreFactory implements b<SearchKeywordsStore> {
    private final UserModule module;

    public UserModule_ProvideSearchKeywordsStoreFactory(UserModule userModule) {
        this.module = userModule;
    }

    public SearchKeywordsStore get() {
        return (SearchKeywordsStore) c.a(this.module.provideSearchKeywordsStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideSearchKeywordsStoreFactory create(UserModule userModule) {
        return new UserModule_ProvideSearchKeywordsStoreFactory(userModule);
    }

    public static SearchKeywordsStore proxyProvideSearchKeywordsStore(UserModule userModule) {
        return (SearchKeywordsStore) c.a(userModule.provideSearchKeywordsStore(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
