package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum OTPHistory implements ProtoEnum {
    OTP_NONE(0),
    VOICE_OTP_ONCE(1);
    
    private final int value;

    private OTPHistory(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
