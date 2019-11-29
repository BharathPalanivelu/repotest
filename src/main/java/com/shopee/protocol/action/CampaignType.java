package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum CampaignType implements ProtoEnum {
    ITEM_CAMPAIGN_PROMOTION(1),
    ITEM_CAMPAIGN_GROUP_BUY(2),
    ITEM_CAMPAIGN_BUNDLE_DEAL(3),
    ITEM_CAMPAIGN_ADD_ON_DEAL(4);
    
    private final int value;

    private CampaignType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
