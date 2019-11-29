package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum WebOption implements ProtoEnum {
    NEVER_SHOW_FEEDS_BANNER(1),
    NEVER_ALERT_PRIVACY_MSG(2),
    NEVER_SHOW_BOOST_MSG(4),
    NEVER_SHOW_WALLET_BANNER(8),
    KYC_CONSENT(16),
    KYC_SIMPLE(32),
    KYC_FULL(64);
    
    private final int value;

    private WebOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
