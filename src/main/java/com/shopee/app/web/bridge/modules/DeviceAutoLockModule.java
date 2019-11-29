package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import com.shopee.app.util.e.a;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.protocol.DeviceAutoLockMessage;
import d.d.b.j;

public final class DeviceAutoLockModule extends WebBridgeModule {
    private final a deviceAutoLockHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "deviceScreenAutoLock";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAutoLockModule(Context context, a aVar) {
        super(context);
        j.b(context, "context");
        j.b(aVar, "deviceAutoLockHandler");
        this.deviceAutoLockHandler = aVar;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (obj instanceof DeviceAutoLockMessage) {
            a aVar = this.deviceAutoLockHandler;
            j.a((Object) activity, "activity");
            aVar.a(activity, ((DeviceAutoLockMessage) obj).isEnabled());
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
