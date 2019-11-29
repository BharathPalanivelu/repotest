package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TongdunDecodeReason implements ProtoEnum {
    DECODE_VOUCHER(1),
    DECODE_WELCOME_PACKAGE(2),
    DECODE_FREE_SHIPPING_VOUCHER(3),
    DECODE_SHOPEE_REBATE(4),
    DECODE_COINS_REBATE(5);
    
    private final int value;

    private TongdunDecodeReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
