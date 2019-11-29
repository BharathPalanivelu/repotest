package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseGetAlgo extends Message {
    public static final String DEFAULT_ALGORITHMS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String algorithms;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public ResponseGetAlgo(ResponseHeader responseHeader, String str) {
        this.header = responseHeader;
        this.algorithms = str;
    }

    private ResponseGetAlgo(Builder builder) {
        this(builder.header, builder.algorithms);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetAlgo)) {
            return false;
        }
        ResponseGetAlgo responseGetAlgo = (ResponseGetAlgo) obj;
        if (!equals((Object) this.header, (Object) responseGetAlgo.header) || !equals((Object) this.algorithms, (Object) responseGetAlgo.algorithms)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        String str = this.algorithms;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetAlgo> {
        public String algorithms;
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(ResponseGetAlgo responseGetAlgo) {
            super(responseGetAlgo);
            if (responseGetAlgo != null) {
                this.header = responseGetAlgo.header;
                this.algorithms = responseGetAlgo.algorithms;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder algorithms(String str) {
            this.algorithms = str;
            return this;
        }

        public ResponseGetAlgo build() {
            return new ResponseGetAlgo(this);
        }
    }
}
