package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum VoucherDisplayLabel implements ProtoEnum {
    NEW_USER(1),
    SHOPEEPAY(2),
    SHOPEEPAY_LATER(3),
    JKO_PAY(4);
    
    private final int value;

    private VoucherDisplayLabel(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
