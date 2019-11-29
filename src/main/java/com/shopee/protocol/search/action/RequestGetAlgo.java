package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestGetAlgo extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public RequestGetAlgo(RequestHeader requestHeader) {
        this.header = requestHeader;
    }

    private RequestGetAlgo(Builder builder) {
        this(builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestGetAlgo)) {
            return false;
        }
        return equals((Object) this.header, (Object) ((RequestGetAlgo) obj).header);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            RequestHeader requestHeader = this.header;
            i = requestHeader != null ? requestHeader.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<RequestGetAlgo> {
        public RequestHeader header;

        public Builder() {
        }

        public Builder(RequestGetAlgo requestGetAlgo) {
            super(requestGetAlgo);
            if (requestGetAlgo != null) {
                this.header = requestGetAlgo.header;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public RequestGetAlgo build() {
            return new RequestGetAlgo(this);
        }
    }
}
