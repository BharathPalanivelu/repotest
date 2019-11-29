package com.shopee.app.react.modules.app.phone;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "GAMobileNumber")
public class PhoneModule extends com.shopee.react.sdk.bridge.modules.app.phone.PhoneModule {
    public PhoneModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, new a(reactApplicationContext));
    }

    @ReactMethod
    public void formatPhoneNumber(String str, Promise promise) {
        super.formatPhoneNumber(str, promise);
    }
}
