package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CategoryReturnType implements ProtoEnum {
    RETURN_DEFAULT(0),
    RETURN_NO_AUTO_PASS(1);
    
    private final int value;

    private CategoryReturnType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
