package com.shopee.app.react.view.sketchview;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class a extends Event<a> {
    public String getEventName() {
        return "onImageAvailable";
    }

    public a(int i) {
        super(i);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (rCTEventEmitter != null) {
            rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), (WritableMap) null);
        }
    }
}
