package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.garena.android.appkit.d.a;
import com.google.a.o;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.h.l;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.ui.image.icimage.c;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.OpenICCamera3Message;
import d.d.b.j;

public class ICCameraModule3 extends WebBridgeModule implements c.a {
    private c handler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "openICCamera3";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ICCameraModule3(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.handler = c.d(this);
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        c cVar = this.handler;
        if (cVar != null && getActivity() != null && obj != null) {
            cVar.a(IcCamera3Info.CREATOR.fromMessage((OpenICCamera3Message) obj));
            cVar.a(getActivity());
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        j.b(activity, "activity");
        c cVar = this.handler;
        if (cVar != null) {
            cVar.a(activity, i, i2, intent);
        }
    }

    public void onResult(String str, int i) {
        imageToBase64$app_indonesiaRelease(str, i);
    }

    public void imageToBase64$app_indonesiaRelease(String str, int i) {
        try {
            String a2 = l.a().a(str, i);
            if (a2 == null) {
                onError$app_indonesiaRelease(2, "User Cancel");
            } else {
                resolvePromise$app_indonesiaRelease(a2);
            }
        } catch (Exception e2) {
            a.a(e2);
            onError$app_indonesiaRelease(1, e2.toString());
        }
    }

    public void resolvePromise$app_indonesiaRelease(String str) {
        j.b(str, "data");
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("image", str);
            promise.resolve(BridgeResult.Companion.success(oVar).toJson());
        }
    }

    public void onError$app_indonesiaRelease(int i, String str) {
        j.b(str, "errorMessage");
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(BridgeResult.Companion.fail(i, str).toJson());
        }
    }
}
