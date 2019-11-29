package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum SoldoutFilter implements ProtoEnum {
    NOT_SOLDOUT(0),
    ONLY_SOLDOUT(1),
    SOLDOUT_LAST(2);
    
    private final int value;

    private SoldoutFilter(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
