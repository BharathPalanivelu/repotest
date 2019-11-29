package com.shopee.app.web.bridge.modules;

import com.garena.android.appkit.d.a;
import io.b.d.f;

final class RequestAuthCodeFromCoreAuthModule$onBridgeInvoked$2<T> implements f<Throwable> {
    final /* synthetic */ RequestAuthCodeFromCoreAuthModule this$0;

    RequestAuthCodeFromCoreAuthModule$onBridgeInvoked$2(RequestAuthCodeFromCoreAuthModule requestAuthCodeFromCoreAuthModule) {
        this.this$0 = requestAuthCodeFromCoreAuthModule;
    }

    public final void accept(Throwable th) {
        a.a(th);
        this.this$0.rejectPromise(-99, th.toString());
    }
}
