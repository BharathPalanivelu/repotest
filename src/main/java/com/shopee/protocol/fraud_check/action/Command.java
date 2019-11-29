package com.shopee.protocol.fraud_check.action;

import com.squareup.wire.ProtoEnum;

public enum Command implements ProtoEnum {
    CMD_FRAUD_SYNC_LOGININFO(10),
    CMD_FRAUD_GET_TONGDUNINFO(11);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
