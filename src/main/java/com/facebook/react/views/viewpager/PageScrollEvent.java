package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkMediaPlayer;

class PageScrollEvent extends Event<PageScrollEvent> {
    public static final String EVENT_NAME = "topPageScroll";
    private final float mOffset;
    private final int mPosition;

    public String getEventName() {
        return EVENT_NAME;
    }

    protected PageScrollEvent(int i, int i2, float f2) {
        super(i);
        this.mPosition = i2;
        this.mOffset = (Float.isInfinite(f2) || Float.isNaN(f2)) ? BitmapDescriptorFactory.HUE_RED : BitmapDescriptorFactory.HUE_RED;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(ViewProps.POSITION, this.mPosition);
        createMap.putDouble(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, (double) this.mOffset);
        return createMap;
    }
}
