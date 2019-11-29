package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ServerID implements ProtoEnum {
    CORE_SERVER_SUB(0),
    CORE_SERVER_CHAT(1),
    CORE_SERVER_EXT(2),
    SEARCH_SERVER(101),
    AD_SERVER(102),
    CHAT_SERVER(103),
    FRAUD_CHECK_SERVER(104),
    WSA_SERVER(105);
    
    private final int value;

    private ServerID(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
