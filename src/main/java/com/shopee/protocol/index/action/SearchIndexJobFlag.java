package com.shopee.protocol.index.action;

import com.squareup.wire.ProtoEnum;

public enum SearchIndexJobFlag implements ProtoEnum {
    NONE(0),
    NOCHANGE_CATEGORY(1);
    
    private final int value;

    private SearchIndexJobFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
