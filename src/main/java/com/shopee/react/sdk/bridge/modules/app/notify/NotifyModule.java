package com.shopee.react.sdk.bridge.modules.app.notify;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.l;
import com.google.a.o;
import com.shopee.react.sdk.a.a;

@ReactModule(name = "GANotify")
public class NotifyModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GANotify";
    private final a mImplementation;

    public String getName() {
        return NAME;
    }

    public NotifyModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mImplementation = aVar;
    }

    @ReactMethod
    public void notifyAppEvent(String str) {
        o m = ((l) a.f30143a.a(str, l.class)).m();
        this.mImplementation.a(m.c("notifyType").c(), m);
    }
}
