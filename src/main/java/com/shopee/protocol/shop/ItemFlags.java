package com.shopee.protocol.shop;

import com.facebook.internal.NativeProtocol;
import com.squareup.wire.ProtoEnum;
import tencent.tls.platform.SigType;

public enum ItemFlags implements ProtoEnum {
    IS_FAKE_ITEM(1),
    FREE_SHIPPING(2),
    SEO_DESCRIPTION(4),
    INTEGRATED_FREE_SHIPPING(8),
    OFFLINE_DEAL(16),
    NO_SEARCHABLE(32),
    IS_HIDDEN(64),
    IS_SYSTEM_UNLIST(128),
    IS_USER_UNLIST(256),
    IS_PREVIEW(512),
    IS_PRICE_MASK(1024),
    COD_FILTER(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST),
    CREDIT_CARD_FILTER(131072),
    NON_CC_INSTALLMENT_FILTER(SigType.D2),
    CC_INSTALLMENT_FILTER(524288),
    SERVICE_BY_SHOPEE_1(33554432),
    SERVICE_BY_SHOPEE_2(67108864),
    SERVICE_BY_SHOPEE_3(134217728),
    BADGE_TYPE_24H(SigType.TLS),
    BADGE_TYPE_4H(536870912);
    
    private final int value;

    private ItemFlags(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
