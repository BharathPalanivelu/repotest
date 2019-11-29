package com.shopee.app.react.modules.app.tracker;

import android.text.TextUtils;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.garena.android.appkit.d.a;
import com.shopee.app.application.ar;
import com.shopee.app.tracking.b;
import com.shopee.app.tracking.f;
import com.shopee.app.web.WebRegister;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "GATracker")
public class TrackerModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GATracker";
    private f mTracker = new f(ar.f().e().loginStore(), Collections.singletonList(new b()));

    public String getName() {
        return NAME;
    }

    public TrackerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void trackEvent(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            try {
                this.mTracker.a(str, (Map<String, Object>) (Map) WebRegister.GSON.a(str3, HashMap.class));
            } catch (Exception e2) {
                a.a(e2);
            }
        } else if (!TextUtils.isEmpty(str2)) {
            this.mTracker.a(str, str2);
        }
    }
}
