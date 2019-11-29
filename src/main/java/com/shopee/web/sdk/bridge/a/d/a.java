package com.shopee.web.sdk.bridge.a.d;

import android.content.Context;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.common.StatusResponse;
import com.shopee.web.sdk.bridge.protocol.login.LoginRequest;

public abstract class a extends b<LoginRequest, StatusResponse> {
    public String a() {
        return "login";
    }

    public a(Context context) {
        super(context, LoginRequest.class, StatusResponse.class);
    }
}
