package com.shopee.app.react.view.pager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkMediaPlayer;

class a extends Event<a> {

    /* renamed from: a  reason: collision with root package name */
    private final int f19068a;

    /* renamed from: b  reason: collision with root package name */
    private final float f19069b;

    public String getEventName() {
        return PageScrollEvent.EVENT_NAME;
    }

    protected a(int i, int i2, float f2) {
        super(i);
        this.f19068a = i2;
        this.f19069b = (Float.isInfinite(f2) || Float.isNaN(f2)) ? BitmapDescriptorFactory.HUE_RED : BitmapDescriptorFactory.HUE_RED;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(ViewProps.POSITION, this.f19068a);
        createMap.putDouble(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, (double) this.f19069b);
        return createMap;
    }
}
