package com.shopee.app.react.modules.unused.imagemanager;

import android.app.Activity;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.c.a;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;

@ReactModule(name = "ImageManager")
public class ImageManagerModule extends ReactBaseLifecycleModule<a> implements LifecycleEventListener {
    protected static final String NAME = "ImageManager";

    public String getName() {
        return NAME;
    }

    public ImageManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public void saveImage(String str, String str2, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            ((a) getHelper()).a(currentActivity, str, str2, promise);
        } else {
            promise.reject((Throwable) new a());
        }
    }

    @ReactMethod
    public void startBrowsing(ReadableArray readableArray, int i, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            ((a) getHelper()).a(currentActivity, readableArray, i, promise);
        } else {
            promise.reject((Throwable) new a());
        }
    }
}
