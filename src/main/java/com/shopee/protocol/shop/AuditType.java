package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AuditType implements ProtoEnum {
    ITEM_NEW(1),
    ITEM_EDIT(2),
    ITEM_REPORT(3),
    ITEM_DEL(4),
    USER_REPORT(5),
    BANKACC(6),
    CHECKOUT(7),
    REFUND(8),
    ESCROW_RELEASE(9),
    PAYMENT_STATUS(10),
    MANUAL(11),
    ITEM_STATUS(12),
    SHOP_UPDATE(13),
    MODEL_EDIT(14),
    MODEL_ADD(15),
    MODEL_DEL(16),
    VIDEO_ADD(17),
    VIDEO_EDIT(18),
    VIDEO_DELETE(19),
    ACCOUNT_UPDATE(20),
    REFERRAL_UPDATE(21),
    ITEM_UNLIST(22),
    SLASH_PRICE_RULE_UPDATE(23),
    ITEM_LICENSE(24),
    SLASH_PRICE_ITEM_CREATED(25),
    SLASH_PRICE_ITEM_UPDATED(26),
    SLASH_PRICE_ITEM_DELETED(27),
    BRAND_NEW(28),
    BRAND_EDIT(29),
    BRAND_DELETE(30),
    JKO_SELLER_UPDATE(31),
    JKO_BUYER_UPDATE(32);
    
    private final int value;

    private AuditType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
