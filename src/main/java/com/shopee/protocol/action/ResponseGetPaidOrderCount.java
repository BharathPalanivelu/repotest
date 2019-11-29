package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseGetPaidOrderCount extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetPaidOrderCount(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.count = num2;
    }

    private ResponseGetPaidOrderCount(Builder builder) {
        this(builder.requestid, builder.errcode, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetPaidOrderCount)) {
            return false;
        }
        ResponseGetPaidOrderCount responseGetPaidOrderCount = (ResponseGetPaidOrderCount) obj;
        if (!equals((Object) this.requestid, (Object) responseGetPaidOrderCount.requestid) || !equals((Object) this.errcode, (Object) responseGetPaidOrderCount.errcode) || !equals((Object) this.count, (Object) responseGetPaidOrderCount.count)) {
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
        Integer num2 = this.count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetPaidOrderCount> {
        public Integer count;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetPaidOrderCount responseGetPaidOrderCount) {
            super(responseGetPaidOrderCount);
            if (responseGetPaidOrderCount != null) {
                this.requestid = responseGetPaidOrderCount.requestid;
                this.errcode = responseGetPaidOrderCount.errcode;
                this.count = responseGetPaidOrderCount.count;
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

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public ResponseGetPaidOrderCount build() {
            return new ResponseGetPaidOrderCount(this);
        }
    }
}
