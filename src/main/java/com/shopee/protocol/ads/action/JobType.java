package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum JobType implements ProtoEnum {
    UPDATE_AD_CAMPAIGN(58),
    UPDATE_AD_ADS(59),
    UPDATE_AD_ACCOUNT(60),
    DELETE_AD_KEYWORDS(61);
    
    private final int value;

    private JobType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
