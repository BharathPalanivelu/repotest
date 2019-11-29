package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.google.a.o;
import com.shopee.app.util.m.a;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.StartShakeDetectionMessage;
import d.d.b.j;
import d.m;

public final class StartShakeDetectionModule extends WebBridgeModule {
    public a shakeHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "startShakeDetection";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartShakeDetectionModule(Context context) {
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
        if (getActivity() == null) {
            resolvePromise(-1);
        } else if (obj != null) {
            StartShakeDetectionMessage startShakeDetectionMessage = (StartShakeDetectionMessage) obj;
            a aVar = this.shakeHandler;
            if (aVar == null) {
                j.b("shakeHandler");
            }
            resolvePromise(aVar.a(startShakeDetectionMessage, new StartShakeDetectionModule$onBridgeInvoked$$inlined$let$lambda$1(this, obj)) ^ true ? 1 : 0);
        } else {
            throw new m("null cannot be cast to non-null type com.shopee.app.web.protocol.StartShakeDetectionMessage");
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

    /* access modifiers changed from: protected */
    public void onHideView() {
        super.onHideView();
        a aVar = this.shakeHandler;
        if (aVar == null) {
            j.b("shakeHandler");
        }
        aVar.a();
    }

    public void onDestroy() {
        super.onDestroy();
        a aVar = this.shakeHandler;
        if (aVar == null) {
            j.b("shakeHandler");
        }
        aVar.a();
    }
}
