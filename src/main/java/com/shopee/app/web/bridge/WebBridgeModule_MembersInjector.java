package com.shopee.app.web.bridge;

import android.app.Activity;
import b.b;
import com.shopee.app.util.bi;
import javax.inject.Provider;

public final class WebBridgeModule_MembersInjector implements b<WebBridgeModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<bi> mUIEventBusProvider;

    public WebBridgeModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
    }

    public static b<WebBridgeModule> create(Provider<Activity> provider, Provider<bi> provider2) {
        return new WebBridgeModule_MembersInjector(provider, provider2);
    }

    public void injectMembers(WebBridgeModule webBridgeModule) {
        injectMActivity(webBridgeModule, this.mActivityProvider.get());
        injectMUIEventBus(webBridgeModule, this.mUIEventBusProvider.get());
    }

    public static void injectMActivity(WebBridgeModule webBridgeModule, Activity activity) {
        webBridgeModule.mActivity = activity;
    }

    public static void injectMUIEventBus(WebBridgeModule webBridgeModule, bi biVar) {
        webBridgeModule.mUIEventBus = biVar;
    }
}
