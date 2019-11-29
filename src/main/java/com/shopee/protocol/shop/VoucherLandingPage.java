package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum VoucherLandingPage implements ProtoEnum {
    DEFAULT(1),
    ORDER_PAID_PAGE(2),
    FEED(4),
    LIVE_STREAMING(8),
    CHAT(16);
    
    private final int value;

    private VoucherLandingPage(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
