package com.shopee.app.react.modules.app.logging;

import com.crashlytics.android.a;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "GALog")
public class LoggingModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GALog";

    public String getName() {
        return "GALog";
    }

    public LoggingModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void logEvent(String str) {
        RuntimeException runtimeException = new RuntimeException(str);
        a.a("crash_from:ReactNative | msg: " + str);
        a.a((Throwable) runtimeException);
    }
}
