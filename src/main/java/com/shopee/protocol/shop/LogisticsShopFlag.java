package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum LogisticsShopFlag implements ProtoEnum {
    ENABLE_SHOPEE_SUPPORTED(1),
    SHOP_ENABLE_SHOPEE_SUPPORTED(2),
    SHOW_FREE_SHIPPING(4);
    
    private final int value;

    private LogisticsShopFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
