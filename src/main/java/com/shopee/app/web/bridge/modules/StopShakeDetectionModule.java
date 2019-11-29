package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.google.a.o;
import com.shopee.app.util.m.a;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import d.d.b.j;

public final class StopShakeDetectionModule extends WebBridgeModule {
    public a shakeHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "stopShakeDetection";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StopShakeDetectionModule(Context context) {
        super(context);
        j.b(context, "context");
        getComponent().inject(this);
    }

    public final a getShakeHandler$app_indonesiaRelease() {
        a aVar = this.shakeHandler;
        if (aVar == null) {
            j.b("shakeHandler");
        }
        return aVar;
    }

    public final void setShakeHandler$app_indonesiaRelease(a aVar) {
        j.b(aVar, "<set-?>");
        this.shakeHandler = aVar;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        a aVar = this.shakeHandler;
        if (aVar == null) {
            j.b("shakeHandler");
        }
        if (aVar.a()) {
            resolvePromise(0);
        } else {
            resolvePromise(1);
        }
    }

    public final void resolvePromise(int i) {
        o oVar = new o();
        oVar.a("errorCode", (Number) Integer.valueOf(i));
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(oVar);
        }
    }
}
