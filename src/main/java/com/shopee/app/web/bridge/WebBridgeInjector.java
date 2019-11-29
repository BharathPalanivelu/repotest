package com.shopee.app.web.bridge;

import com.shopee.app.web.bridge.modules.FacebookConnectAccountModule;
import com.shopee.app.web.bridge.modules.FacebookConnectStatusModule;
import com.shopee.app.web.bridge.modules.FileDownloaderModule;
import com.shopee.app.web.bridge.modules.NavigateAppRLModule;
import com.shopee.app.web.bridge.modules.PermissionCheckModule;
import com.shopee.app.web.bridge.modules.PermissionRequestModule;
import com.shopee.app.web.bridge.modules.RequestAuthCodeFromCoreAuthModule;
import com.shopee.app.web.bridge.modules.StartShakeDetectionModule;
import com.shopee.app.web.bridge.modules.StopShakeDetectionModule;

public interface WebBridgeInjector {
    void inject(WebBridgeModule webBridgeModule);

    void inject(FacebookConnectAccountModule facebookConnectAccountModule);

    void inject(FacebookConnectStatusModule facebookConnectStatusModule);

    void inject(FileDownloaderModule fileDownloaderModule);

    void inject(NavigateAppRLModule navigateAppRLModule);

    void inject(PermissionCheckModule permissionCheckModule);

    void inject(PermissionRequestModule permissionRequestModule);

    void inject(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule);

    void inject(StartShakeDetectionModule startShakeDetectionModule);

    void inject(StopShakeDetectionModule stopShakeDetectionModule);
}
