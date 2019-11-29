package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum VcodeActionType implements ProtoEnum {
    SEND_SMS_OTP(1),
    SEND_VOICE_OTP(2);
    
    private final int value;

    private VcodeActionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
