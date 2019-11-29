package com.shopee.app.react.e;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;

public class b {
    public void a(a aVar, String str) {
        ReactContext reactContext = aVar.getReactContext();
        int reactTag = aVar.getReactTag();
        if (reactContext != null && reactTag > 0 && str != null) {
            o oVar = new o();
            oVar.a("reactTag", (Number) Integer.valueOf(reactTag));
            oVar.a("tabName", str);
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didReceiveTabPress", oVar.toString());
        }
    }
}
