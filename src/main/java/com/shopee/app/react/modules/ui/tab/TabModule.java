package com.shopee.app.react.modules.ui.tab;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ShopeeReactBaseModule;

@ReactModule(name = "GATab")
public class TabModule extends ShopeeReactBaseModule<a> {
    protected static final String NAME = "GATab";

    public String getName() {
        return NAME;
    }

    public TabModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a();
    }

    @ReactMethod
    public void dimTabBar(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (TabModule.this.isMatchingReactTag(i)) {
                    ((a) TabModule.this.getHelper()).a(TabModule.this.getCurrentActivity(), i, str, promise);
                    return;
                }
                o oVar = new o();
                oVar.a("status", (Number) 1);
                promise.resolve(oVar.toString());
            }
        });
    }
}
