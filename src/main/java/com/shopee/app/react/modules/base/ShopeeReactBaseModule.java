package com.shopee.app.react.modules.base;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.util.a;

public abstract class ShopeeReactBaseModule<T extends b> extends ReactContextBaseJavaModule {
    public abstract T initHelper(c cVar);

    public ShopeeReactBaseModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public T getHelper() {
        Activity currentActivity = getCurrentActivity();
        if (!(currentActivity instanceof c)) {
            return null;
        }
        c cVar = (c) currentActivity;
        T a2 = cVar.a(getName());
        if (a2 != null) {
            return a2;
        }
        T initHelper = initHelper(cVar);
        cVar.a(getName(), initHelper);
        if (!(initHelper instanceof a)) {
            return initHelper;
        }
        ((a) initHelper).a();
        return initHelper;
    }

    public boolean isMatchingReactTag(int i) {
        Activity currentActivity = getCurrentActivity();
        return currentActivity != null && (currentActivity instanceof c) && ((c) currentActivity).getReactTag() == i;
    }

    public int getReactTag() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !(currentActivity instanceof c)) {
            return 0;
        }
        return ((c) currentActivity).getReactTag();
    }
}
