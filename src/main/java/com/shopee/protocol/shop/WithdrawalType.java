package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum WithdrawalType implements ProtoEnum {
    NO_SPLIT(1),
    SPLIT_ROOT(2),
    SPLIT_SUB(3);
    
    private final int value;

    private WithdrawalType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
