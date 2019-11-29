package com.shopee.web.sdk.bridge.a.e;

import android.content.Context;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.navigation.JumpRequest;

public abstract class a extends b<JumpRequest, Void> {
    public String a() {
        return "jump";
    }

    public a(Context context) {
        super(context, JumpRequest.class, Void.class);
    }
}
