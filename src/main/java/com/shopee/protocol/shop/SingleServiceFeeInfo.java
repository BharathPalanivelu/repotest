package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SingleServiceFeeInfo extends Message {
    public static final Long DEFAULT_FEE_AMOUNT = 0L;
    public static final Integer DEFAULT_RULE_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long fee_amount;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;

    public SingleServiceFeeInfo(Integer num, Long l) {
        this.rule_id = num;
        this.fee_amount = l;
    }

    private SingleServiceFeeInfo(Builder builder) {
        this(builder.rule_id, builder.fee_amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SingleServiceFeeInfo)) {
            return false;
        }
        SingleServiceFeeInfo singleServiceFeeInfo = (SingleServiceFeeInfo) obj;
        if (!equals((Object) this.rule_id, (Object) singleServiceFeeInfo.rule_id) || !equals((Object) this.fee_amount, (Object) singleServiceFeeInfo.fee_amount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.rule_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.fee_amount;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SingleServiceFeeInfo> {
        public Long fee_amount;
        public Integer rule_id;

        public Builder() {
        }

        public Builder(SingleServiceFeeInfo singleServiceFeeInfo) {
            super(singleServiceFeeInfo);
            if (singleServiceFeeInfo != null) {
                this.rule_id = singleServiceFeeInfo.rule_id;
                this.fee_amount = singleServiceFeeInfo.fee_amount;
            }
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public Builder fee_amount(Long l) {
            this.fee_amount = l;
            return this;
        }

        public SingleServiceFeeInfo build() {
            return new SingleServiceFeeInfo(this);
        }
    }
}
