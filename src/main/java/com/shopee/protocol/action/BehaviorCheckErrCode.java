package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum BehaviorCheckErrCode implements ProtoEnum {
    BC_CHECK_NONE(0),
    BC_DEVICE_CHECKOUT_LIMIT(1),
    BC_DEVICE_CHECKOUT_AMOUNT(2),
    BC_DEVICE_BAN(3),
    BC_USER_CHECKOUT_LIMIT(4),
    BC_DEVICE_VOUCHER_LIMIT(5),
    BC_DEEP_GRAPH_FRAUD_CHECK(6),
    BC_REFERRAL_FRAUD(7),
    BC_BLACKLISTED_PHONE_PREFIX(8),
    BC_EXISTING_DF(9),
    BC_GROUP_BUY_FRAUD(10),
    BC_WELCOME_PACKAGE_FRAUD(11),
    BC_VOUCHER_UUI(12),
    BC_JSON_DECODE_ERR(13),
    BC_TONGDUN_ERR(14),
    BC_SHOPEE_BUDDY_FRAUD(15),
    BC_DS_VOUCHER_UUI(16),
    BC_TD_EMULATOR_FRAUD(20),
    BC_TD_VOUCHER_LIMIT(21),
    BC_TD_WELCOME_PACKAGE_FRAUD(22);
    
    private final int value;

    private BehaviorCheckErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
