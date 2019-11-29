package com.shopee.protocol.index.action;

import com.squareup.wire.ProtoEnum;

public enum IndexSource implements ProtoEnum {
    UNKNOW(0),
    ADS_BATCH(1),
    ADS_GDS(2),
    ADS_SCORE(3),
    ADS_DEDUCT(4);
    
    private final int value;

    private IndexSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
