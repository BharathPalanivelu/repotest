package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum OrderType implements ProtoEnum {
    UNKNOWN(0),
    SIMPLE(1),
    ESCROW(2);
    
    private final int value;

    private OrderType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
