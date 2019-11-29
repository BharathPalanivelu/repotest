package com.shopee.app.react.modules.ui.product;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.AddCartMessage;

@ReactModule(name = "GAAddToCart")
public class AddToCartModule extends ReactBaseLifecycleModule<a> {
    protected static final String NAME = "GAAddToCart";

    public String getName() {
        return NAME;
    }

    public AddToCartModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public void addToCart(int i, String str, Promise promise) {
        o oVar = (o) WebRegister.GSON.a(str, o.class);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Window window = currentActivity.getWindow();
            if (window != null) {
                View findViewById = window.getDecorView().findViewById(16908290);
                DisplayMetrics displayMetrics = getCurrentActivity().getResources().getDisplayMetrics();
                final int applyDimension = (int) (TypedValue.applyDimension(1, (float) oVar.c("cartX").g(), displayMetrics) + ((float) findViewById.getLeft()));
                final int applyDimension2 = (int) (TypedValue.applyDimension(1, (float) oVar.c("cartY").g(), displayMetrics) + ((float) findViewById.getTop()));
                final AddCartMessage addCartMessage = (AddCartMessage) WebRegister.GSON.a(str, AddCartMessage.class);
                final int i2 = i;
                final Promise promise2 = promise;
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        if (AddToCartModule.this.isMatchingReactTag(i2)) {
                            ((a) AddToCartModule.this.getHelper()).a(addCartMessage, applyDimension, applyDimension2, promise2);
                        }
                    }
                });
            }
        }
    }

    public void onHostResume() {
        super.onHostResume();
        ((a) getHelper()).a();
    }

    public void onHostPause() {
        super.onHostPause();
        ((a) getHelper()).b();
    }
}
