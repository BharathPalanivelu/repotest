package com.shopee.react.sdk.bridge.modules.ui.dialog;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseModule;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.PopupData;

@ReactModule(name = "GADialog")
public abstract class DialogModule extends ReactBaseModule<a> {
    public static final String NAME = "GADialog";

    public String getName() {
        return NAME;
    }

    public abstract a initHelper(a aVar);

    public DialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void showPopup(final int i, String str, final Promise promise) {
        final PopupData popupData = (PopupData) com.shopee.react.sdk.a.a.f30143a.a(str, PopupData.class);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DialogModule.this.isMatchingReactTag(i)) {
                    Activity access$000 = DialogModule.this.getCurrentActivity();
                    if (access$000 != null) {
                        ((a) DialogModule.this.getHelper()).a(access$000, DialogModule.this.getReactApplicationContext(), i, popupData, new c(promise));
                    }
                }
            }
        });
    }
}
