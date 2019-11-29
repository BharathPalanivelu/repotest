package com.shopee.react.sdk.bridge.modules.base;

import com.facebook.react.bridge.ReactContextBaseJavaModule;
import d.d.b.j;

public final class a {
    public static final void a(ReactContextBaseJavaModule reactContextBaseJavaModule, String str, Throwable th) {
        j.b(reactContextBaseJavaModule, "$this$handleThrowable");
        j.b(str, "moduleName");
        com.garena.b.a.a.b(str, th);
        if (th != null) {
            th.printStackTrace();
        }
    }
}
