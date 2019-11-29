package com.shopee.react.sdk.bridge.modules.app.permissions;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.ReactPermissionResponse;
import com.shopee.web.sdk.bridge.protocol.permissions.CheckPermissionRequest;
import com.shopee.web.sdk.bridge.protocol.permissions.RequestPermissionRequest;

@ReactModule(name = "GAAppPermission")
public class AppPermissionModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GAAppPermission";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public AppPermissionModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void checkAppPermission(int i, String str, Promise promise) {
        this.mImplementation.a(getCurrentActivity(), i, (CheckPermissionRequest) a.f30143a.a(str, CheckPermissionRequest.class), (c<DataResponse<ReactPermissionResponse>>) new c(promise));
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void requestAppPermission(int i, String str, Promise promise) {
        this.mImplementation.a(getCurrentActivity(), i, (RequestPermissionRequest) a.f30143a.a(str, RequestPermissionRequest.class), (c<DataResponse<ReactPermissionResponse>>) new c(promise));
    }
}
