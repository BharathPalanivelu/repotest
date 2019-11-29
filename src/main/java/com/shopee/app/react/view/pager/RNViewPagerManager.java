package com.shopee.app.react.view.pager;

import android.view.View;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.viewpager.ReactViewPager;
import java.util.Map;

public class RNViewPagerManager extends ViewGroupManager<d> {
    public static final int COMMAND_SET_PAGE = 1;
    public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    protected static final String REACT_CLASS = "AndroidRNViewPager";

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public d createViewInstance(ThemedReactContext themedReactContext) {
        return new d(themedReactContext);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setScrollEnabled(z);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(PageScrollEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScroll"), PageScrollStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScrollStateChanged"), PageSelectedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageSelected"));
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("setPage", 1, "setPageWithoutAnimation", 2);
    }

    public void receiveCommand(d dVar, int i, ReadableArray readableArray) {
        Assertions.assertNotNull(dVar);
        Assertions.assertNotNull(readableArray);
        if (i == 1) {
            dVar.a(readableArray.getInt(0), true);
        } else if (i == 2) {
            dVar.a(readableArray.getInt(0), false);
        }
    }

    public void addView(d dVar, View view, int i) {
        dVar.a(view, i);
    }

    public int getChildCount(d dVar) {
        return dVar.getViewCountInAdapter();
    }

    public View getChildAt(d dVar, int i) {
        return dVar.b(i);
    }

    public void removeViewAt(d dVar, int i) {
        dVar.a(i);
    }

    @ReactProp(defaultFloat = 0.0f, name = "pageMargin")
    public void setPageMargin(d dVar, float f2) {
        dVar.setPageMargin((int) PixelUtil.toPixelFromDIP(f2));
    }
}
