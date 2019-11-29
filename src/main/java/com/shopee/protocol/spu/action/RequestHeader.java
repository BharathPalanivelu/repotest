package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestHeader extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public RequestHeader(String str) {
        this.requestid = str;
    }

    private RequestHeader(Builder builder) {
        this(builder.requestid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestHeader)) {
            return false;
        }
        return equals((Object) this.requestid, (Object) ((RequestHeader) obj).requestid);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.requestid;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<RequestHeader> {
        public String requestid;

        public Builder() {
        }

        public Builder(RequestHeader requestHeader) {
            super(requestHeader);
            if (requestHeader != null) {
                this.requestid = requestHeader.requestid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public RequestHeader build() {
            return new RequestHeader(this);
        }
    }
}
