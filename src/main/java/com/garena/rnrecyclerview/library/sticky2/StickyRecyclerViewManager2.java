package com.garena.rnrecyclerview.library.sticky2;

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
import com.garena.rnrecyclerview.library.recycler.ReactRecyclerView;
import java.util.Map;

public class StickyRecyclerViewManager2 extends ViewGroupManager<ReactRecyclerView> {
    private static final int SCROLL_TO_ROW = 1;
    private static final int SCROLL_TO_ROW_WITH_OFFSET = 2;

    public String getName() {
        return "NativeStickyRecyclerView";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ReactRecyclerView createViewInstance(ThemedReactContext themedReactContext) {
        ReactRecyclerView reactRecyclerView = (ReactRecyclerView) LayoutInflater.from(themedReactContext).inflate(a.C0147a.react_recycler_view, (ViewGroup) null);
        reactRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return reactRecyclerView;
    }

    public void addView(ReactRecyclerView reactRecyclerView, View view, int i) {
        reactRecyclerView.n(view);
    }

    @ReactProp(name = "dataSource")
    public void setDataSource(ReactRecyclerView reactRecyclerView, ReadableMap readableMap) {
        reactRecyclerView.setDataSource(reactRecyclerView.getDataSourceMapper().a(readableMap));
    }

    public int getChildCount(ReactRecyclerView reactRecyclerView) {
        return reactRecyclerView.getChildCount();
    }

    public void removeAllViews(ReactRecyclerView reactRecyclerView) {
        reactRecyclerView.y();
        reactRecyclerView.removeAllViews();
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("didStickyScroll", MapBuilder.of("registrationName", "didStickyScroll")).put("onStickyHeaderChanged", MapBuilder.of("registrationName", "onStickyHeaderChanged")).put("onStickyRowLayout", MapBuilder.of("registrationName", "onStickyRowLayout")).build();
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
