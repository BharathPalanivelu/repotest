package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingSectionType implements ProtoEnum {
    SECTION_TYPE_OTHERS(1),
    SECTION_TYPE_POPULAR_PRODUCTS(2),
    SECTION_TYPE_DAILY_DISCOVER(3),
    SECTION_TYPE_YOU_MAY_ALSO_LIKE(4),
    SECTION_TYPE_FLASH_SALE(5),
    SECTION_TYPE_OFFICIAL_SHOPS(6),
    SECTION_TYPE_TRENDING_SHOPS(7),
    SECTION_TYPE_JUST_FOR_YOU(8),
    SECTION_TYPE_CHAT_NOW(9),
    SECTION_TYPE_ADD_TO_CART(10),
    SECTION_TYPE_BUY_NOW(11),
    SECTION_TYPE_FROM_SAME_SHOP(12),
    SECTION_TYPE_CATEGORY(13),
    SECTION_TYPE_BANNER(14),
    SECTION_TYPE_COLLECTION_MODULE(15),
    SECTION_TYPE_MY_PROFILE(16),
    SECTION_TYPE_MY_PURCHASES(17),
    SECTION_TYPE_MY_SALES(18),
    SECTION_TYPE_BUYER_FUNCTIONS(19),
    SECTION_TYPE_SELLER_FUNCTIONS(20),
    SECTION_TYPE_MY_PRODUCTS(21);
    
    private final int value;

    private TrackingSectionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
