package com.shopee.app.application.a.a;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;
import com.shopee.app.react.d;
import com.shopee.app.react.g;
import com.shopee.app.tracking.a;
import com.shopee.app.ui.a.e;
import com.shopee.shopeetracker.bimodel.TrackingAction;
import com.shopee.shopeetracker.bimodel.TrackingActionEvent;
import com.shopee.shopeetracker.bimodel.TrackingEvent;

public class b implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private a f15820a = ar.f().e().actionTracker();

    public void a(Activity activity) {
    }

    public void b(Activity activity) {
    }

    public void c(Activity activity) {
    }

    public void d(Activity activity) {
    }

    public void e(Activity activity) {
    }

    public void f(Activity activity) {
    }

    public void a(ar arVar, Activity activity) {
        TrackingActionEvent trackingActionEvent = new TrackingActionEvent();
        TrackingAction trackingAction = new TrackingAction();
        trackingAction.action = "onAppInForeground";
        trackingActionEvent.action = trackingAction;
        boolean z = activity instanceof e;
        trackingActionEvent.pageId = z ? ((e) activity).A() : "";
        this.f15820a.a((TrackingEvent) trackingActionEvent);
        if (z) {
            ((e) activity).z().b("action_app_come_foreground", com.shopee.app.tracking.trackingv3.b.f19172a);
        }
        a(activity, "onAppInForeground");
    }

    private void a(Activity activity, String str) {
        if (g.a() != null && g.a().e() != null && g.a().e().b() != null && g.a().e().b().getCurrentReactContext() != null) {
            ReactContext currentReactContext = g.a().e().b().getCurrentReactContext();
            if (currentReactContext != null) {
                o oVar = new o();
                boolean z = activity instanceof d;
                oVar.a("isReactNativeActivity", Boolean.valueOf(z));
                if (z) {
                    d dVar = (d) activity;
                    oVar.a("rootTag", (Number) Integer.valueOf(dVar.getReactTag()));
                    oVar.a("moduleName", dVar.l());
                }
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, oVar.toString());
            }
        }
    }

    public void b(ar arVar, Activity activity) {
        TrackingActionEvent trackingActionEvent = new TrackingActionEvent();
        TrackingAction trackingAction = new TrackingAction();
        trackingAction.action = "onAppInBackground";
        trackingActionEvent.action = trackingAction;
        boolean z = activity instanceof e;
        trackingActionEvent.pageId = z ? ((e) activity).A() : "";
        this.f15820a.a((TrackingEvent) trackingActionEvent);
        if (z) {
            ((e) activity).z().b("action_app_went_background", com.shopee.app.tracking.trackingv3.b.f19172a);
        }
        a(activity, "onAppInBackground");
    }
}
