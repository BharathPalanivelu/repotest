package com.shopee.app.react.modules.app.tracker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.tracking.d;

@ReactModule(name = "GAFacebookTracker")
public class FacebookTrackerModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GAFacebookTracker";
    private d mFacebookTracker;

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void trackAction(String str, String str2) {
    }

    public FacebookTrackerModule(ReactApplicationContext reactApplicationContext, d dVar) {
        super(reactApplicationContext);
        this.mFacebookTracker = dVar;
    }

    @ReactMethod
    public void logProductItem(String str) {
        this.mFacebookTracker.a(str);
    }
}
