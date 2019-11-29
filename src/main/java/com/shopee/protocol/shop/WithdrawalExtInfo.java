package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class WithdrawalExtInfo extends Message {
    public static final Integer DEFAULT_BATCHID = 0;
    public static final String DEFAULT_CANCEL_REASON = "";
    public static final Integer DEFAULT_CANCEL_TIME = 0;
    public static final Integer DEFAULT_COMPLETE_TIME = 0;
    public static final Integer DEFAULT_DUE_TIME = 0;
    public static final String DEFAULT_PAYMENT_REF1 = "";
    public static final Integer DEFAULT_PAYOUT_TIME = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final List<Long> DEFAULT_SUB_ID = Collections.emptyList();
    public static final Long DEFAULT_TRANSACTION_ID = 0L;
    public static final Integer DEFAULT_VERIFY_TIME = 0;
    public static final Integer DEFAULT_WALLET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer batchid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String cancel_reason;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer cancel_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer complete_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer due_time;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String payment_ref1;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer payout_time;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> sub_id;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long transaction_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer verify_time;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer wallet_type;

    public WithdrawalExtInfo(List<Long> list, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str, String str2, Long l, Integer num8) {
        this.sub_id = immutableCopyOf(list);
        this.batchid = num;
        this.source = num2;
        this.due_time = num3;
        this.verify_time = num4;
        this.payout_time = num5;
        this.complete_time = num6;
        this.cancel_time = num7;
        this.cancel_reason = str;
        this.payment_ref1 = str2;
        this.transaction_id = l;
        this.wallet_type = num8;
    }

    private WithdrawalExtInfo(Builder builder) {
        this(builder.sub_id, builder.batchid, builder.source, builder.due_time, builder.verify_time, builder.payout_time, builder.complete_time, builder.cancel_time, builder.cancel_reason, builder.payment_ref1, builder.transaction_id, builder.wallet_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WithdrawalExtInfo)) {
            return false;
        }
        WithdrawalExtInfo withdrawalExtInfo = (WithdrawalExtInfo) obj;
        if (!equals((List<?>) this.sub_id, (List<?>) withdrawalExtInfo.sub_id) || !equals((Object) this.batchid, (Object) withdrawalExtInfo.batchid) || !equals((Object) this.source, (Object) withdrawalExtInfo.source) || !equals((Object) this.due_time, (Object) withdrawalExtInfo.due_time) || !equals((Object) this.verify_time, (Object) withdrawalExtInfo.verify_time) || !equals((Object) this.payout_time, (Object) withdrawalExtInfo.payout_time) || !equals((Object) this.complete_time, (Object) withdrawalExtInfo.complete_time) || !equals((Object) this.cancel_time, (Object) withdrawalExtInfo.cancel_time) || !equals((Object) this.cancel_reason, (Object) withdrawalExtInfo.cancel_reason) || !equals((Object) this.payment_ref1, (Object) withdrawalExtInfo.payment_ref1) || !equals((Object) this.transaction_id, (Object) withdrawalExtInfo.transaction_id) || !equals((Object) this.wallet_type, (Object) withdrawalExtInfo.wallet_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.sub_id;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.batchid;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.source;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.due_time;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.verify_time;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.payout_time;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.complete_time;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.cancel_time;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str = this.cancel_reason;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.payment_ref1;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.transaction_id;
        int hashCode11 = (hashCode10 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num8 = this.wallet_type;
        if (num8 != null) {
            i2 = num8.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WithdrawalExtInfo> {
        public Integer batchid;
        public String cancel_reason;
        public Integer cancel_time;
        public Integer complete_time;
        public Integer due_time;
        public String payment_ref1;
        public Integer payout_time;
        public Integer source;
        public List<Long> sub_id;
        public Long transaction_id;
        public Integer verify_time;
        public Integer wallet_type;

        public Builder() {
        }

        public Builder(WithdrawalExtInfo withdrawalExtInfo) {
            super(withdrawalExtInfo);
            if (withdrawalExtInfo != null) {
                this.sub_id = WithdrawalExtInfo.copyOf(withdrawalExtInfo.sub_id);
                this.batchid = withdrawalExtInfo.batchid;
                this.source = withdrawalExtInfo.source;
                this.due_time = withdrawalExtInfo.due_time;
                this.verify_time = withdrawalExtInfo.verify_time;
                this.payout_time = withdrawalExtInfo.payout_time;
                this.complete_time = withdrawalExtInfo.complete_time;
                this.cancel_time = withdrawalExtInfo.cancel_time;
                this.cancel_reason = withdrawalExtInfo.cancel_reason;
                this.payment_ref1 = withdrawalExtInfo.payment_ref1;
                this.transaction_id = withdrawalExtInfo.transaction_id;
                this.wallet_type = withdrawalExtInfo.wallet_type;
            }
        }

        public Builder sub_id(List<Long> list) {
            this.sub_id = checkForNulls(list);
            return this;
        }

        public Builder batchid(Integer num) {
            this.batchid = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder due_time(Integer num) {
            this.due_time = num;
            return this;
        }

        public Builder verify_time(Integer num) {
            this.verify_time = num;
            return this;
        }

        public Builder payout_time(Integer num) {
            this.payout_time = num;
            return this;
        }

        public Builder complete_time(Integer num) {
            this.complete_time = num;
            return this;
        }

        public Builder cancel_time(Integer num) {
            this.cancel_time = num;
            return this;
        }

        public Builder cancel_reason(String str) {
            this.cancel_reason = str;
            return this;
        }

        public Builder payment_ref1(String str) {
            this.payment_ref1 = str;
            return this;
        }

        public Builder transaction_id(Long l) {
            this.transaction_id = l;
            return this;
        }

        public Builder wallet_type(Integer num) {
            this.wallet_type = num;
            return this;
        }

        public WithdrawalExtInfo build() {
            return new WithdrawalExtInfo(this);
        }
    }
}
