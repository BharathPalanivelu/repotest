package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum FlashSaleType implements ProtoEnum {
    FLASH_SALE_NORMAL(0),
    FLASH_SALE_BRAND(1),
    FLASH_SALE_SELLER(2);
    
    private final int value;

    private FlashSaleType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
