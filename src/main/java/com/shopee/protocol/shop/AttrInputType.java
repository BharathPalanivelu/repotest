package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AttrInputType implements ProtoEnum {
    INPUT_ENUM(1),
    INPUT_COMBOBOX(2),
    INPUT_TEXT(3);
    
    private final int value;

    private AttrInputType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
