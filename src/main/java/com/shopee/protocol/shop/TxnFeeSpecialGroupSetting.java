package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TxnFeeSpecialGroupSetting extends Message {
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_ID = 0;
    public static final String DEFAULT_OPTION_INFO = "";
    public static final Integer DEFAULT_PAYMENT_CHANNEL_ID = 0;
    public static final Integer DEFAULT_PRIORITY = 0;
    public static final Integer DEFAULT_SPECIAL_GROUP_ID = 0;
    public static final Long DEFAULT_SPM_PAYMENT_CHANNEL_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer logistics_channel_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String option_info;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer payment_channel_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer priority;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer special_group_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long spm_payment_channel_id;

    public TxnFeeSpecialGroupSetting(Integer num, Integer num2, Integer num3, String str, Long l, Integer num4) {
        this.special_group_id = num;
        this.payment_channel_id = num2;
        this.logistics_channel_id = num3;
        this.option_info = str;
        this.spm_payment_channel_id = l;
        this.priority = num4;
    }

    private TxnFeeSpecialGroupSetting(Builder builder) {
        this(builder.special_group_id, builder.payment_channel_id, builder.logistics_channel_id, builder.option_info, builder.spm_payment_channel_id, builder.priority);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TxnFeeSpecialGroupSetting)) {
            return false;
        }
        TxnFeeSpecialGroupSetting txnFeeSpecialGroupSetting = (TxnFeeSpecialGroupSetting) obj;
        if (!equals((Object) this.special_group_id, (Object) txnFeeSpecialGroupSetting.special_group_id) || !equals((Object) this.payment_channel_id, (Object) txnFeeSpecialGroupSetting.payment_channel_id) || !equals((Object) this.logistics_channel_id, (Object) txnFeeSpecialGroupSetting.logistics_channel_id) || !equals((Object) this.option_info, (Object) txnFeeSpecialGroupSetting.option_info) || !equals((Object) this.spm_payment_channel_id, (Object) txnFeeSpecialGroupSetting.spm_payment_channel_id) || !equals((Object) this.priority, (Object) txnFeeSpecialGroupSetting.priority)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.special_group_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.payment_channel_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.logistics_channel_id;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.option_info;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.spm_payment_channel_id;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num4 = this.priority;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TxnFeeSpecialGroupSetting> {
        public Integer logistics_channel_id;
        public String option_info;
        public Integer payment_channel_id;
        public Integer priority;
        public Integer special_group_id;
        public Long spm_payment_channel_id;

        public Builder() {
        }

        public Builder(TxnFeeSpecialGroupSetting txnFeeSpecialGroupSetting) {
            super(txnFeeSpecialGroupSetting);
            if (txnFeeSpecialGroupSetting != null) {
                this.special_group_id = txnFeeSpecialGroupSetting.special_group_id;
                this.payment_channel_id = txnFeeSpecialGroupSetting.payment_channel_id;
                this.logistics_channel_id = txnFeeSpecialGroupSetting.logistics_channel_id;
                this.option_info = txnFeeSpecialGroupSetting.option_info;
                this.spm_payment_channel_id = txnFeeSpecialGroupSetting.spm_payment_channel_id;
                this.priority = txnFeeSpecialGroupSetting.priority;
            }
        }

        public Builder special_group_id(Integer num) {
            this.special_group_id = num;
            return this;
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

        public Builder spm_payment_channel_id(Long l) {
            this.spm_payment_channel_id = l;
            return this;
        }

        public Builder priority(Integer num) {
            this.priority = num;
            return this;
        }

        public TxnFeeSpecialGroupSetting build() {
            return new TxnFeeSpecialGroupSetting(this);
        }
    }
}
