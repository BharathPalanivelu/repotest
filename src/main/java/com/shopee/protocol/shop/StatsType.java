package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum StatsType implements ProtoEnum {
    ORDERS(0),
    INCOME(1),
    VISITS(2),
    SEARCH(3);
    
    private final int value;

    private StatsType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
