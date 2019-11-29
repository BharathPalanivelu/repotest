package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TongdunDecodeStatus implements ProtoEnum {
    DECODE_NOT_NEEDED(0),
    DECODE_PENDING(1),
    DECODE_SUCCESS(2),
    DECODE_FAILED(3),
    DECODE_MISSING_BLACKBOX(4);
    
    private final int value;

    private TongdunDecodeStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
