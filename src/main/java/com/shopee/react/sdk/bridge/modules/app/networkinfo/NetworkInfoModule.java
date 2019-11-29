package com.shopee.react.sdk.bridge.modules.app.networkinfo;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.bridge.modules.base.c;

@ReactModule(name = "GANetworkInfo")
public class NetworkInfoModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GANetworkInfo";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public NetworkInfoModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void getNetworkInfo(Promise promise) {
        this.mImplementation.a(new c(promise));
    }
}
