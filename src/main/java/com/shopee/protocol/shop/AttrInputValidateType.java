package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AttrInputValidateType implements ProtoEnum {
    VALID_ENUM(1),
    VALID_STRING(2),
    VALID_INT(3),
    VALID_DECIMAL(4),
    VALID_DATE(5);
    
    private final int value;

    private AttrInputValidateType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
