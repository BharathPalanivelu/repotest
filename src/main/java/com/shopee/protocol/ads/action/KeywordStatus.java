package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum KeywordStatus implements ProtoEnum {
    KW_DELETED(0),
    KW_NORMAL(1),
    KW_RESERVED(2);
    
    private final int value;

    private KeywordStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
