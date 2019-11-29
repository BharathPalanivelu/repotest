package com.shopee.app.react.modules.ui.navbar;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ShopeeReactBaseModule;

@ReactModule(name = "GANavbar")
public class NavbarModule extends ShopeeReactBaseModule<a> {
    protected static final String NAME = "GANavbar";

    public String getName() {
        return NAME;
    }

    public NavbarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a();
    }

    @ReactMethod
    public void configureNavbar(final int i, String str) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                NavbarModule.this.isMatchingReactTag(i);
            }
        });
    }

    @ReactMethod
    public void dimNavbar(final int i, boolean z, String str, float f2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                NavbarModule.this.isMatchingReactTag(i);
            }
        });
    }
}
