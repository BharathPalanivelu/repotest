package com.shopee.app.react.view.sketchview;

import android.app.Activity;
import android.util.AttributeSet;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import d.d.b.j;
import java.util.Map;

public final class SketchViewManager extends SimpleViewManager<c> {
    private static final int CMD_CLEAR = 0;
    private static final int CMD_SAVE = 1;
    public static final a Companion = new a((g) null);

    public String getName() {
        return "RNSketchView";
    }

    /* access modifiers changed from: protected */
    public c createViewInstance(ThemedReactContext themedReactContext) {
        j.b(themedReactContext, "context");
        Activity currentActivity = themedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            j.a();
        }
        j.a((Object) currentActivity, "context.currentActivity!!");
        return new c(currentActivity, themedReactContext, (AttributeSet) null, 0, 12, (g) null);
    }

    public Map<String, Integer> getCommandsMap() {
        Map<String, Integer> of = MapBuilder.of("clear", 0, "save", 1);
        j.a((Object) of, "MapBuilder.of(\n         …save\", CMD_SAVE\n        )");
        return of;
    }

    public void receiveCommand(c cVar, int i, ReadableArray readableArray) {
        j.b(cVar, "root");
        if (i == 0) {
            cVar.b();
        } else if (i == 1) {
            if (readableArray == null) {
                j.a();
            }
            String string = readableArray.size() >= 2 ? readableArray.getString(1) : null;
            int i2 = readableArray.getInt(0);
            if (string == null) {
                string = "png";
            }
            cVar.a(i2, string);
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> build = MapBuilder.builder().put("onImageAvailable", MapBuilder.of("registrationName", "onImageAvailable")).put("onSaveComplete", MapBuilder.of("registrationName", "onSaveComplete")).build();
        j.a((Object) build, "MapBuilder.builder<Strin…e\"))\n            .build()");
        return build;
    }

    @ReactProp(name = "penSize")
    public final void setPenSize(c cVar, float f2) {
        j.b(cVar, "sketchView");
        cVar.setPenSize(PixelUtil.toPixelFromDIP(f2));
    }

    @ReactProp(name = "penColor")
    public final void setPenColor(c cVar, String str) {
        j.b(cVar, "sketchView");
        j.b(str, "penColor");
        cVar.setPenColor(str);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
