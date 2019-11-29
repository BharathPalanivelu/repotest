package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum RequestSource implements ProtoEnum {
    FROM_UNKNOWN(1),
    FROM_APP(2),
    FROM_API(3),
    FROM_SELLER_CENTER_SINGLE(4),
    FROM_SELLER_CENTER_MASS(5);
    
    private final int value;

    private RequestSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
