package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum CommentHideOpt implements ProtoEnum {
    HIDE_SELLER_REPLY(1),
    SHOW_SELLER_REPLY(2),
    HIDE_BUYER_COMMENT(3),
    SHOW_BUYER_COMMENT(4);
    
    private final int value;

    private CommentHideOpt(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
