package com.facebook.react.views.scroll;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ReactScrollViewHelper {
    public static final String AUTO = "auto";
    public static final long MOMENTUM_DELAY = 20;
    public static final String OVER_SCROLL_ALWAYS = "always";
    public static final String OVER_SCROLL_NEVER = "never";

    public static void emitScrollEvent(ViewGroup viewGroup, float f2, float f3) {
        emitScrollEvent(viewGroup, ScrollEventType.SCROLL, f2, f3);
    }

    public static void emitScrollBeginDragEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, ScrollEventType.BEGIN_DRAG);
    }

    public static void emitScrollEndDragEvent(ViewGroup viewGroup, float f2, float f3) {
        emitScrollEvent(viewGroup, ScrollEventType.END_DRAG, f2, f3);
    }

    public static void emitScrollMomentumBeginEvent(ViewGroup viewGroup, int i, int i2) {
        emitScrollEvent(viewGroup, ScrollEventType.MOMENTUM_BEGIN, (float) i, (float) i2);
    }

    public static void emitScrollMomentumEndEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, ScrollEventType.MOMENTUM_END);
    }

    private static void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType) {
        emitScrollEvent(viewGroup, scrollEventType, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    private static void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType, float f2, float f3) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null) {
            ((UIManagerModule) ((ReactContext) viewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(ScrollEvent.obtain(viewGroup.getId(), scrollEventType, viewGroup.getScrollX(), viewGroup.getScrollY(), f2, f3, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
        }
    }

    public static int parseOverScrollMode(String str) {
        if (str == null || str.equals("auto")) {
            return 1;
        }
        if (str.equals(OVER_SCROLL_ALWAYS)) {
            return 0;
        }
        if (str.equals(OVER_SCROLL_NEVER)) {
            return 2;
        }
        throw new JSApplicationIllegalArgumentException("wrong overScrollMode: " + str);
    }
}
