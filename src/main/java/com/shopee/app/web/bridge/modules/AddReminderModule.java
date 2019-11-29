package com.shopee.app.web.bridge.modules;

import android.content.Context;
import android.os.Bundle;
import com.dieam.reactnativepushnotification.modules.b;
import com.facebook.share.internal.ShareConstants;
import com.google.a.o;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.AddReminderMessage;
import com.shopee.app.web.protocol.ReminderAndroidData;
import d.d.b.j;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;
import java.util.Random;

public class AddReminderModule extends WebBridgeModule {
    static final /* synthetic */ e[] $$delegatedProperties = {p.a((m) new n(p.a(AddReminderModule.class), "helper", "getHelper()Lcom/dieam/reactnativepushnotification/modules/RNPushNotificationHelper;")), p.a((m) new n(p.a(AddReminderModule.class), "mRandomGenerator", "getMRandomGenerator()Ljava/util/Random;"))};
    private final d.e helper$delegate = f.a(AddReminderModule$helper$2.INSTANCE);
    private final d.e mRandomGenerator$delegate = f.a(AddReminderModule$mRandomGenerator$2.INSTANCE);

    private b getHelper() {
        d.e eVar = this.helper$delegate;
        e eVar2 = $$delegatedProperties[0];
        return (b) eVar.a();
    }

    private Random getMRandomGenerator() {
        d.e eVar = this.mRandomGenerator$delegate;
        e eVar2 = $$delegatedProperties[1];
        return (Random) eVar.a();
    }

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "addReminder";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddReminderModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (getActivity() == null) {
            return;
        }
        if (obj != null) {
            String valueOf = String.valueOf(getMRandomGenerator().nextInt());
            Bundle reminderBundle = getReminderBundle(valueOf, (AddReminderMessage) obj);
            if (reminderBundle == null) {
                resolvePromise(BridgeResult.Companion.fail(1, "Invalid Input Params"));
                return;
            }
            getHelper().a(reminderBundle);
            o oVar = new o();
            oVar.a("reminderId", valueOf);
            resolvePromise(BridgeResult.Companion.success(oVar));
            return;
        }
        throw new d.m("null cannot be cast to non-null type com.shopee.app.web.protocol.AddReminderMessage");
    }

    public void resolvePromise(BridgeResult<?> bridgeResult) {
        j.b(bridgeResult, AbTestingModule.KEY_RESULT);
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(bridgeResult.toJson());
        }
    }

    private Bundle getReminderBundle(String str, AddReminderMessage addReminderMessage) {
        o oVar = new o();
        oVar.a("id", str);
        oVar.a("autoCancel", (Boolean) true);
        oVar.a("largeIcon", "com_garena_shopee_logo_shopee_launcher");
        oVar.a("smallIcon", "com_garena_shopee_logo_shopee_launcher");
        oVar.a("vibrate", (Boolean) true);
        oVar.a("vibration", (Number) 300);
        oVar.a("ongoing", (Boolean) false);
        oVar.a("title", addReminderMessage.getTitle());
        ReminderAndroidData android2 = addReminderMessage.getAndroid();
        oVar.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, android2 != null ? android2.getMessage() : null);
        oVar.a("soundName", "default");
        oVar.a("redirect", "t/home,p/" + addReminderMessage.getRedirect());
        if (addReminderMessage.getStartDate() == null || addReminderMessage.getReminderOffset() == null) {
            return null;
        }
        oVar.a("fireDate", (Number) Long.valueOf((((long) addReminderMessage.getStartDate().intValue()) * 1000) + (((long) addReminderMessage.getReminderOffset().intValue()) * 60000)));
        return com.shopee.app.util.f.f26349a.a(oVar);
    }
}
