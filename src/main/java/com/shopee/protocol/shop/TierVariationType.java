package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TierVariationType implements ProtoEnum {
    LIPSTICK(1);
    
    private final int value;

    private TierVariationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
