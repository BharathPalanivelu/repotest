package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.util.p.a;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import d.d.b.j;

public class TongDunModule extends WebBridgeModule {
    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "getTongdunBlackbox";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TongDunModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (getContext() != null) {
            collectBlackbox();
        }
    }

    public void collectBlackbox() {
        String b2 = a.f26481a.b();
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(BridgeResult.Companion.success(b2).toJson());
        }
    }
}
