package com.shopee.app.react.modules.app.data;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.data.a.a;
import com.shopee.app.react.protocol.DataBridgeParams;
import com.shopee.app.web.WebRegister;

@ReactModule(name = "GADataBridge")
public class DataBridge extends ReactContextBaseJavaModule {
    protected static final String NAME = "GADataBridge";
    private g dataBridgeHandler;

    public String getName() {
        return "GADataBridge";
    }

    public DataBridge(ReactApplicationContext reactApplicationContext, g gVar) {
        super(reactApplicationContext);
        this.dataBridgeHandler = gVar;
    }

    @ReactMethod
    public void get(String str, Promise promise) {
        a a2 = this.dataBridgeHandler.a((DataBridgeParams) WebRegister.GSON.a(str, DataBridgeParams.class));
        if (a2 instanceof a.c) {
            promise.resolve(((a.c) a2).a());
            return;
        }
        if (a2 instanceof a.b) {
            a.b bVar = (a.b) a2;
            promise.reject(String.valueOf(bVar.a()), (Throwable) bVar.b());
        }
        com.garena.b.a.a.b("DataBridge.get()", (Throwable) new IllegalStateException("The request was not handled correctly"));
    }

    @ReactMethod
    public void post(String str, Promise promise) {
        a b2 = this.dataBridgeHandler.b((DataBridgeParams) WebRegister.GSON.a(str, DataBridgeParams.class));
        if (b2 instanceof a.c) {
            promise.resolve(((a.c) b2).a());
            return;
        }
        if (b2 instanceof a.b) {
            a.b bVar = (a.b) b2;
            promise.reject(String.valueOf(bVar.a()), (Throwable) bVar.b());
        }
        com.garena.b.a.a.b("DataBridge.post()", (Throwable) new IllegalStateException("The request was not handled correctly"));
    }
}
