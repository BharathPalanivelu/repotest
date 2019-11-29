package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ItemAttributeInputType implements ProtoEnum {
    DROP_DOWN(1),
    TEXT_FILED(2),
    COMBO_BOX(3);
    
    private final int value;

    private ItemAttributeInputType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
