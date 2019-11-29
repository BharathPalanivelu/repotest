package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum FeedType implements ProtoEnum {
    FEED_NEW_ITEM(1),
    FEED_ITEM_UPDATE(2),
    FEED_ITEM_LIKE(3),
    FEED_ITEM_COMMENT(4),
    FEED_FRIEND_NEW_ITEM(5),
    FEED_ITEM_PROMOTE(6),
    FEED_AD_USER(7),
    BATCH_FEED_NEW_ITEM(8),
    BATCH_FEED_ITEM_UPDATE(9),
    BATCH_FEED_ITEM_LIKE(10),
    BATCH_FEED_ITEM_COMMENT(11),
    BATCH_FEED_FRIEND_NEW_ITEM(12),
    BATCH_FEED_ITEM_PROMOTE(13),
    FEED_LIKED_ITEM_REVIEW(14),
    BATCH_FEED_LIKED_ITEM_REVIEW(15),
    FEED_SHOP_UPDATE(16),
    FEED_FEED_LIKE(17),
    FEED_FEED_COMMENT(18),
    BATCH_FEED_FEED_LIKE(19),
    BATCH_FEED_FEED_COMMENT(20);
    
    private final int value;

    private FeedType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
