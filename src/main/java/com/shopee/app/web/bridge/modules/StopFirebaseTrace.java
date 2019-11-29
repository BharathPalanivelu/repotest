package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.shopee.app.react.modules.app.FirebasePerf.a;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.TraceInfo;
import d.d.b.j;
import d.m;

public final class StopFirebaseTrace extends WebBridgeModule {
    private final a firebasePerf;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "stopFirebaseTrace";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StopFirebaseTrace(Context context, a aVar) {
        super(context);
        j.b(context, "context");
        j.b(aVar, "firebasePerf");
        this.firebasePerf = aVar;
    }

    public final a getFirebasePerf() {
        return this.firebasePerf;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (obj != null) {
            BridgeResult<?> a2 = this.firebasePerf.a((TraceInfo) obj);
            WebPromise promise = getPromise();
            if (promise != null) {
                promise.resolve(a2.toJson());
                return;
            }
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web.protocol.TraceInfo");
    }
}
