package com.shopee.react.sdk.bridge.modules.app.fileloader;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.bridge.modules.base.c;

@ReactModule(name = "GAFileLoader")
public class FileLoaderModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GAFileLoader";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public FileLoaderModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void loadTextAsset(String str, Promise promise) throws Exception {
        this.mImplementation.a(str, new c(promise));
    }
}
