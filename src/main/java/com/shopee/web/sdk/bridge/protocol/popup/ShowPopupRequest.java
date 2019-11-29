package com.shopee.web.sdk.bridge.protocol.popup;

import com.google.a.a.a;
import com.google.a.a.c;

public class ShowPopupRequest {
    @a
    @c(a = "popUp")
    private PopUp popUp;

    public PopUp getPopUp() {
        return this.popUp;
    }

    public ShowPopupRequest withPopUp(PopUp popUp2) {
        this.popUp = popUp2;
        return this;
    }
}
