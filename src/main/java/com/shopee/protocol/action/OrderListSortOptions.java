package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum OrderListSortOptions implements ProtoEnum {
    TO_SHIP_SHIPPING_CONFIRM_TIME_ASC(1);
    
    private final int value;

    private OrderListSortOptions(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
