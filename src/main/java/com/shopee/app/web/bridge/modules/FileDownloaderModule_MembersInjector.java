package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import b.b;
import com.shopee.app.ui.c.a;
import com.shopee.app.util.bi;
import com.shopee.app.web.bridge.WebBridgeModule_MembersInjector;
import javax.inject.Provider;

public final class FileDownloaderModule_MembersInjector implements b<FileDownloaderModule> {
    private final Provider<Activity> mActivityProvider;
    private final Provider<bi> mUIEventBusProvider;
    private final Provider<a> permissionHandlerProvider;

    public FileDownloaderModule_MembersInjector(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        this.mActivityProvider = provider;
        this.mUIEventBusProvider = provider2;
        this.permissionHandlerProvider = provider3;
    }

    public static b<FileDownloaderModule> create(Provider<Activity> provider, Provider<bi> provider2, Provider<a> provider3) {
        return new FileDownloaderModule_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(FileDownloaderModule fileDownloaderModule) {
        WebBridgeModule_MembersInjector.injectMActivity(fileDownloaderModule, this.mActivityProvider.get());
        WebBridgeModule_MembersInjector.injectMUIEventBus(fileDownloaderModule, this.mUIEventBusProvider.get());
        injectPermissionHandler(fileDownloaderModule, this.permissionHandlerProvider.get());
    }

    public static void injectPermissionHandler(FileDownloaderModule fileDownloaderModule, a aVar) {
        fileDownloaderModule.permissionHandler = aVar;
    }
}
