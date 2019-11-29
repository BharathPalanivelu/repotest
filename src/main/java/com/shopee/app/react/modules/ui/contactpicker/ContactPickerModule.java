package com.shopee.app.react.modules.ui.contactpicker;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.g.n;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseActivityResultModule;

@ReactModule(name = "GAContactPicker")
public class ContactPickerModule extends ReactBaseActivityResultModule<a> {
    public String getName() {
        return com.shopee.react.sdk.bridge.modules.ui.contactpicker.ContactPickerModule.NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public ContactPickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
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
        if (i == 3) {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                return;
            }
            if (i2 == -1) {
                ((a) getHelper()).a(new n(currentActivity.getContentResolver(), intent.getData()).apply((Void) null));
                return;
            }
            ((a) getHelper()).a(2);
        }
    }
}
