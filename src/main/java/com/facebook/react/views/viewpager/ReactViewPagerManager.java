package com.facebook.react.views.viewpager;

import android.view.View;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

@ReactModule(name = "AndroidViewPager")
public class ReactViewPagerManager extends ViewGroupManager<ReactViewPager> {
    public static final int COMMAND_SET_PAGE = 1;
    public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    public static final String REACT_CLASS = "AndroidViewPager";

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ReactViewPager createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewPager(themedReactContext);
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

    public void receiveCommand(ReactViewPager reactViewPager, int i, ReadableArray readableArray) {
        Assertions.assertNotNull(reactViewPager);
        Assertions.assertNotNull(readableArray);
        if (i == 1) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), true);
        } else if (i == 2) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), false);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), getClass().getSimpleName()}));
        }
    }

    public void addView(ReactViewPager reactViewPager, View view, int i) {
        reactViewPager.addViewToAdapter(view, i);
    }

    public int getChildCount(ReactViewPager reactViewPager) {
        return reactViewPager.getViewCountInAdapter();
    }

    public View getChildAt(ReactViewPager reactViewPager, int i) {
        return reactViewPager.getViewFromAdapter(i);
    }

    public void removeViewAt(ReactViewPager reactViewPager, int i) {
        reactViewPager.removeViewFromAdapter(i);
    }

    @ReactProp(defaultFloat = 0.0f, name = "pageMargin")
    public void setPageMargin(ReactViewPager reactViewPager, float f2) {
        reactViewPager.setPageMargin((int) PixelUtil.toPixelFromDIP(f2));
    }

    @ReactProp(defaultBoolean = false, name = "peekEnabled")
    public void setPeekEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setClipToPadding(!z);
    }
}
