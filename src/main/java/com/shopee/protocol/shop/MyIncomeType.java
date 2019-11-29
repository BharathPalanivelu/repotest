package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum MyIncomeType implements ProtoEnum {
    ACTUAL_SHIPPING_COST(1),
    SHIPPING_FEE_REBATE(2),
    SHIPPING_FEE_PAIDBY_BUYER(3),
    REBATE_FEE(4),
    SHIPPING_FEE_SELLER_DISCOUNT(5);
    
    private final int value;

    private MyIncomeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
