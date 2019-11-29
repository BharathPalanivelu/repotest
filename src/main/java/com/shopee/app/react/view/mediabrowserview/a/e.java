package com.shopee.app.react.view.mediabrowserview.a;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class e extends Event<e> {
    public String getEventName() {
        return "onSaveImageFailure";
    }

    public e(int i) {
        super(i);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (rCTEventEmitter != null) {
            rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), (WritableMap) null);
        }
    }
}
