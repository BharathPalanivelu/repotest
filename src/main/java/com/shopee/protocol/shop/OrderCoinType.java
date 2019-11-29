package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum OrderCoinType implements ProtoEnum {
    BASIC_COIN_RULE(0),
    CASHBACK_VOUCHER(1);
    
    private final int value;

    private OrderCoinType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
