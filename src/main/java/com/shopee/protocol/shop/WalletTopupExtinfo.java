package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WalletTopupExtinfo extends Message {
    public static final Long DEFAULT_ADMIN_FEE = 0L;
    public static final Long DEFAULT_ADMIN_FEE_ID = 0L;
    public static final Long DEFAULT_PAYMENT_CHANNEL_ID = 0L;
    public static final String DEFAULT_PAYMENT_CHANNEL_ITEM_OPTION_INFO = "";
    public static final String DEFAULT_PAYMENT_OPTION_INFO = "";
    public static final Long DEFAULT_PAYMENT_TRANSACTION_ID = 0L;
    public static final String DEFAULT_REMARK = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long admin_fee;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long admin_fee_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long payment_channel_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String payment_channel_item_option_info;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String payment_option_info;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long payment_transaction_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String remark;

    public WalletTopupExtinfo(Long l, Long l2, String str, Long l3, Long l4, String str2, String str3) {
        this.admin_fee_id = l;
        this.admin_fee = l2;
        this.remark = str;
        this.payment_channel_id = l3;
        this.payment_transaction_id = l4;
        this.payment_option_info = str2;
        this.payment_channel_item_option_info = str3;
    }

    private WalletTopupExtinfo(Builder builder) {
        this(builder.admin_fee_id, builder.admin_fee, builder.remark, builder.payment_channel_id, builder.payment_transaction_id, builder.payment_option_info, builder.payment_channel_item_option_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTopupExtinfo)) {
            return false;
        }
        WalletTopupExtinfo walletTopupExtinfo = (WalletTopupExtinfo) obj;
        if (!equals((Object) this.admin_fee_id, (Object) walletTopupExtinfo.admin_fee_id) || !equals((Object) this.admin_fee, (Object) walletTopupExtinfo.admin_fee) || !equals((Object) this.remark, (Object) walletTopupExtinfo.remark) || !equals((Object) this.payment_channel_id, (Object) walletTopupExtinfo.payment_channel_id) || !equals((Object) this.payment_transaction_id, (Object) walletTopupExtinfo.payment_transaction_id) || !equals((Object) this.payment_option_info, (Object) walletTopupExtinfo.payment_option_info) || !equals((Object) this.payment_channel_item_option_info, (Object) walletTopupExtinfo.payment_channel_item_option_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.admin_fee_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.admin_fee;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.remark;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.payment_channel_id;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.payment_transaction_id;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str2 = this.payment_option_info;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.payment_channel_item_option_info;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletTopupExtinfo> {
        public Long admin_fee;
        public Long admin_fee_id;
        public Long payment_channel_id;
        public String payment_channel_item_option_info;
        public String payment_option_info;
        public Long payment_transaction_id;
        public String remark;

        public Builder() {
        }

        public Builder(WalletTopupExtinfo walletTopupExtinfo) {
            super(walletTopupExtinfo);
            if (walletTopupExtinfo != null) {
                this.admin_fee_id = walletTopupExtinfo.admin_fee_id;
                this.admin_fee = walletTopupExtinfo.admin_fee;
                this.remark = walletTopupExtinfo.remark;
                this.payment_channel_id = walletTopupExtinfo.payment_channel_id;
                this.payment_transaction_id = walletTopupExtinfo.payment_transaction_id;
                this.payment_option_info = walletTopupExtinfo.payment_option_info;
                this.payment_channel_item_option_info = walletTopupExtinfo.payment_channel_item_option_info;
            }
        }

        public Builder admin_fee_id(Long l) {
            this.admin_fee_id = l;
            return this;
        }

        public Builder admin_fee(Long l) {
            this.admin_fee = l;
            return this;
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public Builder payment_channel_id(Long l) {
            this.payment_channel_id = l;
            return this;
        }

        public Builder payment_transaction_id(Long l) {
            this.payment_transaction_id = l;
            return this;
        }

        public Builder payment_option_info(String str) {
            this.payment_option_info = str;
            return this;
        }

        public Builder payment_channel_item_option_info(String str) {
            this.payment_channel_item_option_info = str;
            return this;
        }

        public WalletTopupExtinfo build() {
            return new WalletTopupExtinfo(this);
        }
    }
}
