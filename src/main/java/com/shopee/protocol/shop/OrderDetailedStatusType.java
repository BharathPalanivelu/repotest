package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum OrderDetailedStatusType implements ProtoEnum {
    ORDER_DETAIL_CREATED(1),
    ORDER_DETAIL_SHIPPING_CONFIRMED(2),
    ORDER_DETAIL_PROCESSING(3),
    ORDER_DETAIL_SHIPPED(4),
    ORDER_DETAIL_RECEIVED(5),
    ORDER_DETAIL_CANCELED(6),
    ORDER_DETAIL_NOTIFY_SHIP(7);
    
    private final int value;

    private OrderDetailedStatusType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
