package com.shopee.protocol.index.action;

import com.squareup.wire.ProtoEnum;

public enum SpuIndexJobType implements ProtoEnum {
    STANDARD_PRODUCT(1),
    SPU_SEARCH_DATA(2),
    SPU_SEARCH_TERM(3);
    
    private final int value;

    private SpuIndexJobType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
