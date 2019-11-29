package com.shopee.protocol.pcenter;

import com.squareup.wire.ProtoEnum;

public enum SameItemStatus implements ProtoEnum {
    SAMEITEM_DELETE(0),
    SAMEITEM_NORMAL(1);
    
    private final int value;

    private SameItemStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
