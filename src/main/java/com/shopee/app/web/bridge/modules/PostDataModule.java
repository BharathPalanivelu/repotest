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
import d.m;

public final class PostDataModule extends WebBridgeModule {
    private final g dataBridgeHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "postData";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostDataModule(Context context, g gVar) {
        super(context);
        j.b(context, "context");
        j.b(gVar, "dataBridgeHandler");
        this.dataBridgeHandler = gVar;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        g gVar = this.dataBridgeHandler;
        if (obj != null) {
            a b2 = gVar.b((DataBridgeParams) obj);
            if (b2 instanceof a.c) {
                o json = BridgeResult.Companion.success(((a.c) b2).a()).toJson();
                WebPromise promise = getPromise();
                if (promise != null) {
                    promise.resolve(json);
                }
            } else if (b2 instanceof a.b) {
                a.b bVar = (a.b) b2;
                o json2 = BridgeResult.Companion.fail(bVar.a(), bVar.b().getMessage()).toJson();
                WebPromise promise2 = getPromise();
                if (promise2 != null) {
                    promise2.resolve(json2);
                }
            }
        } else {
            throw new m("null cannot be cast to non-null type com.shopee.app.react.protocol.DataBridgeParams");
        }
    }
}
