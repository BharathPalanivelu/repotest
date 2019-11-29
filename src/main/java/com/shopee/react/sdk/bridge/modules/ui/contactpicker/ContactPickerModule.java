package com.shopee.react.sdk.bridge.modules.ui.contactpicker;

import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseActivityResultModule;

@ReactModule(name = "GAContactPicker")
public class ContactPickerModule extends ReactBaseActivityResultModule<a> {
    public static final String NAME = "GAContactPicker";

    public String getName() {
        return NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public ContactPickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(a aVar) {
        return new a();
    }

    @ReactMethod
    public void pickContact(final int i, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (ContactPickerModule.this.isMatchingReactTag(i)) {
                    ((a) ContactPickerModule.this.getHelper()).a(ContactPickerModule.this.getCurrentActivity(), promise);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 3 && getCurrentActivity() != null) {
            if (i2 == -1) {
                ((a) getHelper()).a(a.a(getReactApplicationContext().getContentResolver(), intent.getData()));
                return;
            }
            ((a) getHelper()).a(2);
        }
    }
}
