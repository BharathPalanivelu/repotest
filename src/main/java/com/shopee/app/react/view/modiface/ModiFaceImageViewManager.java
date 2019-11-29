package com.shopee.app.react.view.modiface;

import android.app.Activity;
import android.util.AttributeSet;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.internal.ShareConstants;
import d.d.b.j;
import java.util.Map;

public final class ModiFaceImageViewManager extends SimpleViewManager<c> {
    private e managerDelegate;

    public String getName() {
        return "ModiFaceImageView";
    }

    /* access modifiers changed from: protected */
    public c createViewInstance(ThemedReactContext themedReactContext) {
        j.b(themedReactContext, "context");
        Activity currentActivity = themedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            j.a();
        }
        j.a((Object) currentActivity, "context.currentActivity!!");
        c cVar = new c(currentActivity, themedReactContext, (AttributeSet) null, 0, 12, (g) null);
        this.managerDelegate = new e(cVar);
        themedReactContext.addLifecycleEventListener(cVar);
        cVar.a();
        return cVar;
    }

    @ReactProp(name = "makeupLook")
    public final void setMakeUpLook(c cVar, ReadableMap readableMap) {
        j.b(cVar, "modiFaceView");
        j.b(readableMap, "makeupLook");
        e eVar = this.managerDelegate;
        if (eVar != null) {
            eVar.a(cVar, readableMap);
        }
    }

    @ReactProp(name = "imgUri")
    public final void setImgUri(c cVar, String str) {
        j.b(cVar, "modiFaceView");
        j.b(str, ShareConstants.MEDIA_URI);
        cVar.setUriPath(str);
        cVar.a();
    }

    public void onDropViewInstance(c cVar) {
        j.b(cVar, "view");
        super.onDropViewInstance(cVar);
        cVar.onHostDestroy();
        this.managerDelegate = null;
        cVar.getReactContext().removeLifecycleEventListener(cVar);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> build = MapBuilder.builder().put("onError", MapBuilder.of("registrationName", "onError")).build();
        j.a((Object) build, "MapBuilder.builder<Strin…\n                .build()");
        return build;
    }
}
