package com.garena.rnrecyclerview.library.parallax;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class ReactCoordinatorLayoutManager extends ViewGroupManager<b> {
    private static final int RESET_HEADER = 1;

    public String getName() {
        return "ReactCoordinatorLayout";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void addView(b bVar, View view, int i) {
        if (i == 1) {
            bVar.a(view);
        } else {
            bVar.b(view);
        }
    }

    /* access modifiers changed from: protected */
    public b createViewInstance(ThemedReactContext themedReactContext) {
        return new b(themedReactContext);
    }

    @ReactProp(name = "headerHeight")
    public void setHeaderHeight(b bVar, double d2) {
        bVar.setHeaderHeight((int) PixelUtil.toPixelFromDIP(d2));
    }

    @ReactProp(name = "stopY")
    public void setStopY(b bVar, double d2) {
        bVar.setStopY((int) PixelUtil.toPixelFromDIP(d2));
    }

    @ReactProp(name = "quickReturn")
    public void setQuickReturn(b bVar, boolean z) {
        bVar.setQuickReturn(z);
    }

    @ReactProp(name = "speedRatio")
    public void setSpeedRatio(b bVar, double d2) {
        bVar.setSpeedRatio(d2);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onParallaxMove", MapBuilder.of("registrationName", "onParallaxMove")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("resetParallaxHeader", 1);
    }

    public void receiveCommand(b bVar, int i, ReadableArray readableArray) {
        if (i == 1) {
            bVar.a();
        }
    }
}
