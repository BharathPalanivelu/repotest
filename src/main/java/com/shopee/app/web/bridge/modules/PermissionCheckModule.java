package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.app.data.store.al;
import com.shopee.app.ui.c.a;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.CheckPermissionMessage;
import com.shopee.web.sdk.bridge.a.f.b;
import java.util.List;

public class PermissionCheckModule extends WebBridgeModule implements b.C0475b {
    private a mHandler;
    al mLoginStore;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "checkAppPermission";
    }

    PermissionCheckModule(Context context) {
        super(context);
        getComponent().inject(this);
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.mHandler = new a(this.mLoginStore);
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity != null) {
            this.mHandler.a((Context) activity, ((CheckPermissionMessage) obj).permissionList, (b.C0475b) this);
        } else {
            rejectPromise();
        }
    }

    public void onResult(List<Boolean> list) {
        resolvePromise(list);
    }

    /* access modifiers changed from: package-private */
    public void resolvePromise(List<Boolean> list) {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) 1);
            oVar.a("resultList", list.toString());
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
