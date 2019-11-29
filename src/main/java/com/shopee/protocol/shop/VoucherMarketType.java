package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum VoucherMarketType implements ProtoEnum {
    DEFAULT_MARKET_PLACE(1),
    DIGITAL_PURCHASE(2);
    
    private final int value;

    private VoucherMarketType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
