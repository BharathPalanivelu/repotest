package com.garena.rnrecyclerview.library.view;

import android.view.ViewGroup;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class ReactRecyclerItemViewManager extends ViewGroupManager<a> {
    public String getName() {
        return "NativeRecyclerItemView";
    }

    public a createViewInstance(ThemedReactContext themedReactContext) {
        a aVar = new a(themedReactContext);
        aVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return aVar;
    }

    @ReactProp(name = "viewType")
    public void setViewType(a aVar, String str) {
        aVar.setViewType(str);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onUpdateView", MapBuilder.of("registrationName", "onUpdateView")).build();
    }
}
