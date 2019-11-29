package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum ESAggByField implements ProtoEnum {
    ItemID(1),
    AdsID(2),
    Placement(3),
    Keyword(4),
    KeywordQuery(5),
    KeywordQueryMatchType(6);
    
    private final int value;

    private ESAggByField(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
