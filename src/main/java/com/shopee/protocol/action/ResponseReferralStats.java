package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseReferralStats extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_REMAINING_SLOT = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer remaining_slot;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseReferralStats(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.remaining_slot = num2;
    }

    private ResponseReferralStats(Builder builder) {
        this(builder.requestid, builder.errcode, builder.remaining_slot);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseReferralStats)) {
            return false;
        }
        ResponseReferralStats responseReferralStats = (ResponseReferralStats) obj;
        if (!equals((Object) this.requestid, (Object) responseReferralStats.requestid) || !equals((Object) this.errcode, (Object) responseReferralStats.errcode) || !equals((Object) this.remaining_slot, (Object) responseReferralStats.remaining_slot)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.remaining_slot;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseReferralStats> {
        public Integer errcode;
        public Integer remaining_slot;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseReferralStats responseReferralStats) {
            super(responseReferralStats);
            if (responseReferralStats != null) {
                this.requestid = responseReferralStats.requestid;
                this.errcode = responseReferralStats.errcode;
                this.remaining_slot = responseReferralStats.remaining_slot;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder remaining_slot(Integer num) {
            this.remaining_slot = num;
            return this;
        }

        public ResponseReferralStats build() {
            return new ResponseReferralStats(this);
        }
    }
}
