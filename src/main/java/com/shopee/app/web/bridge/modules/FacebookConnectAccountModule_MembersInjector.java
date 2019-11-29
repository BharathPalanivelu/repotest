package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class FacebookConnectAccountModule_MembersInjector implements b<FacebookConnectAccountModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<n> mDataEventBusProvider;
    private final Provider<com.shopee.app.application.a.b> mLifeCycleManagerProvider;
    private final Provider<bi> mUIEventBusProvider;

    public FacebookConnectAccountModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<com.shopee.app.application.a.b> provider3, Provider<n> provider4) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.mLifeCycleManagerProvider = provider3;
        this.mDataEventBusProvider = provider4;
    }

    public static b<FacebookConnectAccountModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<com.shopee.app.application.a.b> provider3, Provider<n> provider4) {
        return new FacebookConnectAccountModule_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(FacebookConnectAccountModule facebookConnectAccountModule) {
        WebBridgeModule_MembersInjector.injectMActivity(facebookConnectAccountModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(facebookConnectAccountModule, this.mUIEventBusProvider.get());
        injectMLifeCycleManager(facebookConnectAccountModule, this.mLifeCycleManagerProvider.get());
        injectMDataEventBus(facebookConnectAccountModule, this.mDataEventBusProvider.get());
    }

    public static void injectMLifeCycleManager(FacebookConnectAccountModule facebookConnectAccountModule, com.shopee.app.application.a.b bVar) {
        facebookConnectAccountModule.mLifeCycleManager = bVar;
    }

    public static void injectMDataEventBus(FacebookConnectAccountModule facebookConnectAccountModule, n nVar) {
        facebookConnectAccountModule.mDataEventBus = nVar;
    }
}
