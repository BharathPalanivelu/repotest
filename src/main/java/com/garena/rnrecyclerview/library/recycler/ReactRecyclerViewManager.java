package com.garena.rnrecyclerview.library.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.garena.rnrecyclerview.library.a;
import java.util.List;
import java.util.Map;

public class ReactRecyclerViewManager extends ViewGroupManager<ReactRecyclerView> {
    private static final int SCROLL_TO_ROW = 1;
    private static final int SCROLL_TO_ROW_WITH_OFFSET = 2;

    public String getName() {
        return "NativeRecyclerView";
    }

    /* access modifiers changed from: protected */
    public ReactRecyclerView createViewInstance(ThemedReactContext themedReactContext) {
        ReactRecyclerView reactRecyclerView = (ReactRecyclerView) LayoutInflater.from(themedReactContext).inflate(a.C0147a.react_recycler_view, (ViewGroup) null);
        reactRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return reactRecyclerView;
    }

    public void addView(ReactRecyclerView reactRecyclerView, View view, int i) {
        reactRecyclerView.n(view);
        reactRecyclerView.getViewList().add(i, view);
    }

    @ReactProp(name = "dataSource")
    public void setDataSource(ReactRecyclerView reactRecyclerView, ReadableMap readableMap) {
        reactRecyclerView.getBatchExecutor().a(readableMap);
        reactRecyclerView.getBatchExecutor().a();
    }

    public int getChildCount(ReactRecyclerView reactRecyclerView) {
        return reactRecyclerView.getViewList().size();
    }

    public void addViews(ReactRecyclerView reactRecyclerView, List<View> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            addView(reactRecyclerView, list.get(i), i);
        }
    }

    public View getChildAt(ReactRecyclerView reactRecyclerView, int i) {
        return reactRecyclerView.getViewList().get(i);
    }

    public void removeViewAt(ReactRecyclerView reactRecyclerView, int i) {
        reactRecyclerView.getViewList().remove(i);
    }

    public void removeView(ReactRecyclerView reactRecyclerView, View view) {
        reactRecyclerView.getViewList().remove(view);
    }

    public void removeAllViews(ReactRecyclerView reactRecyclerView) {
        reactRecyclerView.getViewList().clear();
        reactRecyclerView.y();
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("didScroll", MapBuilder.of("registrationName", "didScroll")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("scrollToRow", 1, "scrollToRowWithOffset", 2);
    }

    public void receiveCommand(ReactRecyclerView reactRecyclerView, int i, ReadableArray readableArray) {
        if (i == 1) {
            reactRecyclerView.b(readableArray.getInt(0), readableArray.getBoolean(1));
        } else if (i == 2) {
            reactRecyclerView.a(readableArray.getInt(0), readableArray.getDouble(1), readableArray.getBoolean(2));
        }
    }

    public void onDropViewInstance(ReactRecyclerView reactRecyclerView) {
        reactRecyclerView.A();
    }
}
