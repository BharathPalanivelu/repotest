package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.ui.c.a;
import com.shopee.app.util.bi;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class PermissionRequestModule_MembersInjector implements b<PermissionRequestModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<a> mHandlerProvider;
    private final Provider<bi> mUIEventBusProvider;

    public PermissionRequestModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.mHandlerProvider = provider3;
    }

    public static b<PermissionRequestModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        return new PermissionRequestModule_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(PermissionRequestModule permissionRequestModule) {
        WebBridgeModule_MembersInjector.injectMActivity(permissionRequestModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(permissionRequestModule, this.mUIEventBusProvider.get());
        injectMHandler(permissionRequestModule, this.mHandlerProvider.get());
    }

    public static void injectMHandler(PermissionRequestModule permissionRequestModule, a aVar) {
        permissionRequestModule.mHandler = aVar;
    }
}
