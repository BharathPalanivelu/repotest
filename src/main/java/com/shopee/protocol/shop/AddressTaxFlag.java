package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AddressTaxFlag implements ProtoEnum {
    ADDR_FLAG_NONE(0),
    ADDR_FLAG_TAXED(1);
    
    private final int value;

    private AddressTaxFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
