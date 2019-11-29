package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum SlashPriceRejectType implements ProtoEnum {
    SENDER_DEVICE_LIMIT(1),
    SENDER_ACCOUNT_STATUS(2),
    SENDER_PHONE_BLACKLIST(3),
    RECEIVER_ACCOUNT_STATUS(4),
    RECEIVER_PHONE_BLACKLIST(5),
    SENDER_RECEIVER_SAME_DF(6),
    SENDER_RECEIVER_SAME_ADDR(7),
    SENDER_RECEIVER_SAME_PHONE(8);
    
    private final int value;

    private SlashPriceRejectType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
