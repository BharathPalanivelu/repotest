package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.util.bi;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class PermissionCheckModule_MembersInjector implements b<PermissionCheckModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<al> mLoginStoreProvider;
    private final Provider<bi> mUIEventBusProvider;

    public PermissionCheckModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<al> provider3) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.mLoginStoreProvider = provider3;
    }

    public static b<PermissionCheckModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<al> provider3) {
        return new PermissionCheckModule_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(PermissionCheckModule permissionCheckModule) {
        WebBridgeModule_MembersInjector.injectMActivity(permissionCheckModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(permissionCheckModule, this.mUIEventBusProvider.get());
        injectMLoginStore(permissionCheckModule, this.mLoginStoreProvider.get());
    }

    public static void injectMLoginStore(PermissionCheckModule permissionCheckModule, al alVar) {
        permissionCheckModule.mLoginStore = alVar;
    }
}
