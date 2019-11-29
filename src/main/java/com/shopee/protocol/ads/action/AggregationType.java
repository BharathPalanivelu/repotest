package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum AggregationType implements ProtoEnum {
    TYPE_ITEM(1),
    TYPE_KEYWORD(2),
    TYPE_ADS(3),
    TYPE_ADS_KW(4);
    
    private final int value;

    private AggregationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
