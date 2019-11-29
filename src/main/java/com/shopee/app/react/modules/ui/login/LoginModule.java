package com.shopee.app.react.modules.ui.login;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;

@ReactModule(name = "GALogin")
public class LoginModule extends ReactBaseLifecycleModule<a> {
    protected static final String NAME = "GALogin";

    public String getName() {
        return NAME;
    }

    public LoginModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a();
    }

    @ReactMethod
    public void showLoginScreen(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LoginModule.this.isMatchingReactTag(i)) {
                    ((a) LoginModule.this.getHelper()).a(LoginModule.this.getCurrentActivity(), str, promise);
                }
            }
        });
    }
}
