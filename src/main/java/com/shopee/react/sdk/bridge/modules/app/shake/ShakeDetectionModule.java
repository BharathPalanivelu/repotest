package com.shopee.react.sdk.bridge.modules.app.shake;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.StartShakeDetectionMessage;

@ReactModule(name = "GAShakeDetector")
public class ShakeDetectionModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GAShakeDetector";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public ShakeDetectionModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void startShakeDetection(int i, String str, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if ((currentActivity instanceof a) && ((a) currentActivity).getReactTag() == i) {
            this.mImplementation.a((StartShakeDetectionMessage) com.shopee.react.sdk.a.a.f30143a.a(str, StartShakeDetectionMessage.class), new c(promise));
        }
    }

    @ReactMethod
    public void stopShakeDetection(int i, String str, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if ((currentActivity instanceof a) && ((a) currentActivity).getReactTag() == i) {
            this.mImplementation.a(new c(promise));
        }
    }
}
