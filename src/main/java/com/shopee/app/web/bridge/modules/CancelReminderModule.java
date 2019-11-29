package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.dieam.reactnativepushnotification.modules.b;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.CancelReminderMessage;
import d.d.b.j;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;

public class CancelReminderModule extends WebBridgeModule {
    static final /* synthetic */ e[] $$delegatedProperties = {p.a((m) new n(p.a(CancelReminderModule.class), "helper", "getHelper()Lcom/dieam/reactnativepushnotification/modules/RNPushNotificationHelper;"))};
    private final d.e helper$delegate = f.a(CancelReminderModule$helper$2.INSTANCE);

    private b getHelper() {
        d.e eVar = this.helper$delegate;
        e eVar2 = $$delegatedProperties[0];
        return (b) eVar.a();
    }

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "deleteReminder";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancelReminderModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (getActivity() == null) {
            return;
        }
        if (obj != null) {
            CancelReminderMessage cancelReminderMessage = (CancelReminderMessage) obj;
            if (cancelReminderMessage.getReminderId() != null) {
                if (!(cancelReminderMessage.getReminderId().length() == 0)) {
                    JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                    javaOnlyMap.putString("id", cancelReminderMessage.getReminderId());
                    getHelper().a((ReadableMap) javaOnlyMap);
                    resolvePromise(BridgeResult.Companion.success());
                    return;
                }
            }
            resolvePromise(BridgeResult.Companion.fail(1, "Empty ReminderId is not supported"));
            return;
        }
        throw new d.m("null cannot be cast to non-null type com.shopee.app.web.protocol.CancelReminderMessage");
    }

    public void resolvePromise(BridgeResult<?> bridgeResult) {
        j.b(bridgeResult, AbTestingModule.KEY_RESULT);
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(bridgeResult.toJson());
        }
    }
}
