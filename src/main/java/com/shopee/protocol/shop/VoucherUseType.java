package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum VoucherUseType implements ProtoEnum {
    PRIVATE(0),
    PUBLIC(1);
    
    private final int value;

    private VoucherUseType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
