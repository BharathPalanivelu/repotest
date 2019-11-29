package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.google.a.o;
import com.shopee.app.data.a.a;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.react.protocol.DataBridgeParams;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import d.d.b.j;

public final class GetDataModule extends WebBridgeModule {
    private final g dataBridgeHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "getData";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetDataModule(Context context, g gVar) {
        super(context);
        j.b(context, "context");
        j.b(gVar, "dataBridgeHandler");
        this.dataBridgeHandler = gVar;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (!(obj instanceof DataBridgeParams)) {
            o json = BridgeResult.Companion.fail().toJson();
            WebPromise promise = getPromise();
            if (promise != null) {
                promise.resolve(json);
                return;
            }
            return;
        }
        a a2 = this.dataBridgeHandler.a((DataBridgeParams) obj);
        if (a2 instanceof a.c) {
            o json2 = BridgeResult.Companion.success(((a.c) a2).a()).toJson();
            WebPromise promise2 = getPromise();
            if (promise2 != null) {
                promise2.resolve(json2);
            }
        } else if (a2 instanceof a.b) {
            a.b bVar = (a.b) a2;
            o json3 = BridgeResult.Companion.fail(bVar.a(), bVar.b().getMessage()).toJson();
            WebPromise promise3 = getPromise();
            if (promise3 != null) {
                promise3.resolve(json3);
            }
        }
    }
}
