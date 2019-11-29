package com.shopee.app.react.view.video.a;

import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class a extends Event<a> {

    /* renamed from: a  reason: collision with root package name */
    private final int f19125a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19126b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19127c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19128d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f19129e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19130f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19131g;

    public String getEventName() {
        return "onVideoStateChanged";
    }

    public a(int i, String str, boolean z, int i2, int i3, boolean z2, int i4, int i5) {
        super(i);
        this.f19125a = i2;
        this.f19126b = str;
        this.f19127c = z;
        this.f19128d = i3;
        this.f19129e = z2;
        this.f19130f = i4;
        this.f19131g = i5;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ServerProtocol.DIALOG_PARAM_STATE, this.f19126b);
        createMap.putBoolean("isPlaying", this.f19127c);
        createMap.putDouble("duration", (double) (this.f19125a / 1000));
        createMap.putDouble("currentPosition", (double) (this.f19128d / 1000));
        createMap.putBoolean("isMuted", this.f19129e);
        createMap.putInt("sourceWidth", this.f19130f);
        createMap.putInt("sourceHeight", this.f19131g);
        return createMap;
    }
}
