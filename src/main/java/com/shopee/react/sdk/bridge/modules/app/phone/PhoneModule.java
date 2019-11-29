package com.shopee.react.sdk.bridge.modules.app.phone;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.bridge.modules.base.c;

@ReactModule(name = "GAMobileNumber")
public class PhoneModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GAMobileNumber";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public PhoneModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void formatPhoneNumber(String str, Promise promise) {
        this.mImplementation.a(str, new c(promise));
    }
}
