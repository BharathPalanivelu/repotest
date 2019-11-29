package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AttrTypeFlag implements ProtoEnum {
    KEY_ATTR(1),
    SALES_ATTR(2);
    
    private final int value;

    private AttrTypeFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
