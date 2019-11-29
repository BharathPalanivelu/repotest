package com.airpay.paysdk.base.bean;

import android.text.TextUtils;
import com.airpay.paysdk.base.proto.OrderProto;
import com.facebook.appevents.AppEventsConstants;

public class OrderBuilder {
    private OrderProto.Builder mBuilder;

    public OrderBuilder(OrderProto.Builder builder) {
        this.mBuilder = builder;
    }

    public OrderBuilder buildOrder(BPPaymentOrderInfo bPPaymentOrderInfo, String str, String str2) {
        this.mBuilder.currency(bPPaymentOrderInfo.paymentChannelCurrecy);
        this.mBuilder.payment_channel_id(Integer.valueOf(bPPaymentOrderInfo.paymentChannelId));
        if (!TextUtils.isEmpty(bPPaymentOrderInfo.accountId)) {
            this.mBuilder.payment_account_id(bPPaymentOrderInfo.accountId);
        } else {
            this.mBuilder.payment_account_id("");
        }
        if (!TextUtils.isEmpty(str)) {
            this.mBuilder.payment_channel_txn_id(str);
        } else {
            this.mBuilder.payment_channel_txn_id("");
        }
        this.mBuilder.item_amount(Integer.valueOf(bPPaymentOrderInfo.itemCount));
        this.mBuilder.item_id(bPPaymentOrderInfo.itemId);
        this.mBuilder.payment_payable_amount(Long.valueOf(bPPaymentOrderInfo.paymentPayable));
        if (bPPaymentOrderInfo.eventId != null) {
            this.mBuilder.event_id(bPPaymentOrderInfo.eventId);
        }
        this.mBuilder.extra_data(str2);
        return this;
    }

    public OrderBuilder addTopUpInfo(BPPaymentOrderInfo bPPaymentOrderInfo, long j) {
        this.mBuilder.currency(bPPaymentOrderInfo.paymentChannelCurrecy);
        this.mBuilder.topup_channel_id(Integer.valueOf(bPPaymentOrderInfo.topupChannelId));
        this.mBuilder.currency_amount(Long.valueOf(bPPaymentOrderInfo.currencyAmount));
        this.mBuilder.topup_payable_amount(Long.valueOf(bPPaymentOrderInfo.topupPayable));
        this.mBuilder.topup_cash_amount(Long.valueOf(j));
        if (bPPaymentOrderInfo.bankAccountId != null) {
            this.mBuilder.topup_account_id(String.valueOf(bPPaymentOrderInfo.bankAccountId));
        } else {
            this.mBuilder.topup_account_id(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return this;
    }

    public OrderProto build() {
        return this.mBuilder.build();
    }
}
