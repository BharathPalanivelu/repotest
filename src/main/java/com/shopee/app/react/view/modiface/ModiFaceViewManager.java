package com.shopee.app.react.view.modiface;

import android.app.Activity;
import android.util.AttributeSet;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.garena.android.appkit.d.a;
import d.d.b.j;
import java.util.Map;

public final class ModiFaceViewManager extends SimpleViewManager<d> {
    private e managerDelegate;

    public String getName() {
        return "ModiFaceView";
    }

    /* access modifiers changed from: protected */
    public d createViewInstance(ThemedReactContext themedReactContext) {
        j.b(themedReactContext, "context");
        a.e("modiface : createViewInstance", new Object[0]);
        Activity currentActivity = themedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            j.a();
        }
        j.a((Object) currentActivity, "context.currentActivity!!");
        d dVar = new d(currentActivity, themedReactContext, (AttributeSet) null, 0, 12, (g) null);
        this.managerDelegate = new e(dVar);
        themedReactContext.addLifecycleEventListener(dVar);
        dVar.a();
        return dVar;
    }

    @ReactProp(name = "makeupLook")
    public final void setMakeUpLook(d dVar, ReadableMap readableMap) {
        j.b(dVar, "modiFaceView");
        j.b(readableMap, "makeupLook");
        e eVar = this.managerDelegate;
        if (eVar != null) {
            eVar.a(dVar, readableMap);
        }
    }

    public void onDropViewInstance(d dVar) {
        j.b(dVar, "view");
        super.onDropViewInstance(dVar);
        dVar.onHostDestroy();
        this.managerDelegate = null;
        dVar.getReactContext().removeLifecycleEventListener(dVar);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> build = MapBuilder.builder().put("onError", MapBuilder.of("registrationName", "onError")).build();
        j.a((Object) build, "MapBuilder.builder<Strin…\n                .build()");
        return build;
    }
}
