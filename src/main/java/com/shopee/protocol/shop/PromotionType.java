package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum PromotionType implements ProtoEnum {
    NORMAL_VOUCHER(0),
    COIN_CASHBACK_VOUCHER(1),
    FREE_SHIPPING_VOUCHER(2);
    
    private final int value;

    private PromotionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
