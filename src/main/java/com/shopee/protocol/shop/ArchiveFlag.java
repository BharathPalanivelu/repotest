package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ArchiveFlag implements ProtoEnum {
    BUYER_ARCHIVE(1),
    SELLER_ARCHIVE(2);
    
    private final int value;

    private ArchiveFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
