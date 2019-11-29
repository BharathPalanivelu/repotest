package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum OrderCntUpdateTaskType implements ProtoEnum {
    CHECKOUT_CNT(1),
    ORDER_CNT(2),
    RETURN_CNT(3);
    
    private final int value;

    private OrderCntUpdateTaskType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
