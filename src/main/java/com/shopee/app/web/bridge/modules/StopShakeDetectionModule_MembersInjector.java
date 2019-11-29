package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.util.bi;
import com.shopee.app.util.m.a;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class StopShakeDetectionModule_MembersInjector implements b<StopShakeDetectionModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<bi> mUIEventBusProvider;
    private final Provider<a> shakeHandlerProvider;

    public StopShakeDetectionModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.shakeHandlerProvider = provider3;
    }

    public static b<StopShakeDetectionModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        return new StopShakeDetectionModule_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(StopShakeDetectionModule stopShakeDetectionModule) {
        WebBridgeModule_MembersInjector.injectMActivity(stopShakeDetectionModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(stopShakeDetectionModule, this.mUIEventBusProvider.get());
        injectShakeHandler(stopShakeDetectionModule, this.shakeHandlerProvider.get());
    }

    public static void injectShakeHandler(StopShakeDetectionModule stopShakeDetectionModule, a aVar) {
        stopShakeDetectionModule.shakeHandler = aVar;
    }
}
