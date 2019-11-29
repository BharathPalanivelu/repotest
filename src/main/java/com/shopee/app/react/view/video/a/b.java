package com.shopee.app.react.view.video.a;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class b extends Event<b> {

    /* renamed from: a  reason: collision with root package name */
    private final int f19132a;

    public String getEventName() {
        return "onVideoPlaying";
    }

    public b(int i, int i2) {
        super(i);
        this.f19132a = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("currentPosition", (double) (this.f19132a / 1000));
        return createMap;
    }
}
