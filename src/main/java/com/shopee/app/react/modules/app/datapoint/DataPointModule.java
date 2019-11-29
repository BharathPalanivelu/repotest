package com.shopee.app.react.modules.app.datapoint;

import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.shopee.app.ui.datapoint.c;
import com.shopee.app.ui.datapoint.data.CollectDataEvent;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.DataPointBridgeMessage;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;
import java.util.HashMap;

@ReactModule(name = "GADataPoint")
public final class DataPointModule extends ReactContextBaseJavaModule implements c.b {
    static final /* synthetic */ e[] $$delegatedProperties = {p.a((m) new n(p.a(DataPointModule.class), "mHandlers", "getMHandlers()Ljava/util/HashMap;"))};
    private final d.e mHandlers$delegate = f.a(new a(this));

    private final HashMap<String, c> getMHandlers() {
        d.e eVar = this.mHandlers$delegate;
        e eVar2 = $$delegatedProperties[0];
        return (HashMap) eVar.a();
    }

    public String getName() {
        return "GADataPoint";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataPointModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
    }

    static final class a extends k implements d.d.a.a<HashMap<String, c>> {
        final /* synthetic */ DataPointModule this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(DataPointModule dataPointModule) {
            super(0);
            this.this$0 = dataPointModule;
        }

        /* renamed from: a */
        public final HashMap<String, c> invoke() {
            HashMap<String, c> hashMap = new HashMap<>();
            hashMap.put("contact", new com.shopee.app.ui.datapoint.a(this.this$0));
            return hashMap;
        }
    }

    @ReactMethod
    public final void startDataCollection(int i, String str) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        if (com.shopee.app.react.util.e.a(i, getCurrentActivity())) {
            DataPointBridgeMessage dataPointBridgeMessage = (DataPointBridgeMessage) WebRegister.GSON.a(str, DataPointBridgeMessage.class);
            if (dataPointBridgeMessage.getContentTypes() != null) {
                for (String str2 : dataPointBridgeMessage.getContentTypes()) {
                    c cVar = getMHandlers().get(str2);
                    if (cVar != null) {
                        cVar.b();
                    }
                }
            }
        }
    }

    public void onDone(CollectDataEvent collectDataEvent) {
        j.b(collectDataEvent, "data");
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CollectDataEvent", collectDataEvent.getJson().toString());
    }
}
