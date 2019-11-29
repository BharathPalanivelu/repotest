package com.shopee.app.react.modules.app.a;

import android.content.BroadcastReceiver;
import com.facebook.react.bridge.ReactApplicationContext;
import d.d.b.j;
import java.lang.ref.WeakReference;

public final class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<ReactApplicationContext> f18737a;

    public c(ReactApplicationContext reactApplicationContext) {
        j.b(reactApplicationContext, "context");
        this.f18737a = new WeakReference<>(reactApplicationContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r5 == 0) goto L_0x0051
            java.lang.String r4 = r5.getAction()
            r0 = 0
            if (r4 == 0) goto L_0x001a
            java.util.Map r1 = com.shopee.app.react.modules.app.a.a.a()
            java.lang.Object r4 = r1.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L_0x001a
            int r4 = r4.intValue()
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            com.shopee.react.sdk.bridge.protocol.PrinterStatusEventData r1 = new com.shopee.react.sdk.bridge.protocol.PrinterStatusEventData
            r1.<init>(r4)
            java.lang.ref.WeakReference<com.facebook.react.bridge.ReactApplicationContext> r4 = r3.f18737a
            java.lang.Object r4 = r4.get()
            com.facebook.react.bridge.ReactApplicationContext r4 = (com.facebook.react.bridge.ReactApplicationContext) r4
            if (r4 == 0) goto L_0x0043
            java.lang.Class<com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter> r2 = com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter.class
            com.facebook.react.bridge.JavaScriptModule r4 = r4.getJSModule(r2)
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r4 = (com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r4
            if (r4 == 0) goto L_0x0043
            com.shopee.navigator.b r1 = (com.shopee.navigator.b) r1
            com.shopee.react.sdk.bridge.protocol.DataResponse r1 = com.shopee.react.sdk.bridge.protocol.DataResponse.success(r1)
            java.lang.String r1 = r1.toJson()
            java.lang.String r2 = "PrinterStatusEvent"
            r4.emit(r2, r1)
        L_0x0043:
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = r5.getAction()
            r4[r0] = r5
            java.lang.String r5 = "EDCPrinter received status : %s"
            com.garena.android.appkit.d.a.e(r5, r4)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.modules.app.a.c.onReceive(android.content.Context, android.content.Intent):void");
    }
}
