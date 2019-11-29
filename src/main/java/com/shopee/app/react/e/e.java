package com.shopee.app.react.e;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f18664a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18665b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18666c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18667d = false;

    public e(a aVar, String str, boolean z) {
        this.f18664a = aVar;
        this.f18665b = z;
        this.f18666c = str;
    }

    public void a() {
        this.f18667d = true;
    }

    public void run() {
        if (!this.f18667d) {
            ReactContext reactContext = this.f18664a.getReactContext();
            int reactTag = this.f18664a.getReactTag();
            if (reactContext == null || reactTag <= 0) {
                View viewRef = this.f18664a.getViewRef();
                if (viewRef != null) {
                    viewRef.postDelayed(this, 300);
                    return;
                }
                return;
            }
            o oVar = new o();
            oVar.a("reactTag", (Number) Integer.valueOf(reactTag));
            oVar.a("show", (Number) Integer.valueOf(this.f18665b ? 1 : 0));
            oVar.a("tabName", this.f18666c);
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didReceiveTabViewEvent", oVar.toString());
        }
    }
}
