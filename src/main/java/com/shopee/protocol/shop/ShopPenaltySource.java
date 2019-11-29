package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ShopPenaltySource implements ProtoEnum {
    PENALTY_SOURCE_AUTOMATIC(0),
    PENALTY_SOURCE_MANUAL(1);
    
    private final int value;

    private ShopPenaltySource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
