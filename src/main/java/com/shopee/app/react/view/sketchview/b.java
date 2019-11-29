package com.shopee.app.react.view.sketchview;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.shopee.app.react.view.sketchview.d;

public final class b extends Event<b> {

    /* renamed from: a  reason: collision with root package name */
    private final d.b f19099a;

    public String getEventName() {
        return "onSaveComplete";
    }

    public b(int i, d.b bVar) {
        super(i);
        this.f19099a = bVar;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (rCTEventEmitter != null) {
            int viewTag = getViewTag();
            String eventName = getEventName();
            d.b bVar = this.f19099a;
            rCTEventEmitter.receiveEvent(viewTag, eventName, bVar != null ? bVar.a() : null);
        }
    }
}
