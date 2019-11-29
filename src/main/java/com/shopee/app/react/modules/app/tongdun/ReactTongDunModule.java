package com.shopee.app.react.modules.app.tongdun;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.util.p.a;
import d.d.b.j;

@ReactModule(name = "Tongdun")
public final class ReactTongDunModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "Tongdun";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactTongDunModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "context");
    }

    @ReactMethod
    public final void getBlackbox(Promise promise) {
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.resolve(BridgeResult.Companion.success(a.f26481a.b()).toString());
    }
}
