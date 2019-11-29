package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum Command implements ProtoEnum {
    CMD_GET_MANUAL_TOPUP_SUMMARY(1),
    CMD_SET_MANUAL_TOPUP(2),
    CMD_UPDATE_MANUAL_TOPUP_STATUS(3),
    CMD_GET_BLACKLISTED_KEYWORD(4),
    CMD_SET_BLACKLISTED_KEYWORD(5),
    CMD_GET_WHITELISTED_SELLER(7),
    CMD_SET_WHITELISTED_SELLER(8),
    CMD_DELETE_WHITELISTED_SELLER(9),
    CMD_GET_WHITELISTED_SELLER_BY_USERID(10);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
