package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum PreferredDeliveryOption implements ProtoEnum {
    DELIVERY_ANYTIME(0),
    DELIVERY_OFFICE_HOUR(1);
    
    private final int value;

    private PreferredDeliveryOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
