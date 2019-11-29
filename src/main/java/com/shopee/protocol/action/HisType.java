package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum HisType implements ProtoEnum {
    ESCROW_INCOME(0),
    OTHER_INCOME(1),
    UNDER_ESCROW(2);
    
    private final int value;

    private HisType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
