package com.shopee.app.react.view.pager;

import android.content.Context;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;

public class e extends ReactViewGroup {

    /* renamed from: a  reason: collision with root package name */
    final EventDispatcher f19081a = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();

    public e(Context context) {
        super(context);
    }

    public void a(int i, boolean z) {
        this.f19081a.dispatchEvent(new a(getId(), i, z));
    }

    public class a extends Event<a> {

        /* renamed from: b  reason: collision with root package name */
        private final int f19083b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f19084c;

        public boolean canCoalesce() {
            return false;
        }

        public String getEventName() {
            return "onViewPagerItemUpdate";
        }

        public a(int i, int i2, boolean z) {
            super(i);
            this.f19083b = i2;
            this.f19084c = z;
        }

        public void dispatch(RCTEventEmitter rCTEventEmitter) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("index", this.f19083b);
            createMap.putBoolean("isShown", this.f19084c);
            rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), createMap);
        }
    }
}
