package com.shopee.web.sdk.bridge.a.g;

import android.content.Context;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.sharing.ShareDataRequest;
import com.shopee.web.sdk.bridge.protocol.sharing.ShareDataResponse;

public abstract class a extends b<ShareDataRequest, ShareDataResponse> {
    public String a() {
        return "shareData";
    }

    public a(Context context) {
        super(context, ShareDataRequest.class, ShareDataResponse.class);
    }
}
