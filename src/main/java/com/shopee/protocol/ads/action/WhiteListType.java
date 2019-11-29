package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum WhiteListType implements ProtoEnum {
    MASSUPLOAD(1),
    CHAT(2),
    SHOP_MIGRATION(3),
    MASSUPDATE(4),
    MASS_SHIP(5),
    MASSUPLOAD_IMAGES(6),
    SELF_DISCOUNT(7),
    WHOLESALE(8),
    PAID_ADS(9),
    OFFICIAL_SHOP(10),
    VOUCHER(11),
    FLASH_SALE(12),
    CRM_CHAT(13),
    DATA_CENTER(14),
    COMMENT_LIMIT(15),
    HOT_SALES(16),
    DTS_LIMIT(17),
    INCREASE_VARIATION_LIMIT(18),
    ORDER_EXPORT_BTN_PASSWORD(19),
    TW_COLLECTION_SHOP_WHITELIST(21),
    EXPRESS_MASS_UPDATE_TITLE_DESCRIPTION(22),
    PAYMENT_PASSWORD(23),
    SHOP_DECORATION(24),
    ORDER_EXPORT_FILE_OTP(25),
    WEBCHAT(26);
    
    private final int value;

    private WhiteListType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
