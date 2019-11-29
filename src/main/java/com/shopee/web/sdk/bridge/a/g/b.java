package com.shopee.web.sdk.bridge.a.g;

import android.content.Context;
import com.shopee.web.sdk.bridge.protocol.sharing.ShowSharingPanelRequest;
import com.shopee.web.sdk.bridge.protocol.sharing.ShowSharingPanelResponse;

public abstract class b extends com.shopee.web.sdk.bridge.internal.b<ShowSharingPanelRequest, ShowSharingPanelResponse> {
    public String a() {
        return "showSharingPanel";
    }

    public b(Context context) {
        super(context, ShowSharingPanelRequest.class, ShowSharingPanelResponse.class);
    }
}
