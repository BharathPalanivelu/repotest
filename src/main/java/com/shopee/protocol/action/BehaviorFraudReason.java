package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum BehaviorFraudReason implements ProtoEnum {
    NO_FRAUD(0),
    SAME_IC(1),
    SAME_BANK(2),
    SAME_ADDRESS(3),
    SAME_CREDITCARD(4),
    SAME_DEVICEID(6),
    FRAUD_NETWROK(8),
    CHECKOUT_LIMIT(9),
    SAME_BANK_ACC_NAME(10),
    DEVICE_VOUCHER_LIMIT(11),
    DEEP_GRAPH_FRAUD_CHECK(12),
    REFERRAL_FRAUD(13),
    NOT_NEW_USER_PHONE_BLACKLIST(14),
    NOT_NEW_USER_DF_BLACKLIST(15),
    SAME_ADDR_PHONE(16),
    WELCOME_PKG_INELIGIBLE_DE(17),
    WELCOME_PKG_PREFIX_PH_BL(18),
    REFERRAL_INVALID_VOUCHER(19),
    VOUCHER_UUI(20),
    GROUP_BUY_CHEAT(21),
    SHOPEE_BUDDY_INVALID_VOUCHER(22),
    SHOPEE_BUDDY_INELIGIBLE_DF(23),
    SHOPEE_BUDDY_PREFIX_PH_BLACKLIST(24),
    SHOPEE_BUDDY_LINKAGE(25),
    NEW_FRAUD_SERVER(26),
    DS_VOUCHER_UUI(27);
    
    private final int value;

    private BehaviorFraudReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
