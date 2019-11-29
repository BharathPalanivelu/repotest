package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ItemOption implements ProtoEnum {
    FIRSTITEM_DISMISSED(1),
    INVALID_DISMISSED(2);
    
    private final int value;

    private ItemOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
