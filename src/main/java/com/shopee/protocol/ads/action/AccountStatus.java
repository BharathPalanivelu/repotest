package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum AccountStatus implements ProtoEnum {
    ACC_DELETED(0),
    ACC_NORMAL(1),
    ACC_BANNED(2),
    ACC_PAUSED(3);
    
    private final int value;

    private AccountStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
