package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ItemAttributeType implements ProtoEnum {
    INT_TYPE(1),
    STRING_TYPE(2),
    ENUM_TYPE(3),
    FLOAT_TYPE(4),
    DATE_TYPE(5),
    TIMESTAMP_TYPE(6);
    
    private final int value;

    private ItemAttributeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
