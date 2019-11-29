package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ItemType implements ProtoEnum {
    SHOPEE_ITEM(0),
    DIGITAL_PURCHASE_ITEM(1);
    
    private final int value;

    private ItemType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
