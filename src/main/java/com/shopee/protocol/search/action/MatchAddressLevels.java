package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum MatchAddressLevels implements ProtoEnum {
    COUNTRY(1),
    STATE(2),
    CITY(3),
    SUBCITY(4),
    OVERSEA(5);
    
    private final int value;

    private MatchAddressLevels(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
