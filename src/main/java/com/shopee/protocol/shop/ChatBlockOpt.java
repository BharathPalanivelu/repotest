package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ChatBlockOpt implements ProtoEnum {
    CHAT_BLOCK_OPT_NONE(0),
    CHAT_BLOCK_OPT_ADS(1);
    
    private final int value;

    private ChatBlockOpt(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
