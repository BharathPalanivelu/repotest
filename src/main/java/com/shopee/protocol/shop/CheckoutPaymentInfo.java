package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckoutPaymentInfo extends Message {
    public static final String DEFAULT_BANK_TRANSFER_BANK = "";
    public static final Integer DEFAULT_BANK_TRANSFER_OPTION = 0;
    public static final Integer DEFAULT_CHANNELID = 0;
    public static final String DEFAULT_CHANNEL_ITEM_OPTION_INFO = "";
    public static final String DEFAULT_OPTION_INFO = "";
    public static final Long DEFAULT_PAYMENT_FLAG = 0L;
    public static final Long DEFAULT_SPM_CHANNEL_ID = 0L;
    public static final Long DEFAULT_TRANSACTION_ID = 0L;
    public static final Integer DEFAULT_VOUCHER_PAYMENT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String bank_transfer_bank;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer bank_transfer_option;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String channel_item_option_info;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer channelid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String option_info;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long payment_flag;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long spm_channel_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long transaction_id;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer voucher_payment_type;

    public CheckoutPaymentInfo(Integer num, String str, Integer num2, Long l, String str2, Long l2, Long l3, String str3, Integer num3) {
        this.bank_transfer_option = num;
        this.bank_transfer_bank = str;
        this.channelid = num2;
        this.payment_flag = l;
        this.option_info = str2;
        this.transaction_id = l2;
        this.spm_channel_id = l3;
        this.channel_item_option_info = str3;
        this.voucher_payment_type = num3;
    }

    private CheckoutPaymentInfo(Builder builder) {
        this(builder.bank_transfer_option, builder.bank_transfer_bank, builder.channelid, builder.payment_flag, builder.option_info, builder.transaction_id, builder.spm_channel_id, builder.channel_item_option_info, builder.voucher_payment_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutPaymentInfo)) {
            return false;
        }
        CheckoutPaymentInfo checkoutPaymentInfo = (CheckoutPaymentInfo) obj;
        if (!equals((Object) this.bank_transfer_option, (Object) checkoutPaymentInfo.bank_transfer_option) || !equals((Object) this.bank_transfer_bank, (Object) checkoutPaymentInfo.bank_transfer_bank) || !equals((Object) this.channelid, (Object) checkoutPaymentInfo.channelid) || !equals((Object) this.payment_flag, (Object) checkoutPaymentInfo.payment_flag) || !equals((Object) this.option_info, (Object) checkoutPaymentInfo.option_info) || !equals((Object) this.transaction_id, (Object) checkoutPaymentInfo.transaction_id) || !equals((Object) this.spm_channel_id, (Object) checkoutPaymentInfo.spm_channel_id) || !equals((Object) this.channel_item_option_info, (Object) checkoutPaymentInfo.channel_item_option_info) || !equals((Object) this.voucher_payment_type, (Object) checkoutPaymentInfo.voucher_payment_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.bank_transfer_option;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.bank_transfer_bank;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.channelid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.payment_flag;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.option_info;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.transaction_id;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.spm_channel_id;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str3 = this.channel_item_option_info;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num3 = this.voucher_payment_type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutPaymentInfo> {
        public String bank_transfer_bank;
        public Integer bank_transfer_option;
        public String channel_item_option_info;
        public Integer channelid;
        public String option_info;
        public Long payment_flag;
        public Long spm_channel_id;
        public Long transaction_id;
        public Integer voucher_payment_type;

        public Builder() {
        }

        public Builder(CheckoutPaymentInfo checkoutPaymentInfo) {
            super(checkoutPaymentInfo);
            if (checkoutPaymentInfo != null) {
                this.bank_transfer_option = checkoutPaymentInfo.bank_transfer_option;
                this.bank_transfer_bank = checkoutPaymentInfo.bank_transfer_bank;
                this.channelid = checkoutPaymentInfo.channelid;
                this.payment_flag = checkoutPaymentInfo.payment_flag;
                this.option_info = checkoutPaymentInfo.option_info;
                this.transaction_id = checkoutPaymentInfo.transaction_id;
                this.spm_channel_id = checkoutPaymentInfo.spm_channel_id;
                this.channel_item_option_info = checkoutPaymentInfo.channel_item_option_info;
                this.voucher_payment_type = checkoutPaymentInfo.voucher_payment_type;
            }
        }

        public Builder bank_transfer_option(Integer num) {
            this.bank_transfer_option = num;
            return this;
        }

        public Builder bank_transfer_bank(String str) {
            this.bank_transfer_bank = str;
            return this;
        }

        public Builder channelid(Integer num) {
            this.channelid = num;
            return this;
        }

        public Builder payment_flag(Long l) {
            this.payment_flag = l;
            return this;
        }

        public Builder option_info(String str) {
            this.option_info = str;
            return this;
        }

        public Builder transaction_id(Long l) {
            this.transaction_id = l;
            return this;
        }

        public Builder spm_channel_id(Long l) {
            this.spm_channel_id = l;
            return this;
        }

        public Builder channel_item_option_info(String str) {
            this.channel_item_option_info = str;
            return this;
        }

        public Builder voucher_payment_type(Integer num) {
            this.voucher_payment_type = num;
            return this;
        }

        public CheckoutPaymentInfo build() {
            return new CheckoutPaymentInfo(this);
        }
    }
}
