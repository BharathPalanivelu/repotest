package com.facebook.react.bridge;

import android.view.View;

public interface UIManager extends JSIModule, PerformanceCounter {
    <T extends View> int addRootView(T t, WritableMap writableMap, String str);

    void clearJSResponder();

    void dispatchCommand(int i, int i2, ReadableArray readableArray);

    void removeRootView(int i);

    void setJSResponder(int i, boolean z);

    void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap);

    void updateRootLayoutSpecs(int i, int i2, int i3);
}
