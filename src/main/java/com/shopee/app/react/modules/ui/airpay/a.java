package com.shopee.app.react.modules.ui.airpay;

import com.airpay.paysdk.core.bean.PayResult;
import com.facebook.react.bridge.Promise;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.WebRegister;

public final class a {
    /* access modifiers changed from: private */
    public static final void b(Promise promise, String str) {
        promise.resolve(BridgeResult.Companion.fail(-1, str).toString());
    }

    /* access modifiers changed from: private */
    public static final void b(Promise promise, PayResult payResult) {
        if (payResult == null) {
            b(promise, ReactAirPayModule.ERROR_NO_PAY_RESULT);
            return;
        }
        int a2 = payResult.a();
        if (a2 == 0) {
            promise.resolve(BridgeResult.Companion.fail(1).toString());
        } else if (a2 == 1) {
        } else {
            if (a2 != 2) {
                String b2 = WebRegister.GSON.b((Object) payResult.b());
                BridgeResult.Companion companion = BridgeResult.Companion;
                if (b2 == null) {
                    b2 = "";
                }
                promise.resolve(companion.fail(-1, b2).toString());
                return;
            }
            promise.resolve(BridgeResult.Companion.success().toString());
        }
    }
}
