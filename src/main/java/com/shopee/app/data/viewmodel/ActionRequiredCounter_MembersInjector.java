package com.shopee.app.data.viewmodel;

import b.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.bf;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ActionRequiredCounter_MembersInjector implements b<ActionRequiredCounter> {
    private final Provider<n> mEventBusProvider;
    private final Provider<SettingConfigStore> mSettingsProvider;
    private final Provider<bf> mStoreProvider;

    public ActionRequiredCounter_MembersInjector(Provider<bf> provider, Provider<n> provider2, Provider<SettingConfigStore> provider3) {
        this.mStoreProvider = provider;
        this.mEventBusProvider = provider2;
        this.mSettingsProvider = provider3;
    }

    public static b<ActionRequiredCounter> create(Provider<bf> provider, Provider<n> provider2, Provider<SettingConfigStore> provider3) {
        return new ActionRequiredCounter_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(ActionRequiredCounter actionRequiredCounter) {
        injectMStore(actionRequiredCounter, this.mStoreProvider.get());
        injectMEventBus(actionRequiredCounter, this.mEventBusProvider.get());
        injectMSettings(actionRequiredCounter, this.mSettingsProvider.get());
    }

    public static void injectMStore(ActionRequiredCounter actionRequiredCounter, bf bfVar) {
        actionRequiredCounter.mStore = bfVar;
    }

    public static void injectMEventBus(ActionRequiredCounter actionRequiredCounter, n nVar) {
        actionRequiredCounter.mEventBus = nVar;
    }

    public static void injectMSettings(ActionRequiredCounter actionRequiredCounter, SettingConfigStore settingConfigStore) {
        actionRequiredCounter.mSettings = settingConfigStore;
    }
}
