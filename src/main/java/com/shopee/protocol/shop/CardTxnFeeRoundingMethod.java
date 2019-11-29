package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CardTxnFeeRoundingMethod implements ProtoEnum {
    ROUNDING_OFF(1),
    ROUNDING_UP(2),
    ROUNDING_DOWN(3);
    
    private final int value;

    private CardTxnFeeRoundingMethod(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
