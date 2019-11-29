package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TranslogExtInfo extends Message {
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    public static final String DEFAULT_TOPUP_SIGN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final DeductionInfo deduction_info;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer match_type;
    @ProtoField(tag = 1)
    public final TrackingQuery query;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String topup_sign;

    public TranslogExtInfo(TrackingQuery trackingQuery, String str, DeductionInfo deductionInfo, Integer num) {
        this.query = trackingQuery;
        this.topup_sign = str;
        this.deduction_info = deductionInfo;
        this.match_type = num;
    }

    private TranslogExtInfo(Builder builder) {
        this(builder.query, builder.topup_sign, builder.deduction_info, builder.match_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TranslogExtInfo)) {
            return false;
        }
        TranslogExtInfo translogExtInfo = (TranslogExtInfo) obj;
        if (!equals((Object) this.query, (Object) translogExtInfo.query) || !equals((Object) this.topup_sign, (Object) translogExtInfo.topup_sign) || !equals((Object) this.deduction_info, (Object) translogExtInfo.deduction_info) || !equals((Object) this.match_type, (Object) translogExtInfo.match_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        TrackingQuery trackingQuery = this.query;
        int i2 = 0;
        int hashCode = (trackingQuery != null ? trackingQuery.hashCode() : 0) * 37;
        String str = this.topup_sign;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        DeductionInfo deductionInfo = this.deduction_info;
        int hashCode3 = (hashCode2 + (deductionInfo != null ? deductionInfo.hashCode() : 0)) * 37;
        Integer num = this.match_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TranslogExtInfo> {
        public DeductionInfo deduction_info;
        public Integer match_type;
        public TrackingQuery query;
        public String topup_sign;

        public Builder() {
        }

        public Builder(TranslogExtInfo translogExtInfo) {
            super(translogExtInfo);
            if (translogExtInfo != null) {
                this.query = translogExtInfo.query;
                this.topup_sign = translogExtInfo.topup_sign;
                this.deduction_info = translogExtInfo.deduction_info;
                this.match_type = translogExtInfo.match_type;
            }
        }

        public Builder query(TrackingQuery trackingQuery) {
            this.query = trackingQuery;
            return this;
        }

        public Builder topup_sign(String str) {
            this.topup_sign = str;
            return this;
        }

        public Builder deduction_info(DeductionInfo deductionInfo) {
            this.deduction_info = deductionInfo;
            return this;
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public TranslogExtInfo build() {
            return new TranslogExtInfo(this);
        }
    }
}
