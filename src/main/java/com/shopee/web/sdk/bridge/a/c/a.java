package com.shopee.web.sdk.bridge.a.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.common.StatusResponse;
import com.shopee.web.sdk.bridge.protocol.externallink.OpenExternalLinkRequest;

public class a extends b<OpenExternalLinkRequest, StatusResponse> {
    public String a() {
        return "openExternalLink";
    }

    public a(Context context) {
        super(context, OpenExternalLinkRequest.class, StatusResponse.class);
    }

    /* access modifiers changed from: protected */
    public void a(OpenExternalLinkRequest openExternalLinkRequest) {
        try {
            f().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(openExternalLinkRequest.getUrl())));
            b(new StatusResponse(1));
        } catch (ActivityNotFoundException unused) {
            b(new StatusResponse(0));
        }
    }
}
