package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ActivityUpdateType implements ProtoEnum {
    ITEM_DELETED(0),
    ITEM_OUTOF_STOCK(1),
    ITEM_EDITED(2);
    
    private final int value;

    private ActivityUpdateType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
