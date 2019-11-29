package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum SyncDpDataRequestType implements ProtoEnum {
    SET_USER_NOT_NEW(1);
    
    private final int value;

    private SyncDpDataRequestType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
