package com.shopee.app.appuser;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.bf;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.react.modules.app.data.l;
import com.shopee.app.util.s;
import javax.inject.Provider;

public final class UserModule_ProvideDataBridgeHelperFactory implements b<g> {
    private final Provider<ChatBadgeStore> chatBadgeStoreProvider;
    private final Provider<s> featureToggleManagerProvider;
    private final UserModule module;
    private final Provider<at> orderNotiStoreProvider;
    private final Provider<SettingConfigStore> settingConfigStoreProvider;
    private final Provider<l> themeConfigUpdaterProvider;
    private final Provider<bf> unreadStoreProvider;

    public UserModule_ProvideDataBridgeHelperFactory(UserModule userModule, Provider<at> provider, Provider<ChatBadgeStore> provider2, Provider<bf> provider3, Provider<SettingConfigStore> provider4, Provider<s> provider5, Provider<l> provider6) {
        this.module = userModule;
        this.orderNotiStoreProvider = provider;
        this.chatBadgeStoreProvider = provider2;
        this.unreadStoreProvider = provider3;
        this.settingConfigStoreProvider = provider4;
        this.featureToggleManagerProvider = provider5;
        this.themeConfigUpdaterProvider = provider6;
    }

    public g get() {
        return (g) c.a(this.module.provideDataBridgeHelper(this.orderNotiStoreProvider.get(), this.chatBadgeStoreProvider.get(), this.unreadStoreProvider.get(), this.settingConfigStoreProvider.get(), this.featureToggleManagerProvider.get(), this.themeConfigUpdaterProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideDataBridgeHelperFactory create(UserModule userModule, Provider<at> provider, Provider<ChatBadgeStore> provider2, Provider<bf> provider3, Provider<SettingConfigStore> provider4, Provider<s> provider5, Provider<l> provider6) {
        return new UserModule_ProvideDataBridgeHelperFactory(userModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static g proxyProvideDataBridgeHelper(UserModule userModule, at atVar, ChatBadgeStore chatBadgeStore, bf bfVar, SettingConfigStore settingConfigStore, s sVar, l lVar) {
        return (g) c.a(userModule.provideDataBridgeHelper(atVar, chatBadgeStore, bfVar, settingConfigStore, sVar, lVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
