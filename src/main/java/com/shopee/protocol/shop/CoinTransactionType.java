package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CoinTransactionType implements ProtoEnum {
    EARN_COMPLETE_ORDER(1),
    EARN_CANCEL_ESCROW(2),
    SPEND_CREATE_ORDER(3),
    SPEND_INVALID_ORDER(4),
    SPEND_CANCEL_ORDER(5),
    SPEND_RETURN_ORDER(6),
    EXPIRE(7),
    ADMIN_UPDATE(8),
    REWARD(9),
    TOKEN(10),
    REFERRAL_COIN(11),
    REDEEM_VOUCHER(12),
    DP_CREATE_ORDER(13),
    DP_CANEL_ORDER(14),
    DP_COMPLETED_ORDER(15),
    RATE_ORDER_COIN(16),
    SLASH_PRICE_COIN(17),
    RATE_ORDER_COIN_RETRIEVED(18),
    SPEND_CANCEL_PARCEL(19),
    FOODY_COMPLETED_ORDER(20),
    FOODY_REDEEM_VOUCHER(21),
    FOODY_MANUAL_UPDATE(22),
    AIRPAY_CREATE_TXN(23),
    AIRPAY_CANCEL_TXN(24),
    AIRPAY_REFUND_TXN(25),
    AIRPAY_COMPLETED_TXN(26),
    AIRPAY_REWARDS(27);
    
    private final int value;

    private CoinTransactionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
