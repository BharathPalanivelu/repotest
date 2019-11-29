package com.shopee.protocol.clickmodel;

import com.squareup.wire.ProtoEnum;

public enum PageType implements ProtoEnum {
    CATEGORY_ITEMS(0),
    SEARCH_ITEMS(1),
    HASHTAG(2),
    HASHTAG_SEARCH(3),
    SHOP_ITEMS(4),
    SHOP_ITEMS_SEARCH(5),
    COLLECTION(6),
    COLLECTION_SEARCH(7),
    DAILY_DISCOVER(100),
    HOME_DAILY_DISCOVER(101),
    SHOP_LIKES_TAB(102),
    YOU_MAY_ALSO_LIKE(103),
    YOU_MAY_ALSO_LIKE_IN_ITEM(104);
    
    private final int value;

    private PageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
