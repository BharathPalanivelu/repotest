package com.shopee.app.react.view.rnreturnlistview;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import d.d.b.j;

public final class RNReturnListViewManager extends SimpleViewManager<b> {
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "RNReturnListView";
    }

    public RNReturnListViewManager(ReactApplicationContext reactApplicationContext) {
        j.b(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
    }

    public final ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    /* access modifiers changed from: protected */
    public b createViewInstance(ThemedReactContext themedReactContext) {
        j.b(themedReactContext, "context");
        return new b(new a(this.reactContext, themedReactContext.getCurrentActivity()));
    }
}
