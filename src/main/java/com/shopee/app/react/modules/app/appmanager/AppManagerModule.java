package com.shopee.app.react.modules.app.appmanager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "GAApplication")
public class AppManagerModule extends com.shopee.react.sdk.bridge.modules.app.application.AppManagerModule {
    public AppManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, a.a(), new b(reactApplicationContext));
    }

    @ReactMethod
    public void restartApp() {
        super.restartApp();
    }

    @ReactMethod
    public void getJai1br3akOrR00ted(Promise promise) {
        super.getJai1br3akOrR00ted(promise);
    }
}
