package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.google.a.q;
import com.shopee.app.ui.datapoint.a;
import com.shopee.app.ui.datapoint.c;
import com.shopee.app.ui.datapoint.data.CollectDataEvent;
import com.shopee.app.ui.webview.g;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.protocol.DataPointBridgeMessage;
import d.d.b.j;
import d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DataPointModule extends WebBridgeModule implements c.b {
    private HashMap<String, c> mHandlers = new HashMap<>();

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "startDataCollection";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataPointModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.mHandlers.put("contact", new a(this));
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (getActivity() == null) {
            return;
        }
        if (obj != null) {
            List<String> contentTypes = ((DataPointBridgeMessage) obj).getContentTypes();
            if (contentTypes != null && !contentTypes.isEmpty()) {
                for (String str : contentTypes) {
                    c cVar = this.mHandlers.get(str);
                    if (cVar != null) {
                        cVar.b();
                    }
                }
                return;
            }
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web.protocol.DataPointBridgeMessage");
    }

    public void onDestroy() {
        super.onDestroy();
        Collection<c> values = this.mHandlers.values();
        j.a((Object) values, "mHandlers.values");
        for (c c2 : values) {
            c2.c();
        }
    }

    public void onDone(CollectDataEvent collectDataEvent) {
        j.b(collectDataEvent, "data");
        sendBackEvent(collectDataEvent);
    }

    public void sendBackEvent(CollectDataEvent collectDataEvent) {
        j.b(collectDataEvent, "data");
        g view = getView();
        if (view != null) {
            view.b("COLLECT_DATA_EVENT", new q().a(WebRegister.GSON.b((Object) collectDataEvent)).m());
        }
    }
}
