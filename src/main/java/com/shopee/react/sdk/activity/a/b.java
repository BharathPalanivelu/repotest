package com.shopee.react.sdk.activity.a;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f30153a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30154b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30155c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f30156d;

    public b(a aVar, String str) {
        this.f30153a = aVar;
        this.f30154b = str;
    }

    public void a(String str) {
        this.f30156d = str;
    }

    public void a() {
        this.f30155c = true;
    }

    public void run() {
        if (!this.f30155c) {
            ReactContext b2 = this.f30153a.b();
            int reactTag = this.f30153a.getReactTag();
            if (b2 == null || reactTag <= 0) {
                View c2 = this.f30153a.c();
                if (c2 != null) {
                    c2.postDelayed(this, 300);
                    return;
                }
                return;
            }
            o oVar = new o();
            oVar.a("reactTag", (Number) Integer.valueOf(reactTag));
            String str = this.f30156d;
            if (str != null) {
                oVar.a("data", str);
                this.f30156d = null;
            }
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) b2.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(this.f30154b, oVar.toString());
        }
    }
}
