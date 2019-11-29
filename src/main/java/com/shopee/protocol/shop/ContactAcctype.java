package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ContactAcctype implements ProtoEnum {
    PHONE(1),
    FACEBOOK(2),
    EMAIL(3),
    PHONE_AND_EMAIL(4),
    BEETALK(5);
    
    private final int value;

    private ContactAcctype(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
