package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum PromotionFraudRule implements ProtoEnum {
    EXCLUDE_BLACKLISTED_PHONE_PREFIX(1),
    EXCLUDE_EXTISTING_DEVICE_FINGERPRINT(2);
    
    private final int value;

    private PromotionFraudRule(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
