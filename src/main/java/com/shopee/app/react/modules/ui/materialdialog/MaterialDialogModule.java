package com.shopee.app.react.modules.ui.materialdialog;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.bridge.modules.ui.dialog.DialogModule;
import com.shopee.react.sdk.bridge.modules.ui.dialog.a;

@ReactModule(name = "GADialog")
public class MaterialDialogModule extends DialogModule {
    public MaterialDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(com.shopee.react.sdk.activity.a aVar) {
        return new a();
    }

    @ReactMethod
    public void showPopup(int i, String str, Promise promise) {
        super.showPopup(i, str, promise);
    }
}
