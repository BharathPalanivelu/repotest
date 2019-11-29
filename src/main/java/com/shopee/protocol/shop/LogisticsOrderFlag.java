package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;
import tencent.tls.platform.SigType;

public enum LogisticsOrderFlag implements ProtoEnum {
    HAS_TRACKING(2),
    ESCROW_RELEASE_INCLUDES_SHIPPING(4),
    MANUAL_CONSIGNMENT(1),
    AUTO_CONSIGNMENT(8),
    ARRANGE_CONSIGNMENT(16),
    IS_SELF_COLLECT(8192),
    BUYER_PAID_FLAT_SHIPPING_FEE(32),
    DISCOUNT_PERCENTAGE(64),
    DISCOUNT_FIXED_DEDUCTION(128),
    REBATE_SHIPPING_FEE(256),
    REBATE_SHIPPING_FIXED_FEE(512),
    DISABLE_SHIPPING_REBATE(1024),
    SHOPEE_GENERATED_TRACKING_NUMBER(2048),
    SELLER_COVER_SHIPPING_FEE(4096),
    IS_RAPID_SLA(SigType.TLS),
    SUPPORT_CROSS_BORDER(536870912),
    DISCOUNT_BUYER_LOCATION_CHECK(1073741824);
    
    private final int value;

    private LogisticsOrderFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
