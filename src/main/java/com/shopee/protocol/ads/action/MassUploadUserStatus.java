package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum MassUploadUserStatus implements ProtoEnum {
    DEFAULT(1);
    
    private final int value;

    private MassUploadUserStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
