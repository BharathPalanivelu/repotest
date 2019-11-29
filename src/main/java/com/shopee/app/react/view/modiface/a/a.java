package com.shopee.app.react.view.modiface.a;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import d.d.b.j;

public final class a extends Event<a> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0291a f19056a = new C0291a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f19057b;

    public String getEventName() {
        return "onError";
    }

    public a(int i, int i2) {
        super(i);
        this.f19057b = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        j.b(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private final WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("errCode", this.f19057b);
        j.a((Object) createMap, "Arguments.createMap().ap…Code\", errorNo)\n        }");
        return createMap;
    }

    /* renamed from: com.shopee.app.react.view.modiface.a.a$a  reason: collision with other inner class name */
    public static final class C0291a {
        private C0291a() {
        }

        public /* synthetic */ C0291a(g gVar) {
            this();
        }
    }
}
