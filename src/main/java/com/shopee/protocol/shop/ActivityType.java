package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ActivityType implements ProtoEnum {
    FOLLOW_YOU(0),
    LIKE_YOUR_ITEM(1),
    YOUR_LIKEITEM_UPDATED(2),
    AT_YOU_IN_COMMENT(3),
    COMMENT_YOUR_ITEM(4),
    CONTACT_REGISTERED(5),
    ITEM_RATED(6),
    CUSTOMIZED_ACTIVITY(7),
    AT_YOU_IN_FEED_CMT(8),
    COMMENT_YOUR_FEED(9);
    
    private final int value;

    private ActivityType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
