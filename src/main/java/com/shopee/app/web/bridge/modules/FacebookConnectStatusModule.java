package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.google.a.o;
import com.shopee.app.h.m;
import com.shopee.app.network.http.a.d;
import com.shopee.app.ui.b.c;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import d.d.b.j;

public class FacebookConnectStatusModule extends WebBridgeModule implements c.a {
    public m loginManager;
    public d mFacebookGraphAPI;
    private c mStatusHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "checkFacebookConnectionStatus";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookConnectStatusModule(Context context) {
        super(context);
        j.b(context, "context");
        getComponent().inject(this);
    }

    public m getLoginManager$app_indonesiaRelease() {
        m mVar = this.loginManager;
        if (mVar == null) {
            j.b("loginManager");
        }
        return mVar;
    }

    public void setLoginManager$app_indonesiaRelease(m mVar) {
        j.b(mVar, "<set-?>");
        this.loginManager = mVar;
    }

    public d getMFacebookGraphAPI$app_indonesiaRelease() {
        d dVar = this.mFacebookGraphAPI;
        if (dVar == null) {
            j.b("mFacebookGraphAPI");
        }
        return dVar;
    }

    public void setMFacebookGraphAPI$app_indonesiaRelease(d dVar) {
        j.b(dVar, "<set-?>");
        this.mFacebookGraphAPI = dVar;
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.mStatusHandler = new c(getLoginManager$app_indonesiaRelease(), getMFacebookGraphAPI$app_indonesiaRelease(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.mStatusHandler;
        if (cVar != null) {
            cVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (getActivity() != null) {
            checkFbConnectStatus();
        } else {
            rejectPromise();
        }
    }

    public void onCheckConnectionResult(int i, String str) {
        resolvePromise(i, str);
    }

    public void checkFbConnectStatus() {
        c cVar = this.mStatusHandler;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void resolvePromise(int i, String str) {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) Integer.valueOf(i));
            oVar.a("accessToken", str);
            promise.resolve(oVar);
        }
    }

    public void rejectPromise() {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) -1);
            promise.resolve(oVar);
        }
    }
}
