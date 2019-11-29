package com.garena.library.reactshadow.view;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactShadowViewManager extends ViewGroupManager<a> {
    private static final String PROP_ELEVATION = "elevation";
    private static final String PROP_INSET = "inset";

    public String getName() {
        return "ReactShadowView";
    }

    /* access modifiers changed from: protected */
    public a createViewInstance(ThemedReactContext themedReactContext) {
        return new a(themedReactContext);
    }

    @ReactProp(name = "shadow")
    public void setShadow(a aVar, ReadableMap readableMap) {
        int i = readableMap.hasKey(PROP_ELEVATION) ? readableMap.getInt(PROP_ELEVATION) : 2;
        if (!readableMap.hasKey(PROP_INSET)) {
            aVar.a(i, 0, 0, 0, 0);
            return;
        }
        ReadableMap map = readableMap.getMap(PROP_INSET);
        aVar.a(i, parseInset(ViewProps.LEFT, map), parseInset(ViewProps.TOP, map), parseInset(ViewProps.RIGHT, map), parseInset(ViewProps.BOTTOM, map));
    }

    private int parseInset(String str, ReadableMap readableMap) {
        if (!readableMap.hasKey(str)) {
            return 0;
        }
        return (int) PixelUtil.toPixelFromDIP(readableMap.getDouble(str));
    }
}
