package com.shopee.react.sdk.bridge.modules.app.userinfo;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.bridge.modules.base.c;

@ReactModule(name = "GAUserInfo")
public class UserInfoModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GAUserInfo";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public UserInfoModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void getUserSession(Promise promise) {
        this.mImplementation.a(new c(promise));
    }

    @ReactMethod
    public void isLoggedIn(Promise promise) {
        this.mImplementation.b(new c(promise));
    }

    @ReactMethod
    public void hasPassword(Promise promise) {
        this.mImplementation.c(new c(promise));
    }
}
