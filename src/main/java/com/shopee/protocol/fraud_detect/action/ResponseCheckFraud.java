package com.shopee.protocol.fraud_detect.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCheckFraud extends Message {
    public static final Integer DEFAULT_FRAUD_TYPES = 0;
    public static final Boolean DEFAULT_IS_FRAUD = false;
    public static final String DEFAULT_REASON = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SELLERID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer fraud_types;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean is_fraud;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String sellerid;

    public ResponseCheckFraud(String str, Boolean bool, String str2, String str3, Integer num) {
        this.requestid = str;
        this.is_fraud = bool;
        this.reason = str2;
        this.sellerid = str3;
        this.fraud_types = num;
    }

    private ResponseCheckFraud(Builder builder) {
        this(builder.requestid, builder.is_fraud, builder.reason, builder.sellerid, builder.fraud_types);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCheckFraud)) {
            return false;
        }
        ResponseCheckFraud responseCheckFraud = (ResponseCheckFraud) obj;
        if (!equals((Object) this.requestid, (Object) responseCheckFraud.requestid) || !equals((Object) this.is_fraud, (Object) responseCheckFraud.is_fraud) || !equals((Object) this.reason, (Object) responseCheckFraud.reason) || !equals((Object) this.sellerid, (Object) responseCheckFraud.sellerid) || !equals((Object) this.fraud_types, (Object) responseCheckFraud.fraud_types)) {
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
        Boolean bool = this.is_fraud;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.reason;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.sellerid;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.fraud_types;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCheckFraud> {
        public Integer fraud_types;
        public Boolean is_fraud;
        public String reason;
        public String requestid;
        public String sellerid;

        public Builder() {
        }

        public Builder(ResponseCheckFraud responseCheckFraud) {
            super(responseCheckFraud);
            if (responseCheckFraud != null) {
                this.requestid = responseCheckFraud.requestid;
                this.is_fraud = responseCheckFraud.is_fraud;
                this.reason = responseCheckFraud.reason;
                this.sellerid = responseCheckFraud.sellerid;
                this.fraud_types = responseCheckFraud.fraud_types;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder is_fraud(Boolean bool) {
            this.is_fraud = bool;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder sellerid(String str) {
            this.sellerid = str;
            return this;
        }

        public Builder fraud_types(Integer num) {
            this.fraud_types = num;
            return this;
        }

        public ResponseCheckFraud build() {
            return new ResponseCheckFraud(this);
        }
    }
}
