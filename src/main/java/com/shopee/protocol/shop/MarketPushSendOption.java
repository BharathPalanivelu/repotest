package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum MarketPushSendOption implements ProtoEnum {
    MP_PUSH(1),
    MP_AR(2),
    MP_WEB_PUSH(4);
    
    private final int value;

    private MarketPushSendOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
