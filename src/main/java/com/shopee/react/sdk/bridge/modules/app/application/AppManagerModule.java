package com.shopee.react.sdk.bridge.modules.app.application;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.bridge.modules.base.c;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "GAApplication")
public class AppManagerModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GAApplication";
    private final a mData;
    private final b mImplementation;

    public String getName() {
        return NAME;
    }

    public AppManagerModule(ReactApplicationContext reactApplicationContext, a aVar, b bVar) {
        super(reactApplicationContext);
        this.mData = aVar;
        this.mImplementation = bVar;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("appVersion", this.mData.a());
        hashMap.put("appDeviceID", this.mData.b());
        hashMap.put("appDeviceFingerprint", this.mData.c());
        hashMap.put("appEnvironment", this.mData.d());
        hashMap.put("appCountry", this.mData.e());
        hashMap.put("appLanguage", this.mData.f());
        hashMap.put("appOSVersion", this.mData.g());
        hashMap.put("appDeviceName", this.mData.h());
        hashMap.put("customWebServer", this.mData.i());
        hashMap.put("brand", this.mData.j());
        hashMap.put("model", this.mData.k());
        hashMap.put("isInternalBuild", Boolean.valueOf(this.mData.m()));
        hashMap.put("appsFlyerDeviceID", this.mData.l());
        hashMap.put("deviceRamSize", Long.valueOf(this.mData.n()));
        return hashMap;
    }

    @ReactMethod
    public void restartApp() {
        this.mImplementation.a();
    }

    @ReactMethod
    public void getJai1br3akOrR00ted(Promise promise) {
        this.mImplementation.a(new c(promise));
    }
}
