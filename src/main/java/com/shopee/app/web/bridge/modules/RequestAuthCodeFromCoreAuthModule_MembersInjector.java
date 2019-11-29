package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.a.a;
import b.b;
import com.shopee.app.network.http.a.k;
import com.shopee.app.util.bi;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class RequestAuthCodeFromCoreAuthModule_MembersInjector implements b<RequestAuthCodeFromCoreAuthModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<bi> mUIEventBusProvider;
    private final Provider<k> userAPIProvider;

    public RequestAuthCodeFromCoreAuthModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<k> provider3) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.userAPIProvider = provider3;
    }

    public static b<RequestAuthCodeFromCoreAuthModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<k> provider3) {
        return new RequestAuthCodeFromCoreAuthModule_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule) {
        WebBridgeModule_MembersInjector.injectMActivity(requestAuthCodeFromCoreAuthModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(requestAuthCodeFromCoreAuthModule, this.mUIEventBusProvider.get());
        injectUserAPI(requestAuthCodeFromCoreAuthModule, a.b(this.userAPIProvider));
    }

    public static void injectUserAPI(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule, b.a<k> aVar) {
        requestAuthCodeFromCoreAuthModule.userAPI = aVar;
    }
}
