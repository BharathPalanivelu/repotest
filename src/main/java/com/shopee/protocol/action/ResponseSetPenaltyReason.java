package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSetPenaltyReason extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_REASON_ID = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer reason_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetPenaltyReason(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.reason_id = num2;
    }

    private ResponseSetPenaltyReason(Builder builder) {
        this(builder.requestid, builder.errcode, builder.reason_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetPenaltyReason)) {
            return false;
        }
        ResponseSetPenaltyReason responseSetPenaltyReason = (ResponseSetPenaltyReason) obj;
        if (!equals((Object) this.requestid, (Object) responseSetPenaltyReason.requestid) || !equals((Object) this.errcode, (Object) responseSetPenaltyReason.errcode) || !equals((Object) this.reason_id, (Object) responseSetPenaltyReason.reason_id)) {
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
        Integer num2 = this.reason_id;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSetPenaltyReason> {
        public Integer errcode;
        public Integer reason_id;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetPenaltyReason responseSetPenaltyReason) {
            super(responseSetPenaltyReason);
            if (responseSetPenaltyReason != null) {
                this.requestid = responseSetPenaltyReason.requestid;
                this.errcode = responseSetPenaltyReason.errcode;
                this.reason_id = responseSetPenaltyReason.reason_id;
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

        public Builder reason_id(Integer num) {
            this.reason_id = num;
            return this;
        }

        public ResponseSetPenaltyReason build() {
            return new ResponseSetPenaltyReason(this);
        }
    }
}
