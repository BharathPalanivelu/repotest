package com.shopee.app.react.e;

import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;
import com.shopee.app.util.bm;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f18657a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f18658b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f18659c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18660d = false;

    public d(a aVar, String str) {
        this.f18657a = aVar;
        this.f18659c = str;
    }

    public void a() {
        this.f18660d = true;
    }

    public void a(String str) {
        this.f18658b = str;
    }

    public void run() {
        if (!this.f18660d && !TextUtils.isEmpty(this.f18658b)) {
            final ReactContext reactContext = this.f18657a.getReactContext();
            final int reactTag = this.f18657a.getReactTag();
            if (reactContext == null || reactTag <= 0) {
                View viewRef = this.f18657a.getViewRef();
                if (viewRef != null) {
                    viewRef.postDelayed(this, 300);
                    return;
                }
                return;
            }
            View viewRef2 = this.f18657a.getViewRef();
            if (viewRef2 != null) {
                viewRef2.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            o oVar = new o();
                            oVar.a("reactTag", (Number) Integer.valueOf(reactTag));
                            oVar.a("navigateParam", bm.c(d.this.f18658b).toString());
                            oVar.a("tabName", d.this.f18659c);
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onJumpToRNTab", oVar.toString());
                        } catch (Exception unused) {
                        }
                    }
                }, 3000);
            }
        }
    }
}
