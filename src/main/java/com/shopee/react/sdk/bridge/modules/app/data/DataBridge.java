package com.shopee.react.sdk.bridge.modules.app.data;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataBridgeData;

@ReactModule(name = "GADataBridge")
public class DataBridge extends ReactContextBaseJavaModule {
    public static final String NAME = "GADataBridge";
    private a mImplementation;

    public String getName() {
        return NAME;
    }

    public DataBridge(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void get(String str, Promise promise) {
        this.mImplementation.a((DataBridgeData) a.f30143a.a(str, DataBridgeData.class), new c(promise));
    }

    @ReactMethod
    public void post(String str, Promise promise) {
        this.mImplementation.b((DataBridgeData) a.f30143a.a(str, DataBridgeData.class), new c(promise));
    }
}
