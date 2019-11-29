package com.shopee.protocol.shop;

import com.facebook.internal.NativeProtocol;
import com.squareup.wire.ProtoEnum;
import com.tencent.imsdk.TIMGroupManager;

public enum PNOption implements ProtoEnum {
    NOTI_ALL(1),
    NOTI_ACTION_REQUIRED(2),
    NOTI_ACTIVITY(4),
    NOTI_CHATS(8),
    NOTI_STOCK(16),
    NOTI_GROUP_NOTI_OFF(32),
    NOTI_SHOPEE_PROMOTION(64),
    NOTI_RATING(128),
    EMAIL_ALL(256),
    EMAIL_ORDER_UPDATES(512),
    EMAIL_LIST_UPDATES(1024),
    EMAIL_NEWS_LETTER(2048),
    EMAIL_PERSONALISED(4096),
    NOTI_WALLET(8192),
    NOTI_ADS(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE),
    PN_FEED_COMMENTED(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG),
    PN_FEED_LIKED(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST),
    PN_FEED_MENTIONED(131072);
    
    private final int value;

    private PNOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
