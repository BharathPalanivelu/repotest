package com.shopee.app.react.modules.ui.location;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;

@ReactModule(name = "GALocation")
public class LocationModule extends ReactBaseLifecycleModule<b> {
    protected static final String NAME = "GALocation";

    public String getName() {
        return "GALocation";
    }

    public LocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public b initHelper(c cVar) {
        return new b(cVar);
    }

    @ReactMethod
    public void getLocation(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LocationModule.this.isMatchingReactTag(i)) {
                    ((b) LocationModule.this.getHelper()).a(LocationModule.this.getCurrentActivity(), str, promise);
                }
            }
        });
    }
}
