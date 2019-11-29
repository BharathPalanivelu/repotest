package com.airpay.paysdk.base.bean;

import com.airpay.paysdk.base.proto.ChannelInfoProto;
import com.airpay.paysdk.core.bean.ChannelInfo;

public class BPPaymentOrderInfo {
    public String accountId;
    public Long bankAccountId;
    public long currencyAmount;
    public Long eventId;
    public int itemCount;
    public String itemId;
    public String paymentChannelCurrecy;
    public int paymentChannelId;
    public long paymentPayable;
    public int topupChannelId;
    public long topupPayable;

    public BPPaymentOrderInfo(String str, int i, ChannelInfoProto channelInfoProto, String str2) {
        this.itemId = str;
        this.itemCount = i;
        this.paymentChannelCurrecy = channelInfoProto.currency;
        this.paymentChannelId = channelInfoProto.channel_id.intValue();
        this.accountId = str2;
    }

    public BPPaymentOrderInfo(String str, int i, ChannelInfo channelInfo, String str2) {
        this.itemId = str;
        this.itemCount = i;
        this.paymentChannelCurrecy = channelInfo.c();
        this.paymentChannelId = channelInfo.a();
        this.accountId = str2;
    }

    public BPPaymentOrderInfo(String str, int i, String str2, int i2, int i3) {
        this.itemId = str;
        this.itemCount = i;
        this.paymentChannelCurrecy = str2;
        this.paymentChannelId = i2;
        this.topupChannelId = i3;
    }

    public BPPaymentOrderInfo(BPTopupChannelWithEvents bPTopupChannelWithEvents, String str, int i, ChannelInfo channelInfo, String str2) {
        this.itemId = str;
        this.itemCount = i;
        this.paymentChannelCurrecy = channelInfo.c();
        this.paymentChannelId = channelInfo.a();
        this.topupChannelId = bPTopupChannelWithEvents.getBankAccountInfo().a();
        this.paymentPayable = bPTopupChannelWithEvents.getTopupAmountInfo().paymentPayable;
        this.currencyAmount = bPTopupChannelWithEvents.getTopupAmountInfo().currencyAmount;
        this.topupPayable = bPTopupChannelWithEvents.getTopupAmountInfo().topupPayment;
        this.accountId = str2;
        Long l = null;
        this.eventId = bPTopupChannelWithEvents.getEvent() != null ? Long.valueOf(bPTopupChannelWithEvents.getEvent().getEventId()) : null;
        this.bankAccountId = bPTopupChannelWithEvents.getBankAccountInfo().d() != null ? Long.valueOf(bPTopupChannelWithEvents.getBankAccountInfo().d().f4355a) : l;
    }

    public BPPaymentOrderInfo(BPThirdPartyOrderDetail bPThirdPartyOrderDetail) {
        this.itemId = bPThirdPartyOrderDetail.getItemId();
        this.itemCount = bPThirdPartyOrderDetail.getItemAmount();
        this.paymentChannelId = bPThirdPartyOrderDetail.getAppId();
        this.paymentChannelCurrecy = bPThirdPartyOrderDetail.getCurrency();
        this.accountId = bPThirdPartyOrderDetail.getAccountId();
    }

    public BPPaymentOrderInfo(BPTopupChannelWithEvents bPTopupChannelWithEvents, BPThirdPartyOrderDetail bPThirdPartyOrderDetail) {
        this(bPThirdPartyOrderDetail);
        this.topupChannelId = bPTopupChannelWithEvents.getBankAccountInfo().a();
        this.paymentPayable = bPTopupChannelWithEvents.getTopupAmountInfo().paymentPayable;
        this.currencyAmount = bPTopupChannelWithEvents.getTopupAmountInfo().currencyAmount;
        this.topupPayable = bPTopupChannelWithEvents.getTopupAmountInfo().topupPayment;
        Long l = null;
        this.eventId = bPTopupChannelWithEvents.getEvent() != null ? Long.valueOf(bPTopupChannelWithEvents.getEvent().getEventId()) : null;
        this.bankAccountId = bPTopupChannelWithEvents.getBankAccountInfo().d() != null ? Long.valueOf(bPTopupChannelWithEvents.getBankAccountInfo().d().f4355a) : l;
    }
}
