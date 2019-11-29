package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TxnFeeCustomisedSetting extends Message {
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_ID = 0;
    public static final String DEFAULT_OPTION_INFO = "";
    public static final Integer DEFAULT_PAYMENT_CHANNEL_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer logistics_channel_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String option_info;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer payment_channel_id;

    public TxnFeeCustomisedSetting(Integer num, Integer num2, String str) {
        this.payment_channel_id = num;
        this.logistics_channel_id = num2;
        this.option_info = str;
    }

    private TxnFeeCustomisedSetting(Builder builder) {
        this(builder.payment_channel_id, builder.logistics_channel_id, builder.option_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TxnFeeCustomisedSetting)) {
            return false;
        }
        TxnFeeCustomisedSetting txnFeeCustomisedSetting = (TxnFeeCustomisedSetting) obj;
        if (!equals((Object) this.payment_channel_id, (Object) txnFeeCustomisedSetting.payment_channel_id) || !equals((Object) this.logistics_channel_id, (Object) txnFeeCustomisedSetting.logistics_channel_id) || !equals((Object) this.option_info, (Object) txnFeeCustomisedSetting.option_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.payment_channel_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.logistics_channel_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.option_info;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TxnFeeCustomisedSetting> {
        public Integer logistics_channel_id;
        public String option_info;
        public Integer payment_channel_id;

        public Builder() {
        }

        public Builder(TxnFeeCustomisedSetting txnFeeCustomisedSetting) {
            super(txnFeeCustomisedSetting);
            if (txnFeeCustomisedSetting != null) {
                this.payment_channel_id = txnFeeCustomisedSetting.payment_channel_id;
                this.logistics_channel_id = txnFeeCustomisedSetting.logistics_channel_id;
                this.option_info = txnFeeCustomisedSetting.option_info;
            }
        }

        public Builder payment_channel_id(Integer num) {
            this.payment_channel_id = num;
            return this;
        }

        public Builder logistics_channel_id(Integer num) {
            this.logistics_channel_id = num;
            return this;
        }

        public Builder option_info(String str) {
            this.option_info = str;
            return this;
        }

        public TxnFeeCustomisedSetting build() {
            return new TxnFeeCustomisedSetting(this);
        }
    }
}
