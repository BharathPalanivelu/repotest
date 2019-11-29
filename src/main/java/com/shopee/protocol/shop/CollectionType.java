package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CollectionType implements ProtoEnum {
    COLLECTION_ALL(0),
    COLLECTION_MANUAL(1),
    COLLECTION_AUTOMATED(2);
    
    private final int value;

    private CollectionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
