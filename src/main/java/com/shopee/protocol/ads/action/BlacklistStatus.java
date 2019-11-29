package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum BlacklistStatus implements ProtoEnum {
    BLACKLIST_DELETED(0),
    BLACKLIST_ACTIVE(1);
    
    private final int value;

    private BlacklistStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
