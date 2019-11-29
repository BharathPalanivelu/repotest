package com.shopee.web.sdk.bridge.protocol.toast;

import com.google.a.a.a;
import com.google.a.a.c;

public class Toast {
    @a
    @c(a = "iconType")
    private String iconType;
    @a
    @c(a = "message")
    private String message;

    public String getIconType() {
        return this.iconType;
    }

    public Toast withIconType(String str) {
        this.iconType = str;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Toast withMessage(String str) {
        this.message = str;
        return this;
    }
}
