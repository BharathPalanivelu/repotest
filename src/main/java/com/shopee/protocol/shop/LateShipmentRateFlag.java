package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum LateShipmentRateFlag implements ProtoEnum {
    LATE_SHIPMENT_NORMAL(1),
    LATE_SHIPMENT_WARNING(2),
    LATE_SHIPMENT_PUNISH(3);
    
    private final int value;

    private LateShipmentRateFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
