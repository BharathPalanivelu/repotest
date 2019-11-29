package com.shopee.app.web.bridge.modules;

import android.content.Context;
import b.a;
import com.google.a.o;
import com.shopee.app.network.http.a.k;
import com.shopee.app.network.http.data.user.UserAccessTokenRequest;
import com.shopee.app.util.i;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.RequestAuthCodeFromCoreAuthMessage;
import d.d.b.j;
import d.m;
import io.b.b.b;
import io.b.d.f;

public final class RequestAuthCodeFromCoreAuthModule extends WebBridgeModule {
    private b disposable;
    public a<k> userAPI;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "requestAuthCodeFromCoreAuth";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestAuthCodeFromCoreAuthModule(Context context) {
        super(context);
        j.b(context, "context");
        getComponent().inject(this);
    }

    public final a<k> getUserAPI$app_indonesiaRelease() {
        a<k> aVar = this.userAPI;
        if (aVar == null) {
            j.b("userAPI");
        }
        return aVar;
    }

    public final void setUserAPI$app_indonesiaRelease(a<k> aVar) {
        j.b(aVar, "<set-?>");
        this.userAPI = aVar;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (obj != null) {
            RequestAuthCodeFromCoreAuthMessage requestAuthCodeFromCoreAuthMessage = (RequestAuthCodeFromCoreAuthMessage) obj;
            b bVar = this.disposable;
            if (bVar != null) {
                bVar.dispose();
            }
            a<k> aVar = this.userAPI;
            if (aVar == null) {
                j.b("userAPI");
            }
            String a2 = com.shopee.app.network.http.b.a.a();
            j.a((Object) a2, "RequestUtil.getCSRFCookieValue()");
            String str = i.f7040c;
            j.a((Object) str, "CONST.URL_BASE");
            this.disposable = aVar.get().a(a2, str, new UserAccessTokenRequest(requestAuthCodeFromCoreAuthMessage.getClientID())).b(io.b.h.a.b()).a(io.b.a.b.a.a()).a(new RequestAuthCodeFromCoreAuthModule$onBridgeInvoked$1(this), (f<? super Throwable>) new RequestAuthCodeFromCoreAuthModule$onBridgeInvoked$2(this));
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web.protocol.RequestAuthCodeFromCoreAuthMessage");
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.disposable;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    /* access modifiers changed from: private */
    public final void resolvePromise(String str) {
        o oVar = new o();
        oVar.a("errorCode", (Number) 0);
        oVar.a("authCode", str);
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(oVar);
        }
    }

    /* access modifiers changed from: private */
    public final void rejectPromise(int i, String str) {
        o oVar = new o();
        oVar.a("errorCode", (Number) Integer.valueOf(i));
        oVar.a("errorMessage", str);
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(oVar);
        }
    }
}
