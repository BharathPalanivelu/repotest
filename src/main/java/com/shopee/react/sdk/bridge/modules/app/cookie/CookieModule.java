package com.shopee.react.sdk.bridge.modules.app.cookie;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.bridge.modules.base.c;

@ReactModule(name = "GACookies")
public class CookieModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GACookies";
    private final b mImplementation;

    public String getName() {
        return NAME;
    }

    public CookieModule(ReactApplicationContext reactApplicationContext, b bVar) {
        super(reactApplicationContext);
        this.mImplementation = bVar;
    }

    @ReactMethod
    public void getCookies(String str, Promise promise) {
        this.mImplementation.a(str, new c(promise));
    }

    @ReactMethod
    public void setCookie(String str, String str2, Promise promise) {
        this.mImplementation.a(str, str2, new c(promise));
    }
}
