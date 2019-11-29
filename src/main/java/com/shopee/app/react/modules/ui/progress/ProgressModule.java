package com.shopee.app.react.modules.ui.progress;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;

@ReactModule(name = "GAProgress")
public class ProgressModule extends com.shopee.react.sdk.bridge.modules.ui.progress.ProgressModule {
    public String getName() {
        return com.shopee.react.sdk.bridge.modules.ui.progress.ProgressModule.NAME;
    }

    public ProgressModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(a aVar) {
        return new a(aVar);
    }

    @ReactMethod
    public void showLoading(int i, String str, Promise promise) {
        super.showLoading(i, str, promise);
    }

    @ReactMethod
    public void hideLoading(int i, Promise promise) {
        super.hideLoading(i, promise);
    }
}
