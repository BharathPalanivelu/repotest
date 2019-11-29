package com.shopee.react.sdk.bridge.modules.base;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.shopee.react.sdk.activity.a;
import com.shopee.react.sdk.bridge.modules.base.d;

public abstract class ReactBaseModule<T extends d> extends ReactContextBaseJavaModule {
    public abstract T initHelper(a aVar);

    public ReactBaseModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public T getHelper() {
        Activity currentActivity = getCurrentActivity();
        if (!(currentActivity instanceof a)) {
            return null;
        }
        a aVar = (a) currentActivity;
        T b2 = aVar.b(getName());
        if (b2 != null) {
            return b2;
        }
        T initHelper = initHelper(aVar);
        aVar.a(getName(), initHelper);
        if (!(initHelper instanceof b)) {
            return initHelper;
        }
        ((b) initHelper).a();
        return initHelper;
    }

    public boolean isMatchingReactTag(int i) {
        Activity currentActivity = getCurrentActivity();
        return currentActivity != null && (currentActivity instanceof a) && ((a) currentActivity).getReactTag() == i;
    }

    public int getReactTag() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !(currentActivity instanceof a)) {
            return 0;
        }
        return ((a) currentActivity).getReactTag();
    }
}
