package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum KeywordMatchType implements ProtoEnum {
    KW_EXACT_MATCH(0),
    KW_PHRASE_MATCH(1);
    
    private final int value;

    private KeywordMatchType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
