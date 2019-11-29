package com.shopee.app.react.modules.app.toast;

import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.d.a;
import com.shopee.app.h.r;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "GAToast")
@Deprecated
public class ToastModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GAToast";
    private static final int REJECT_TOAST_MESSAGE_INVALID = 2;
    private static final int REJECT_TOAST_PARAM_INVALID = 1;

    public String getName() {
        return "GAToast";
    }

    public ToastModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void showToast(String str, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            promise.reject(String.valueOf(1), String.valueOf(1));
            return;
        }
        try {
            String string = new JSONObject(str).getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            if (TextUtils.isEmpty(string)) {
                promise.reject(String.valueOf(2), String.valueOf(2));
                return;
            }
            r.a().a(string);
            promise.resolve(1);
        } catch (JSONException e2) {
            a.a(e2);
            promise.reject(String.valueOf(1), String.valueOf(1));
        }
    }
}
