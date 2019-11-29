package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum SlashPriceActivityType implements ProtoEnum {
    ACTIVE(1),
    INACTIVE(2);
    
    private final int value;

    private SlashPriceActivityType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
