package com.shopee.app.react.modules.ui.actionsheet;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;

@ReactModule(name = "GAActionSheet")
public class ActionSheetModule extends ReactBaseLifecycleModule<a> {
    protected static final String NAME = "GAActionSheet";

    public String getName() {
        return NAME;
    }

    public ActionSheetModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public void showActionSheet(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ActionSheetModule.this.isMatchingReactTag(i)) {
                    ((a) ActionSheetModule.this.getHelper()).a(str, promise);
                }
            }
        });
    }
}
