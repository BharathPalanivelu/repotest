package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum MeasurementUnit implements ProtoEnum {
    CM(1);
    
    private final int value;

    private MeasurementUnit(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
