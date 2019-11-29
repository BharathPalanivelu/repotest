package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.garena.android.appkit.d.a;
import com.google.a.o;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.h.l;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.ui.image.icimage.c;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.OpenICCameraMessage;

public class ICImageModule extends WebBridgeModule implements c.a {
    private c mHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "openICCamera2";
    }

    ICImageModule(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.mHandler = c.b(this);
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity != null) {
            OpenICCameraMessage openICCameraMessage = (OpenICCameraMessage) obj;
            this.mHandler.a(PhotoFrameInfo.Util.INSTANCE.from(openICCameraMessage));
            this.mHandler.a(openICCameraMessage.getPreferMinImageSize());
            this.mHandler.a(activity);
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        c cVar = this.mHandler;
        if (cVar != null) {
            cVar.a(activity, i, i2, intent);
        }
    }

    public void onResult(String str, int i) {
        imageToBase64(str, i);
    }

    /* access modifiers changed from: package-private */
    public void imageToBase64(String str, int i) {
        try {
            String a2 = l.a().a(str, i);
            if (a2 == null) {
                rejectPromise(2, "User Cancel");
            } else {
                resolvePromise(a2, 0);
            }
        } catch (Exception e2) {
            a.a(e2);
            rejectPromise(-1, e2.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void resolvePromise(String str, int i) {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("rotation", (Number) Integer.valueOf(i));
            oVar.a("image", str);
            promise.resolve(BridgeResult.Companion.success(oVar).toJson());
        }
    }

    /* access modifiers changed from: package-private */
    public void rejectPromise(int i, String str) {
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.reject(BridgeResult.Companion.fail(i, str).toJson());
        }
    }
}
