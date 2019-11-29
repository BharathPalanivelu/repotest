package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestHeader extends Message {
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SOURCE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer source;

    public RequestHeader(String str, String str2, Integer num) {
        this.requestid = str;
        this.operator = str2;
        this.source = num;
    }

    private RequestHeader(Builder builder) {
        this(builder.requestid, builder.operator, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestHeader)) {
            return false;
        }
        RequestHeader requestHeader = (RequestHeader) obj;
        if (!equals((Object) this.requestid, (Object) requestHeader.requestid) || !equals((Object) this.operator, (Object) requestHeader.operator) || !equals((Object) this.source, (Object) requestHeader.source)) {
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
        String str2 = this.operator;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.source;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestHeader> {
        public String operator;
        public String requestid;
        public Integer source;

        public Builder() {
        }

        public Builder(RequestHeader requestHeader) {
            super(requestHeader);
            if (requestHeader != null) {
                this.requestid = requestHeader.requestid;
                this.operator = requestHeader.operator;
                this.source = requestHeader.source;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public RequestHeader build() {
            return new RequestHeader(this);
        }
    }
}
