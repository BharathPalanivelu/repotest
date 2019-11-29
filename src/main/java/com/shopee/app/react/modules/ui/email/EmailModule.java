package com.shopee.app.react.modules.ui.email;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;

@ReactModule(name = "GAEmailComposer")
public class EmailModule extends ReactBaseLifecycleModule<a> {
    protected static final String NAME = "GAEmailComposer";

    public String getName() {
        return NAME;
    }

    public EmailModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public void composeEmail(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (EmailModule.this.isMatchingReactTag(i)) {
                    ((a) EmailModule.this.getHelper()).a(str, promise);
                }
            }
        });
    }
}
