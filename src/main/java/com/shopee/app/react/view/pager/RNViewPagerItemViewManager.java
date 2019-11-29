package com.shopee.app.react.view.pager;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;

public class RNViewPagerItemViewManager extends ViewGroupManager<e> {
    public String getName() {
        return "RNViewPagerItemView";
    }

    public e createViewInstance(ThemedReactContext themedReactContext) {
        return new e(themedReactContext);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onViewPagerItemUpdate", MapBuilder.of("registrationName", "onViewPagerItemUpdate")).build();
    }
}
