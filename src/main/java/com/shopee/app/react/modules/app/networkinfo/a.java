package com.shopee.app.react.modules.app.networkinfo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.shopee.app.react.modules.base.b;

public class a extends b {
    public static int a(ReactApplicationContext reactApplicationContext) {
        if (com.shopee.app.network.a.b(reactApplicationContext)) {
            return 1;
        }
        return com.shopee.app.network.a.c(reactApplicationContext) ? 2 : 0;
    }

    public static String b(ReactApplicationContext reactApplicationContext) {
        return com.shopee.app.network.a.e(reactApplicationContext);
    }
}
