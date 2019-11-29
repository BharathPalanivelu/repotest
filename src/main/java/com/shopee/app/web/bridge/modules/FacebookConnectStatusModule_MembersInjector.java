package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.h.m;
import com.shopee.app.network.http.a.d;
import com.shopee.app.util.bi;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class FacebookConnectStatusModule_MembersInjector implements b<FacebookConnectStatusModule> {
    private final Provider<m> loginManagerProvider;
    private final Provider<Activity> mActivityProvider;
    private final Provider<d> mFacebookGraphAPIProvider;
    private final Provider<bi> mUIEventBusProvider;

    public FacebookConnectStatusModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<m> provider3, Provider<d> provider4) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.loginManagerProvider = provider3;
        this.mFacebookGraphAPIProvider = provider4;
    }

    public static b<FacebookConnectStatusModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<m> provider3, Provider<d> provider4) {
        return new FacebookConnectStatusModule_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(FacebookConnectStatusModule facebookConnectStatusModule) {
        WebBridgeModule_MembersInjector.injectMActivity(facebookConnectStatusModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(facebookConnectStatusModule, this.mUIEventBusProvider.get());
        injectLoginManager(facebookConnectStatusModule, this.loginManagerProvider.get());
        injectMFacebookGraphAPI(facebookConnectStatusModule, this.mFacebookGraphAPIProvider.get());
    }

    public static void injectLoginManager(FacebookConnectStatusModule facebookConnectStatusModule, m mVar) {
        facebookConnectStatusModule.loginManager = mVar;
    }

    public static void injectMFacebookGraphAPI(FacebookConnectStatusModule facebookConnectStatusModule, d dVar) {
        facebookConnectStatusModule.mFacebookGraphAPI = dVar;
    }
}
