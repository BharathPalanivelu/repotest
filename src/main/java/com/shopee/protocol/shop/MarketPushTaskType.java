package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum MarketPushTaskType implements ProtoEnum {
    MP_REAL(1),
    MP_TEST(2),
    MP_FAIL(3),
    MP_AUTOGEN(100);
    
    private final int value;

    private MarketPushTaskType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
