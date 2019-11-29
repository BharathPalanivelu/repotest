package com.shopee.web.sdk.bridge.a.e;

import android.content.Context;
import com.shopee.web.sdk.bridge.protocol.navigation.NavigateRequest;

public abstract class b extends com.shopee.web.sdk.bridge.internal.b<NavigateRequest, Void> {
    public String a() {
        return "navigate";
    }

    public b(Context context) {
        super(context, NavigateRequest.class, Void.class);
    }
}
