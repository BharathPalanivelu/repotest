package com.shopee.protocol.fraud_detect.action;

import com.squareup.wire.ProtoEnum;

public enum Command implements ProtoEnum {
    CMD_DEEP_GRAPH_FRAUD_CHECK(1);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
