package com.shopee.web.sdk.bridge.protocol.toast;

import com.google.a.a.a;
import com.google.a.a.c;

public class ShowToastRequest {
    @a
    @c(a = "toast")
    private Toast toast;

    public Toast getToast() {
        return this.toast;
    }

    public ShowToastRequest withToast(Toast toast2) {
        this.toast = toast2;
        return this;
    }
}
