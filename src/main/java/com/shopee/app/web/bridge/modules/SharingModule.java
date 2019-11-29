package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.app.ui.sharing.base.a;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.app.ui.webview.g;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.SharingDataMessage;
import d.d.b.j;
import d.m;

public class SharingModule extends WebBridgeModule implements b {
    private a<?> mShare;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "shareData";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    public void onPreProcessingData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharingModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (obj != null) {
            SharingDataMessage sharingDataMessage = (SharingDataMessage) obj;
            a<?> aVar = this.mShare;
            if (aVar != null) {
                aVar.c();
            }
            j.a((Object) activity, "activity");
            this.mShare = com.shopee.app.ui.sharing.b.a(activity, sharingDataMessage.getSharingAppID(), String.valueOf(sharingDataMessage.getSharingData()), this);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web.protocol.SharingDataMessage");
    }

    public void onDestroy() {
        super.onDestroy();
        a<?> aVar = this.mShare;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void onResult(com.shopee.app.ui.sharing.base.data.a aVar) {
        j.b(aVar, "shareResult");
        g view = getView();
        if (view != null) {
            view.r();
        }
        resolvePromise(aVar);
    }

    public void resolvePromise(com.shopee.app.ui.sharing.base.data.a aVar) {
        j.b(aVar, "shareResult");
        o oVar = new o();
        oVar.a("errorCode", (Number) Integer.valueOf(aVar.a()));
        oVar.a("errorMessage", aVar.b());
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(oVar);
        }
    }
}
