package com.shopee.app.react.view.grayscale;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGrayScaleViewManager extends ViewGroupManager<a> {
    public String getName() {
        return "RNGrayScaleView";
    }

    public a createViewInstance(ThemedReactContext themedReactContext) {
        return new a(themedReactContext);
    }

    @ReactProp(name = "grayScale")
    public void setGrayScale(a aVar, boolean z) {
        aVar.a(z);
    }
}
