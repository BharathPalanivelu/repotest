package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum FulfillmentRateFlag implements ProtoEnum {
    FULFILLMENT_NORMAL(1),
    FULFILLMENT_WARNING(2),
    FULFILLMENT_MANUAL_DISABLE_WARNING(3),
    FULFILLMENT_DISPLAY_WARN(4),
    FULFILLMENT_DISPLAY_PUNISH(5);
    
    private final int value;

    private FulfillmentRateFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
