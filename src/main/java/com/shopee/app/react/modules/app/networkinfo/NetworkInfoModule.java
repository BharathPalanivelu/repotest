package com.shopee.app.react.modules.app.networkinfo;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;

@ReactModule(name = "GANetworkInfo")
public class NetworkInfoModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GANetworkInfo";

    public String getName() {
        return "GANetworkInfo";
    }

    public NetworkInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getNetworkInfo(Promise promise) {
        try {
            promise.resolve(createNetworkInfoMap(a.a(getReactApplicationContext()), a.b(getReactApplicationContext())).toString());
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    private o createNetworkInfoMap(int i, String str) {
        o oVar = new o();
        oVar.a("networkType", (Number) Integer.valueOf(i));
        oVar.a("cellularType", str);
        return oVar;
    }
}
