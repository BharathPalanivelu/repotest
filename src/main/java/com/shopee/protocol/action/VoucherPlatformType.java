package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum VoucherPlatformType implements ProtoEnum {
    NOT_MALL_ONLY(0),
    MALL_ONLY(1);
    
    private final int value;

    private VoucherPlatformType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
