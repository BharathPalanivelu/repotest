package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.a.o;
import com.shopee.app.application.a.b;
import com.shopee.app.h.q;
import com.shopee.app.ui.b.a;
import com.shopee.app.ui.webview.g;
import com.shopee.app.util.n;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.id.R;
import d.d.b.j;

public class FacebookConnectAccountModule extends WebBridgeModule implements a.C0300a {
    public n mDataEventBus;
    private a mHandler;
    public b mLifeCycleManager;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "connectAccountWithFacebook";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookConnectAccountModule(Context context) {
        super(context);
        j.b(context, "context");
        getComponent().inject(this);
    }

    public b getMLifeCycleManager$app_indonesiaRelease() {
        b bVar = this.mLifeCycleManager;
        if (bVar == null) {
            j.b("mLifeCycleManager");
        }
        return bVar;
    }

    public void setMLifeCycleManager$app_indonesiaRelease(b bVar) {
        j.b(bVar, "<set-?>");
        this.mLifeCycleManager = bVar;
    }

    public n getMDataEventBus$app_indonesiaRelease() {
        n nVar = this.mDataEventBus;
        if (nVar == null) {
            j.b("mDataEventBus");
        }
        return nVar;
    }

    public void setMDataEventBus$app_indonesiaRelease(n nVar) {
        j.b(nVar, "<set-?>");
        this.mDataEventBus = nVar;
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.mHandler = new a(getMLifeCycleManager$app_indonesiaRelease(), getMDataEventBus$app_indonesiaRelease(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        a aVar = this.mHandler;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity != null) {
            a aVar = this.mHandler;
            if (aVar != null) {
                aVar.a(activity);
                return;
            }
            return;
        }
        rejectPromise();
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        super.onActivityResult(activity, i, i2, intent);
        a aVar = this.mHandler;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }

    public void onSuccess(String str) {
        resolvePromise(str);
    }

    public void onError(int i) {
        String str;
        g view = getView();
        if (view != null) {
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i != 5) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_social_bind_error);
            }
            q.a((View) view, str);
        }
        rejectPromise();
    }

    public void showProgress() {
        g view = getView();
        if (view != null) {
            view.i();
        }
    }

    public void hideProgress() {
        g view = getView();
        if (view != null) {
            view.j();
        }
    }

    public void resolvePromise(String str) {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) 1);
            oVar.a("accessToken", str);
            promise.resolve(oVar);
        }
    }

    public void rejectPromise() {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) 0);
            promise.resolve(oVar);
        }
    }
}
