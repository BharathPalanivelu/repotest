package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum GetReferralListType implements ProtoEnum {
    REFERRAL_LIST_TYPE_STATUS(1),
    REFERRAL_LIST_TYPE_ACTIVITY(2);
    
    private final int value;

    private GetReferralListType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
