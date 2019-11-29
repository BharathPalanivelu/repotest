package com.shopee.react.sdk.bridge.modules.ui.location;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.shopee.react.sdk.a.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseLifecycleModule;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.LocationRequestParams;

public abstract class LocationModule extends ReactBaseLifecycleModule<a> {
    public static final String NAME = "GALocation";

    public String getName() {
        return NAME;
    }

    public LocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getLocation(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LocationModule.this.isMatchingReactTag(i)) {
                    ((a) LocationModule.this.getHelper()).a(LocationModule.this.getCurrentActivity(), (LocationRequestParams) a.f30143a.a(str, LocationRequestParams.class), new c(promise));
                }
            }
        });
    }
}
