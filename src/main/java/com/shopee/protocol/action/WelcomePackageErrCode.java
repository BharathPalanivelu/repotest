package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum WelcomePackageErrCode implements ProtoEnum {
    WRONG_ITEM_QTY(1),
    MULTIPLE_FREE_GIFT(2),
    NOT_NEW_USER(3),
    MIX_WELCOMEPACKAGE_ITEM_AND_NORMAL_ITEM(4),
    RETURN_FREE_GIFT(5),
    REFUND_FREE_GIFT(6),
    MULTIPLE_WELCOMEPACKAGE_ORDER(7);
    
    private final int value;

    private WelcomePackageErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
