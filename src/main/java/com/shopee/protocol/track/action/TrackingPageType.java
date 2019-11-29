package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.TXLiteAVCode;

public enum TrackingPageType implements ProtoEnum {
    PAGE_TYPE_OTHERS(1),
    PAGE_TYPE_FRAME(2),
    PAGE_TYPE_BUY(1001),
    PAGE_TYPE_FEED(1002),
    PAGE_TYPE_NOTIFICATION(1003),
    PAGE_TYPE_ME(1004),
    PAGE_TYPE_BANNER_COLLECTION(2001),
    PAGE_TYPE_BANNER_EVENT(2002),
    PAGE_TYPE_HASHTAG(2003),
    PAGE_TYPE_TRENDING_KEYWORD(2004),
    PAGE_TYPE_MAIN_CATEGORY(2005),
    PAGE_TYPE_SUB_CATEGORY(2006),
    PAGE_TYPE_LVL3_CATEGORY(2007),
    PAGE_TYPE_OFFICIAL_SHOP(2008),
    PAGE_TYPE_FLASH_SALE(2009),
    PAGE_TYPE_POPULAR_PRODUCTS(2010),
    PAGE_TYPE_DAILY_DISCOVER(2011),
    PAGE_TYPE_YOU_MAY_ALSO_LIKE(2012),
    PAGE_TYPE_PRODUCT_DETAIL(2013),
    PAGE_TYPE_ATTRIBUTE_COLLECTION(2014),
    PAGE_TYPE_SHOP_DETAIL(2015),
    PAGE_TYPE_SHOP_DETAIL_FILTER(TXLiteAVCode.EVT_VOD_PLAY_TCP_CONNECT_SUCC),
    PAGE_TYPE_SHOP_DETAIL_CAT(TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET),
    PAGE_TYPE_TRENDING_SHOPS(TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED),
    PAGE_TYPE_PRODUCT_RATINGS(TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE),
    PAGE_TYPE_COMMENTS_INPUT(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES),
    PAGE_TYPE_RATING(TXLiteAVCode.EVT_HW_DECODER_START_SUCC),
    PAGE_TYPE_FROM_SAME_SHOP(TXLiteAVCode.EVT_SW_DECODER_START_SUCC),
    PAGE_TYPE_FRAME_SEARCH_RESULTS(3001),
    PAGE_TYPE_FRAME_SHOP_SEARCH_RESULTS(3002),
    PAGE_TYPE_BANNER_COLLECTION_SEARCH_RESULTS(3003),
    PAGE_TYPE_HASHTAG_SEARCH_RESULTS(3004),
    PAGE_TYPE_TRENDING_KEYWORD_SEARCH_RESULTS(3005),
    PAGE_TYPE_MAIN_CATEGORY_SEARCH_RESULTS(TXLiteAVCode.WARNING_RTMP_WRITE_FAIL),
    PAGE_TYPE_SUB_CATEGORY_SEARCH_RESULTS(TXLiteAVCode.WARNING_RTMP_READ_FAIL),
    PAGE_TYPE_LVL3_CATEGORY_SEARCH_RESULTS(TXLiteAVCode.WARNING_RTMP_NO_DATA),
    PAGE_TYPE_OFFICIAL_SHOP_SEARCH_RESULTS(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL),
    PAGE_TYPE_ATTRIBUTE_COLLECTION_SEARCH_RESULTS(TXLiteAVCode.WARNING_NO_STEAM_SOURCE_FAIL),
    PAGE_TYPE_SHOP_DETAIL_CAT_SEARCH_RESULTS(3011),
    PAGE_TYPE_SHOP_DETAIL_SEARCH_RESULTS(3012),
    PAGE_TYPE_SHOP_DETAIL_FILTER_SEARCH_RESULTS(3013),
    PAGE_TYPE_ME_SEARCH_RESULTS(3014),
    PAGE_TYPE_FOLLOWER(4001),
    PAGE_TYPE_FOLLOWING(4002),
    PAGE_TYPE_MY_LIKES(4003),
    PAGE_TYPE_RECENTLY_VIEWED(4004),
    PAGE_TYPE_MY_RATING(4005),
    PAGE_TYPE_CHAT_DIALOG(4006),
    PAGE_TYPE_ORDER_DETAILS(4007),
    PAGE_TYPE_RETURN_REFUND_DETAILS(4008),
    PAGE_TYPE_HELP_CENTER(4009),
    PAGE_TYPE_ACCOUNT_SETTINGS(4010),
    PAGE_TYPE_EDIT_PROFILE(4011),
    PAGE_TYPE_MY_PURCHASES(4012),
    PAGE_TYPE_SHOPEE_WALLET(4013),
    PAGE_TYPE_MY_SHOPEE_COINS(4014),
    PAGE_TYPE_MY_SALES(4015),
    PAGE_TYPE_MY_INCOME(4016),
    PAGE_TYPE_SHOP_SHIPPING_SETTING(4017),
    PAGE_TYPE_SELLER_ASSISTANT(4018),
    PAGE_TYPE_PRODUCT_LIST(4019),
    PAGE_TYPE_SHOPPING_CART(5001),
    PAGE_SNAPSHOT_PRODUCT_DETAIL(5002),
    PAGE_TYPE_SHOPEE_RECOMMENDED_SELLERS_CAT(BaseConstants.ERR_PARSE_RESPONSE_FAILED);
    
    private final int value;

    private TrackingPageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}