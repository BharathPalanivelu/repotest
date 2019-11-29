package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ShopPerformanceType implements ProtoEnum {
    SHOP_PERFORMANCE_NON_FULFILMENT_RATE(1),
    SHOP_PERFORMANCE_CANCELLATION_RATE(2),
    SHOP_PERFORMANCE_RETURN_RATE(3),
    SHOP_PERFORMANCE_LATE_SHIPMENT_RATE(4),
    SHOP_PERFORMANCE_ITEM_SEVERE_PROHIBITED(5),
    SHOP_PERFORMANCE_ITEM_SEVERE_COUNTERFEIT(6),
    SHOP_PERFORMANCE_ITEM_SEVERE_SPAM(7),
    SHOP_PERFORMANCE_ITEM_NORMAL_VIOLATE(8);
    
    private final int value;

    private ShopPerformanceType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
