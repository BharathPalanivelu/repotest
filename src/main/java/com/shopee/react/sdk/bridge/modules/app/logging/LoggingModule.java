package com.shopee.react.sdk.bridge.modules.app.logging;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "GALog")
public class LoggingModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GALog";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public LoggingModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void logEvent(String str) {
        this.mImplementation.a(str);
    }
}
