package com.shopee.react.sdk.bridge.modules.app.toast;

import android.app.Activity;
import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.protocol.ToastData;

@ReactModule(name = "GAToast")
public class ToastModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GAToast";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public ToastModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void showToast(String str, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            ToastData toastData = (ToastData) a.f30143a.a(str, ToastData.class);
            if (!TextUtils.isEmpty(toastData.getMessage())) {
                this.mImplementation.a(currentActivity, toastData);
            }
        }
        promise.resolve(1);
    }
}
