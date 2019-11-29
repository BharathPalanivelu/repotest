package com.shopee.app.react.view.mediabrowserview.a;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class d extends Event<d> {
    public String getEventName() {
        return "onImageLongClick";
    }

    public d(int i) {
        super(i);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (rCTEventEmitter != null) {
            rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), (WritableMap) null);
        }
    }
}
