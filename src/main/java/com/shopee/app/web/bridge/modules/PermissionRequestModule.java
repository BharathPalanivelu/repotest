package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.a.o;
import com.shopee.app.ui.c.a;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.RequestPermissionMessage;
import com.shopee.web.sdk.bridge.a.f.b;
import java.util.List;

public class PermissionRequestModule extends WebBridgeModule implements b.C0475b {
    a mHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "requestAppPermission";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    PermissionRequestModule(Context context) {
        super(context);
        getComponent().inject(this);
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity != null) {
            RequestPermissionMessage requestPermissionMessage = (RequestPermissionMessage) obj;
            if (!TextUtils.isEmpty(requestPermissionMessage.popupText)) {
                this.mHandler.a(requestPermissionMessage.popupText);
            }
            this.mHandler.a(activity, requestPermissionMessage.permissionList, (b.C0475b) this);
            return;
        }
        rejectPromise();
    }

    /* access modifiers changed from: protected */
    public void onShowView() {
        super.onShowView();
        if (getActivity() != null) {
            this.mHandler.a((Context) getActivity());
        }
    }

    public void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        a aVar = this.mHandler;
        if (aVar != null) {
            aVar.a(activity, i, iArr);
        }
    }

    public void onResult(List<Boolean> list) {
        resolvePromise();
    }

    /* access modifiers changed from: package-private */
    public void resolvePromise() {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) 1);
            promise.resolve(oVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void rejectPromise() {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) 0);
            promise.reject(oVar);
        }
    }
}
