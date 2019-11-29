package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum RateControlType implements ProtoEnum {
    RATE_CONTROL_BACKEND(1000);
    
    private final int value;

    private RateControlType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
