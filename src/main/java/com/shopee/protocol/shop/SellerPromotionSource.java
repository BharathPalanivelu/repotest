package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum SellerPromotionSource implements ProtoEnum {
    SHOPEE(0),
    SELLER(1),
    FLASH_SALE(2),
    SELLING_PRICE(3);
    
    private final int value;

    private SellerPromotionSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
