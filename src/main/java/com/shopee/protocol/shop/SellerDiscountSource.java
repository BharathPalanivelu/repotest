package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum SellerDiscountSource implements ProtoEnum {
    SELLER_DISCOUNT_SC(0),
    SELLER_DISCOUNT_BE(1);
    
    private final int value;

    private SellerDiscountSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
