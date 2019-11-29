package com.shopee.protocol.spu.action;

import com.squareup.wire.ProtoEnum;

public enum Command implements ProtoEnum {
    CMD_SET_ROOT_ATTRIBUTE(1),
    CMD_SET_ATTRIBUTE(2),
    CMD_SET_STANDARD_PRODUCT(3),
    CMD_SET_STANDARD_PRODUCT_ATTRIBUTE(4),
    CMD_SET_STANDARD_PRODUCT_SEARCH_TERM(5),
    CMD_SET_ATTRIBUTE_VALUE(6),
    CMD_SET_ATTRIBUTE_VALUE_RELATION(7),
    CMD_SET_STANDARD_PRODUCT_SEARCH_DATA(8),
    CMD_UPDATE_STANDARD_PRODUCT_SEARCH_DATA(9);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
