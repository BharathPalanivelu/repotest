package com.shopee.app.react.e;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f18654a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18655b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18656c = false;

    public c(a aVar, String str) {
        this.f18654a = aVar;
        this.f18655b = str;
    }

    public void a() {
        this.f18656c = true;
    }

    public void run() {
        if (!this.f18656c) {
            ReactContext reactContext = this.f18654a.getReactContext();
            int reactTag = this.f18654a.getReactTag();
            if (reactContext == null || reactTag <= 0) {
                View viewRef = this.f18654a.getViewRef();
                if (viewRef != null) {
                    viewRef.postDelayed(this, 300);
                    return;
                }
                return;
            }
            o oVar = new o();
            oVar.a("reactTag", (Number) Integer.valueOf(reactTag));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(this.f18655b, oVar.toString());
        }
    }
}
