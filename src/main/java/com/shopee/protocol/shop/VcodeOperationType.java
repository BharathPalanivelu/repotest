package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;
import com.tencent.qalsdk.im_open.http;

public enum VcodeOperationType implements ProtoEnum {
    GENERAL(0),
    ACCOUNT_REGISTER(1),
    ACCOUNT_LOGIN(2),
    ACCOUNT_BIND_PHONE(11),
    ACCOUNT_UPDATE_PASSWORD(21),
    ACCOUNT_UPDATE_PHONE_NUMBER(22),
    ACCOUNT_CHANGE_PHONE(23),
    ACCOUNT_CHANGE_EMAIL(24),
    ACCOUNT_UPDATE_BANK_ACCOUNT(25),
    ACCOUNT_UNBIND_PHONE(31),
    WALLET_UPDATE_SELLER_WALLET_PIN(101),
    WALLET_UPDATE_BUYER_WALLET_PIN(102),
    CHECK_TRUSTED_DEVICE(http.Not_Implemented);
    
    private final int value;

    private VcodeOperationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
