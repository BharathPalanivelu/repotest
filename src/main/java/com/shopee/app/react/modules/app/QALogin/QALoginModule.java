package com.shopee.app.react.modules.app.QALogin;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.network.d.f.n;

@ReactModule(name = "QALogin")
public class QALoginModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "QALogin";

    public String getName() {
        return NAME;
    }

    public QALoginModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void login(String str, String str2) {
        new n().a(str, str2);
    }
}
