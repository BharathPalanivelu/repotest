package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseHeader extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseHeader(String str, Integer num) {
        this.requestid = str;
        this.errcode = num;
    }

    private ResponseHeader(Builder builder) {
        this(builder.requestid, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseHeader)) {
            return false;
        }
        ResponseHeader responseHeader = (ResponseHeader) obj;
        if (!equals((Object) this.requestid, (Object) responseHeader.requestid) || !equals((Object) this.errcode, (Object) responseHeader.errcode)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseHeader> {
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseHeader responseHeader) {
            super(responseHeader);
            if (responseHeader != null) {
                this.requestid = responseHeader.requestid;
                this.errcode = responseHeader.errcode;
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

        public ResponseHeader build() {
            return new ResponseHeader(this);
        }
    }
}
