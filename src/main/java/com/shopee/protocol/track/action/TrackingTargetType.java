package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingTargetType implements ProtoEnum {
    TARGET_TYPE_OTHERS(1),
    TARGET_TYPE_ITEM(2),
    TARGET_TYPE_SHOP(3),
    TARGET_TYPE_BANNER(4),
    TARGET_TYPE_CATEGORY(5),
    TARGET_TYPE_TAB(6),
    TARGET_TYPE_COLOR_BLOCK(7),
    TARGET_TYPE_BUTTON(8),
    TARGET_TYPE_TRENDING_SEARCHES(9),
    TARGET_TYPE_RATING(10),
    TARGET_TYPE_SEE_MORE_LINK(11),
    TARGET_TYPE_SEE_MORE_BUTTON(12),
    TARGET_TYPE_LIST(13),
    TARGET_TYPE_HEADLINE_LINK(14),
    TARGET_TYPE_COLLECTION_CARD(15),
    TARGET_TYPE_BOOST_NOW_BUTTON(16);
    
    private final int value;

    private TrackingTargetType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
