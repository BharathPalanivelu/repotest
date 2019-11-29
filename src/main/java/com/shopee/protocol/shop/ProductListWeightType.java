package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ProductListWeightType implements ProtoEnum {
    BOOST(0),
    ARRIVAL(1),
    SOCIAL(2),
    SALE(3),
    RANDOM(4),
    SOCIAL_N(5),
    SALE_M(6),
    SHOP_SCORE(7),
    ITEM_RATING(8);
    
    private final int value;

    private ProductListWeightType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
