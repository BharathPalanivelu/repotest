package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerRegistry;

public class ViewManagerFactory implements ViewFactory {
    private ViewManagerRegistry mViewManagerRegistry;

    public void recycle(ThemedReactContext themedReactContext, String str, View view) {
    }

    ViewManagerFactory(ViewManagerRegistry viewManagerRegistry) {
        this.mViewManagerRegistry = viewManagerRegistry;
    }

    public View getOrCreateView(String str, ReactStylesDiffMap reactStylesDiffMap, ThemedReactContext themedReactContext) {
        return this.mViewManagerRegistry.get(str).createViewWithProps(themedReactContext, reactStylesDiffMap, (JSResponderHandler) null);
    }
}
