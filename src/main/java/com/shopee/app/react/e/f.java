package com.shopee.app.react.e;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f18668a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18669b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18670c = false;

    public f(a aVar, boolean z) {
        this.f18668a = aVar;
        this.f18669b = z;
    }

    public void a() {
        this.f18670c = true;
    }

    public void run() {
        if (!this.f18670c) {
            ReactContext reactContext = this.f18668a.getReactContext();
            int reactTag = this.f18668a.getReactTag();
            if (reactContext == null || reactTag <= 0) {
                View viewRef = this.f18668a.getViewRef();
                if (viewRef != null) {
                    viewRef.postDelayed(this, 300);
                    return;
                }
                return;
            }
            o oVar = new o();
            oVar.a("reactTag", (Number) Integer.valueOf(reactTag));
            oVar.a("show", (Number) Integer.valueOf(this.f18669b ? 1 : 0));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didReceiveScreenInStackEvent", oVar.toString());
        }
    }
}
