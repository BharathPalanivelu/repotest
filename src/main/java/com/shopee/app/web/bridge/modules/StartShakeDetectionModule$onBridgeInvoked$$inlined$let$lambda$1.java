package com.shopee.app.web.bridge.modules;

import com.google.a.o;
import com.shopee.app.ui.webview.g;
import com.shopee.app.util.m.a;

public final class StartShakeDetectionModule$onBridgeInvoked$$inlined$let$lambda$1 implements a.C0407a {
    final /* synthetic */ Object $data$inlined;
    final /* synthetic */ StartShakeDetectionModule this$0;

    StartShakeDetectionModule$onBridgeInvoked$$inlined$let$lambda$1(StartShakeDetectionModule startShakeDetectionModule, Object obj) {
        this.this$0 = startShakeDetectionModule;
        this.$data$inlined = obj;
    }

    public void shakeDetected() {
        g access$getView = this.this$0.getView();
        if (access$getView != null) {
            access$getView.b("SHAKE_EVENT", (o) null);
        }
    }
}
