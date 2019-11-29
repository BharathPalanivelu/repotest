package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum JkoAccountType implements ProtoEnum {
    INDIVIDUAL(1),
    MERCHANT(2);
    
    private final int value;

    private JkoAccountType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
