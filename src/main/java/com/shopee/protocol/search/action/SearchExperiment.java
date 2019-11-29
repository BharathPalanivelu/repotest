package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum SearchExperiment implements ProtoEnum {
    ATEST(1),
    BTEST(2),
    AUTO_CORRECT(3);
    
    private final int value;

    private SearchExperiment(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
