package com.shopee.app.react.modules.base;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.util.a;

public abstract class ReactBaseLifecycleModule<T extends b> extends ShopeeReactBaseModule<T> implements LifecycleEventListener {
    public void onHostDestroy() {
    }

    public ReactBaseLifecycleModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void onHostResume() {
        b helper = getHelper();
        if (helper instanceof a) {
            ((a) helper).b();
        }
    }

    public void onHostPause() {
        b helper = getHelper();
        if (helper instanceof a) {
            ((a) helper).c();
        }
    }
}
