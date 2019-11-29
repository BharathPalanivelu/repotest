package com.shopee.protocol.index.action;

import com.squareup.wire.ProtoEnum;

public enum JobType implements ProtoEnum {
    ITEM_CHANGE(2),
    UPDATE_INDEX(25),
    REMOVE_INDEX(26),
    UPDATE_SHOPINDEX(27),
    UPDATE_ITEMCOLLECTION(28),
    REMOVE_ITEMCOLLECTION(29),
    ADD_ITEMCOLLECTION(30),
    UPDATE_HASHTAGSCORE(31),
    UPDATE_SHOPSCORE(34),
    UPDATE_SHOPVISIBLE(35),
    SHOP_BUILD_CATEGORY(37),
    SHOP_DELETED(45),
    ITEM_SOLD_INFO(46),
    UPDATE_USER_INDEX(49),
    UPDATE_ORDER(50),
    REINDEX_ITEM_SHOPCOLL(55),
    UPDATE_ITEM_SKU(56),
    ADD_ITEM_SHOP_ID(57),
    UPDATE_SPU(86),
    DELETE_SPU(87),
    DELETE_SPU_TERM(88),
    INDEX_FEED_HASHTAG(89),
    DELETE_FEED_HASHTAG(90);
    
    private final int value;

    private JobType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
