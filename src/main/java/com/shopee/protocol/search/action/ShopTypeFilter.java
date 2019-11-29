package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum ShopTypeFilter implements ProtoEnum {
    PREFERRED(0),
    OFFICIAL_MALL(1),
    SERVICE_BY_SHOPEE(2);
    
    private final int value;

    private ShopTypeFilter(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
