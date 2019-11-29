package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum SignatureTag implements ProtoEnum {
    CROSS_BORDER_USER(0);
    
    private final int value;

    private SignatureTag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
