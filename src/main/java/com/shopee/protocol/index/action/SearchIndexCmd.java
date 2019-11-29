package com.shopee.protocol.index.action;

import com.squareup.wire.ProtoEnum;

public enum SearchIndexCmd implements ProtoEnum {
    INSERT(1),
    UPDATE(2),
    DELETE(3);
    
    private final int value;

    private SearchIndexCmd(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
