package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.util.bi;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class NavigateAppRLModule_MembersInjector implements b<NavigateAppRLModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<com.shopee.app.util.b> mAppPathHelperProvider;
    private final Provider<bi> mUIEventBusProvider;

    public NavigateAppRLModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<com.shopee.app.util.b> provider3) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.mAppPathHelperProvider = provider3;
    }

    public static b<NavigateAppRLModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<com.shopee.app.util.b> provider3) {
        return new NavigateAppRLModule_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(NavigateAppRLModule navigateAppRLModule) {
        WebBridgeModule_MembersInjector.injectMActivity(navigateAppRLModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(navigateAppRLModule, this.mUIEventBusProvider.get());
        injectMAppPathHelper(navigateAppRLModule, this.mAppPathHelperProvider.get());
    }

    public static void injectMAppPathHelper(NavigateAppRLModule navigateAppRLModule, com.shopee.app.util.b bVar) {
        navigateAppRLModule.mAppPathHelper = bVar;
    }
}
