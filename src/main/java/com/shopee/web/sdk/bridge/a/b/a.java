package com.shopee.web.sdk.bridge.a.b;

import android.content.Context;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.datapoint.DataPointBridgeRequest;

public abstract class a extends b<DataPointBridgeRequest, Void> {
    public String a() {
        return "startDataCollection";
    }

    public a(Context context) {
        super(context, DataPointBridgeRequest.class, Void.class);
    }
}
