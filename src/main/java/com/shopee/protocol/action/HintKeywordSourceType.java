package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum HintKeywordSourceType implements ProtoEnum {
    SearchLog(0),
    AutoCorrect(1),
    CuratedSearchAdmin(2);
    
    private final int value;

    private HintKeywordSourceType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
