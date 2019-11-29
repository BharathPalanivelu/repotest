package com.shopee.app.react.modules.app.tracker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.q;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;
import com.shopee.app.react.protocol.ScreenNameData;
import com.shopee.app.tracking.e;
import com.shopee.app.web.WebRegister;

@ReactModule(name = "GAFirebaseTracker")
public class FirebaseTrackerModule extends ReactBaseLifecycleModule<a> {
    protected static final String NAME = "GAFirebaseTracker";
    private e mFirebaseTracker;

    public String getName() {
        return NAME;
    }

    public FirebaseTrackerModule(ReactApplicationContext reactApplicationContext, e eVar) {
        super(reactApplicationContext);
        this.mFirebaseTracker = eVar;
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public void trackAction(String str, String str2) {
        this.mFirebaseTracker.a(str, new q().a(str2).m());
    }

    @ReactMethod
    public void setScreenName(int i, String str) {
        if (isMatchingReactTag(i)) {
            try {
                ((a) getHelper()).a((ScreenNameData) WebRegister.GSON.a(str, ScreenNameData.class));
            } catch (Exception unused) {
            }
        }
    }
}
