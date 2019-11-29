package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ShopCollectionType implements ProtoEnum {
    SCT_CUSTOMIZED(1),
    SCT_CATEGORY(2),
    SCT_HASHTAG(3),
    SCT_NEW_ARRIVAL(4),
    SCT_ON_SALE(5);
    
    private final int value;

    private ShopCollectionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
