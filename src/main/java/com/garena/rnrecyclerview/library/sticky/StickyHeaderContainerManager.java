package com.garena.rnrecyclerview.library.sticky;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class StickyHeaderContainerManager extends ViewGroupManager<b> {
    public void addView(b bVar, View view, int i) {
    }

    public String getName() {
        return "StickyHeaderContainer";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void removeAllViews(b bVar) {
    }

    public b createViewInstance(ThemedReactContext themedReactContext) {
        b bVar = new b(themedReactContext);
        bVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return bVar;
    }

    public int getChildCount(b bVar) {
        return bVar.getChildCount();
    }

    @ReactProp(name = "rowHeight")
    public void setRowHeight(b bVar, double d2) {
        bVar.setRowHeight((int) PixelUtil.toPixelFromDIP(d2));
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onHeightChanged", MapBuilder.of("registrationName", "onHeightChanged")).build();
    }
}
