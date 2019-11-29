package com.shopee.react.sdk.bridge.modules.ui.progress;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseModule;

@ReactModule(name = "GAProgress")
public abstract class ProgressModule extends ReactBaseModule<a> {
    public static final String NAME = "GAProgress";

    public String getName() {
        return NAME;
    }

    public ProgressModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void showLoading(final int i, String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ProgressModule.this.isMatchingReactTag(i)) {
                    ((a) ProgressModule.this.getHelper()).a();
                    o oVar = new o();
                    oVar.a("status", (Number) 1);
                    promise.resolve(oVar.toString());
                }
            }
        });
    }

    @ReactMethod
    public void hideLoading(final int i, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ProgressModule.this.isMatchingReactTag(i)) {
                    ((a) ProgressModule.this.getHelper()).b();
                    o oVar = new o();
                    oVar.a("status", (Number) 1);
                    promise.resolve(oVar.toString());
                }
            }
        });
    }
}
