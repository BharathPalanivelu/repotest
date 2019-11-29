package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ShopMetricType implements ProtoEnum {
    LATE_SHIPMENT_RATE(1),
    ONTIME_SHIPMENT_RATE(2),
    NON_FULFILLMENT_RATE(3),
    AVG_PREPARATION_TIME(4),
    ITEM_BANNED_COUNT(5),
    ITEM_SEVERE_VIOLATE(9),
    ITEM_NORMAL_VIOLATE(10),
    CHAT_RESPONSE_RATE(11),
    PREORDER_RATE(12);
    
    private final int value;

    private ShopMetricType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
