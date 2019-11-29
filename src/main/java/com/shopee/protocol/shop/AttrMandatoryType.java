package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AttrMandatoryType implements ProtoEnum {
    NORMAL_SELLER(1),
    MALL_SELLER(2);
    
    private final int value;

    private AttrMandatoryType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
