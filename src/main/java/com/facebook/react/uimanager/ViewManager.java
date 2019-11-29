package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;

@ReactPropertyHolder
public abstract class ViewManager<T extends View, C extends ReactShadowNode> extends BaseJavaModule {
    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, T t) {
    }

    /* access modifiers changed from: protected */
    public abstract T createViewInstance(ThemedReactContext themedReactContext);

    public Map<String, Integer> getCommandsMap() {
        return null;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedViewConstants() {
        return null;
    }

    public abstract String getName();

    public abstract Class<? extends C> getShadowNodeClass();

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(T t) {
    }

    public void onDropViewInstance(T t) {
    }

    public void receiveCommand(T t, int i, ReadableArray readableArray) {
    }

    public abstract void updateExtraData(T t, Object obj);

    public Object updateLocalData(T t, ReactStylesDiffMap reactStylesDiffMap, ReactStylesDiffMap reactStylesDiffMap2) {
        return null;
    }

    public void updateState(T t, StateWrapper stateWrapper) {
    }

    public void updateProperties(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.updateProps(this, t, reactStylesDiffMap);
        onAfterUpdateTransaction(t);
    }

    private final T createView(ThemedReactContext themedReactContext, JSResponderHandler jSResponderHandler) {
        return createViewWithProps(themedReactContext, (ReactStylesDiffMap) null, jSResponderHandler);
    }

    public T createViewWithProps(ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap, JSResponderHandler jSResponderHandler) {
        T createViewInstanceWithProps = createViewInstanceWithProps(themedReactContext, reactStylesDiffMap);
        addEventEmitters(themedReactContext, createViewInstanceWithProps);
        if (createViewInstanceWithProps instanceof ReactInterceptingViewGroup) {
            ((ReactInterceptingViewGroup) createViewInstanceWithProps).setOnInterceptTouchEventListener(jSResponderHandler);
        }
        return createViewInstanceWithProps;
    }

    public C createShadowNodeInstance() {
        throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
    }

    public C createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        return createShadowNodeInstance();
    }

    /* access modifiers changed from: protected */
    public T createViewInstanceWithProps(ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap) {
        T createViewInstance = createViewInstance(themedReactContext);
        if (reactStylesDiffMap != null) {
            updateProperties(createViewInstance, reactStylesDiffMap);
        }
        return createViewInstance;
    }

    public Map<String, String> getNativeProps() {
        return ViewManagerPropertyUpdater.getNativeProps(getClass(), getShadowNodeClass());
    }
}
