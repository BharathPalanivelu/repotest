package com.shopee.react.sdk.bridge.modules.base;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.shopee.react.sdk.bridge.modules.base.d;

public abstract class ReactBaseLifecycleModule<T extends d> extends ReactBaseModule<T> implements LifecycleEventListener {
    public void onHostDestroy() {
    }

    public ReactBaseLifecycleModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void onHostResume() {
        d helper = getHelper();
        if (helper instanceof b) {
            ((b) helper).b();
        }
    }

    public void onHostPause() {
        d helper = getHelper();
        if (helper instanceof b) {
            ((b) helper).c();
        }
    }
}
