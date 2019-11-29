package com.shopee.app.web2.a;

import android.app.Activity;
import com.shopee.app.web2.d;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;

public final class a extends h {
    public final void a(ConfigurePageRequest.ConfigMessage configMessage) {
        if (configMessage != null) {
            boolean z = configMessage.getDisableReload() == 1;
            if (configMessage.getEnableRotation() == 1) {
                Activity e2 = e();
                if (e2 != null) {
                    e2.setRequestedOrientation(2);
                }
            } else {
                Activity e3 = e();
                if (e3 != null) {
                    e3.setRequestedOrientation(1);
                }
            }
            d c2 = c();
            if (c2 != null) {
                c2.setShouldEnableReload(!z);
            }
        }
    }
}
