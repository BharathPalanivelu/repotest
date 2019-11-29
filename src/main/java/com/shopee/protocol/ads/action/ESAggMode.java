package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum ESAggMode implements ProtoEnum {
    AggByInterval(1),
    AggByKey(2);
    
    private final int value;

    private ESAggMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
