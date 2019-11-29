package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.util.bi;
import com.shopee.app.util.m.a;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class StartShakeDetectionModule_MembersInjector implements b<StartShakeDetectionModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<bi> mUIEventBusProvider;
    private final Provider<a> shakeHandlerProvider;

    public StartShakeDetectionModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.shakeHandlerProvider = provider3;
    }

    public static b<StartShakeDetectionModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        return new StartShakeDetectionModule_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(StartShakeDetectionModule startShakeDetectionModule) {
        WebBridgeModule_MembersInjector.injectMActivity(startShakeDetectionModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(startShakeDetectionModule, this.mUIEventBusProvider.get());
        injectShakeHandler(startShakeDetectionModule, this.shakeHandlerProvider.get());
    }

    public static void injectShakeHandler(StartShakeDetectionModule startShakeDetectionModule, a aVar) {
        startShakeDetectionModule.shakeHandler = aVar;
    }
}
