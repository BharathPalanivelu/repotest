package com.shopee.react.sdk.bridge.modules.app.bundle;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.BundleReloadData;

@ReactModule(name = "GABundleManager")
public class BundleManager extends ReactContextBaseJavaModule {
    public static final String NAME = "GABundleManager";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public BundleManager(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void reload(String str, Promise promise) {
        this.mImplementation.a((BundleReloadData) a.f30143a.a(str, BundleReloadData.class), new c(promise));
    }

    @ReactMethod
    public void sync(Promise promise) {
        this.mImplementation.a(new c(promise));
    }
}
