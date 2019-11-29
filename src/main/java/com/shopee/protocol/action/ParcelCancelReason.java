package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ParcelCancelReason implements ProtoEnum {
    PARCEL_PICKUP_FAILED(1),
    PARCEL_DELIVERY_FAILED(2),
    PARCEL_LOST(3),
    PARCEL_SHIPMENT_CANCELLED(4),
    PARCEL_LOGISTICS_INVALID(5);
    
    private final int value;

    private ParcelCancelReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
