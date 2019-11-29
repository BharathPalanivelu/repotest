package com.shopee.app.react.view.mediabrowserview.a;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class b extends Event<b> {

    /* renamed from: a  reason: collision with root package name */
    private final int f19053a;

    public String getEventName() {
        return "onImageChange";
    }

    public b(int i, int i2) {
        super(i);
        this.f19053a = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (rCTEventEmitter != null) {
            int viewTag = getViewTag();
            String eventName = getEventName();
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("index", this.f19053a);
            rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
        }
    }
}
