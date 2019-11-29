package com.shopee.web.sdk.bridge.protocol.popup;

import com.google.a.a.a;
import com.google.a.a.c;

public class ShowPopupResponse {
    @a
    @c(a = "buttonClicked")
    private Integer buttonClicked = 2;

    public Integer getButtonClicked() {
        return this.buttonClicked;
    }

    public ShowPopupResponse withButtonClicked(Integer num) {
        this.buttonClicked = num;
        return this;
    }
}
