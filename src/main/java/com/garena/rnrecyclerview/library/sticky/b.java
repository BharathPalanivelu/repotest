package com.garena.rnrecyclerview.library.sticky;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private EventDispatcher f8619a = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();

    /* renamed from: b  reason: collision with root package name */
    private int f8620b = 200;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f8621c = new Runnable() {
        public void run() {
            b bVar = b.this;
            bVar.measure(View.MeasureSpec.makeMeasureSpec(bVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(b.this.getHeight(), 1073741824));
            b bVar2 = b.this;
            bVar2.layout(bVar2.getLeft(), b.this.getTop(), b.this.getRight(), b.this.getBottom());
        }
    };

    public b(Context context) {
        super(context);
    }

    public void requestLayout() {
        forceLayout();
        post(this.f8621c);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i3 = size2;
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(i, i2);
            i3 = getChildAt(0).getMeasuredHeight();
        }
        if (i3 == 0) {
            i3 = 200;
        }
        setMeasuredDimension(size, i3);
    }

    public void a() {
        this.f8619a.dispatchEvent(new a(getId(), getHeight()));
    }

    public void setRowHeight(int i) {
        this.f8620b = i;
    }

    public int getRowHeight() {
        return this.f8620b;
    }

    private class a extends Event<a> {

        /* renamed from: b  reason: collision with root package name */
        private final int f8624b;

        public String getEventName() {
            return "onHeightChanged";
        }

        private a(int i, int i2) {
            super(i);
            this.f8624b = i2;
        }

        public void dispatch(RCTEventEmitter rCTEventEmitter) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("height", (int) PixelUtil.toDIPFromPixel((float) this.f8624b));
            rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), createMap);
        }
    }
}
