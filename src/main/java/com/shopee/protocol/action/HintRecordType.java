package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum HintRecordType implements ProtoEnum {
    RegularSearch(0),
    CuratedSearch(1);
    
    private final int value;

    private HintRecordType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
