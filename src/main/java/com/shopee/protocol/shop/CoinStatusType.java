package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CoinStatusType implements ProtoEnum {
    NOT_RETRIEVED(0),
    RETRIEVED(1);
    
    private final int value;

    private CoinStatusType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
