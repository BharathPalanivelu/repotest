package com.garena.rnrecyclerview.library.sticky;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class StickyRecyclerViewManager extends ViewGroupManager<c> {
    private static final int SCROLL_TO_ROW = 1;
    private static final int SCROLL_TO_ROW_WITH_OFFSET = 2;

    public String getName() {
        return "NativeStickyRecyclerView";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public c createViewInstance(ThemedReactContext themedReactContext) {
        c cVar = new c(themedReactContext);
        cVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return cVar;
    }

    public void addView(c cVar, View view, int i) {
        cVar.a(view);
    }

    @ReactProp(name = "dataSource")
    public void setDataSource(c cVar, ReadableMap readableMap) {
        cVar.setDataSource(cVar.getTransformer().a(readableMap));
    }

    public int getChildCount(c cVar) {
        return cVar.getChildCount();
    }

    public void removeAllViews(c cVar) {
        cVar.a();
        cVar.removeAllViews();
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("didStickyScroll", MapBuilder.of("registrationName", "didStickyScroll")).put("onStickyHeaderChanged", MapBuilder.of("registrationName", "onStickyHeaderChanged")).put("onStickyRowLayout", MapBuilder.of("registrationName", "onStickyRowLayout")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("scrollToRow", 1, "scrollToRowWithOffset", 2);
    }

    public void receiveCommand(c cVar, int i, ReadableArray readableArray) {
        if (i == 1) {
            cVar.a(readableArray.getInt(0), readableArray.getBoolean(1));
        } else if (i == 2) {
            cVar.a(readableArray.getInt(0), readableArray.getDouble(1), readableArray.getBoolean(2));
        }
    }

    public void onDropViewInstance(c cVar) {
        cVar.c();
    }
}
