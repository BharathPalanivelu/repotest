package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ViewPool {
    private static final int POOL_SIZE = 512;
    private final ViewManagerRegistry mViewManagerRegistry;
    private final Map<String, ClearableSynchronizedPool<View>> mViewPool = new HashMap();

    ViewPool(ViewManagerRegistry viewManagerRegistry) {
        this.mViewManagerRegistry = viewManagerRegistry;
    }

    /* access modifiers changed from: package-private */
    public void createView(String str, ReactStylesDiffMap reactStylesDiffMap, ThemedReactContext themedReactContext) {
        getViewPoolForComponent(str).release(this.mViewManagerRegistry.get(str).createViewWithProps(themedReactContext, reactStylesDiffMap, (JSResponderHandler) null));
    }

    /* access modifiers changed from: package-private */
    public View getOrCreateView(String str, ReactStylesDiffMap reactStylesDiffMap, ThemedReactContext themedReactContext) {
        ClearableSynchronizedPool<View> viewPoolForComponent = getViewPoolForComponent(str);
        View acquire = viewPoolForComponent.acquire();
        if (acquire != null) {
            return acquire;
        }
        createView(str, reactStylesDiffMap, themedReactContext);
        return viewPoolForComponent.acquire();
    }

    /* access modifiers changed from: package-private */
    public void returnToPool(String str, View view) {
        ClearableSynchronizedPool clearableSynchronizedPool = this.mViewPool.get(str);
        if (clearableSynchronizedPool != null) {
            clearableSynchronizedPool.release(view);
        }
    }

    private ClearableSynchronizedPool<View> getViewPoolForComponent(String str) {
        ClearableSynchronizedPool<View> clearableSynchronizedPool = this.mViewPool.get(str);
        if (clearableSynchronizedPool != null) {
            return clearableSynchronizedPool;
        }
        ClearableSynchronizedPool<View> clearableSynchronizedPool2 = new ClearableSynchronizedPool<>(512);
        this.mViewPool.put(str, clearableSynchronizedPool2);
        return clearableSynchronizedPool2;
    }
}
