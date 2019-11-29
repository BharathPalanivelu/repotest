package com.shopee.web.sdk.bridge.protocol.popup;

import com.google.a.a.a;
import com.google.a.a.c;

public class PopUp {
    @a
    @c(a = "cancelText")
    private String cancelText;
    @a
    @c(a = "message")
    private String message;
    @a
    @c(a = "okText")
    private String okText;
    @a
    @c(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public PopUp withTitle(String str) {
        this.title = str;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public PopUp withMessage(String str) {
        this.message = str;
        return this;
    }

    public String getOkText() {
        return this.okText;
    }

    public PopUp withOkText(String str) {
        this.okText = str;
        return this;
    }

    public String getCancelText() {
        return this.cancelText;
    }

    public PopUp withCancelText(String str) {
        this.cancelText = str;
        return this;
    }
}
