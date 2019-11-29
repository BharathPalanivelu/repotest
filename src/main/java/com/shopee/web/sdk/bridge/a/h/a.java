package com.shopee.web.sdk.bridge.a.h;

import android.content.Context;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.tracking.TrackBIEventRequest;

public abstract class a extends b<TrackBIEventRequest, Void> {
    public String a() {
        return "trackBIEvent";
    }

    public a(Context context) {
        super(context, TrackBIEventRequest.class, Void.class);
    }
}
