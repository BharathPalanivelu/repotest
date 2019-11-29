package com.shopee.web.sdk.bridge.a.a;

import android.content.Context;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;

public abstract class a extends b<ConfigurePageRequest, Void> {
    public String a() {
        return "configurePage";
    }

    public a(Context context) {
        super(context, ConfigurePageRequest.class, Void.class);
    }
}
