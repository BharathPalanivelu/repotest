package com.shopee.app.web.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.ui.webview.g;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.web.WebEvent;

public abstract class WebBridgeModule {
    Activity mActivity;
    private WebBridgeInjector mComponent;
    /* access modifiers changed from: private */
    public WebPromise mPromise;
    bi mUIEventBus;
    private g mView;
    private e onBridgeCalled = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            if (WebBridgeModule.this.isValidEvent(aVar)) {
                try {
                    WebPromise unused = WebBridgeModule.this.mPromise = new WebPromise(((WebEvent) aVar).callbackId, WebBridgeModule.this.getView());
                    WebBridgeModule.this.onBridgeInvoked(aVar.data);
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                    WebBridgeModule.this.mPromise.reject(BridgeResult.Companion.fail(-1, e2.getMessage()).toJson());
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract String getBridgeName();

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public abstract void onBridgeInvoked(Object obj);

    /* access modifiers changed from: protected */
    public void onHideView() {
    }

    /* access modifiers changed from: protected */
    public abstract void onInit();

    public void onNewIntent(Intent intent) {
    }

    public void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
    }

    /* access modifiers changed from: protected */
    public void onShowView() {
    }

    public WebBridgeModule(Context context) {
        this.mComponent = (WebBridgeInjector) ((x) context).b();
        this.mComponent.inject(this);
    }

    public WebBridgeInjector getComponent() {
        return this.mComponent;
    }

    public void onAttachView(g gVar) {
        this.mView = gVar;
        onInit();
    }

    public final void startListening() {
        this.mUIEventBus.a(getBridgeName(), this.onBridgeCalled);
        onShowView();
    }

    public final void stopListening() {
        this.mUIEventBus.b(getBridgeName(), this.onBridgeCalled);
        onHideView();
    }

    public void onDestroy() {
        this.mView = null;
        this.mActivity = null;
        this.mPromise = null;
    }

    /* access modifiers changed from: protected */
    public g getView() {
        return this.mView;
    }

    /* access modifiers changed from: protected */
    public Activity getActivity() {
        return this.mActivity;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.mActivity;
    }

    /* access modifiers changed from: protected */
    public WebPromise getPromise() {
        return this.mPromise;
    }

    /* access modifiers changed from: private */
    public boolean isValidEvent(a aVar) {
        if (aVar instanceof WebEvent) {
            g gVar = this.mView;
            return gVar != null && String.valueOf(gVar.hashCode()).equals(((WebEvent) aVar).webPageViewId);
        }
    }
}
