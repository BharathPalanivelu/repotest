package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ReturnSolution implements ProtoEnum {
    RETURN_AND_REFUND(0),
    REFUND_ONLY(1);
    
    private final int value;

    private ReturnSolution(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
