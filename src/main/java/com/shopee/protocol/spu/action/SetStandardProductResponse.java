package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetStandardProductResponse extends Message {
    public static final Long DEFAULT_SPUID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long spuid;

    public SetStandardProductResponse(ResponseHeader responseHeader, Long l) {
        this.header = responseHeader;
        this.spuid = l;
    }

    private SetStandardProductResponse(Builder builder) {
        this(builder.header, builder.spuid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetStandardProductResponse)) {
            return false;
        }
        SetStandardProductResponse setStandardProductResponse = (SetStandardProductResponse) obj;
        if (!equals((Object) this.header, (Object) setStandardProductResponse.header) || !equals((Object) this.spuid, (Object) setStandardProductResponse.spuid)) {
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
        Long l = this.spuid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetStandardProductResponse> {
        public ResponseHeader header;
        public Long spuid;

        public Builder() {
        }

        public Builder(SetStandardProductResponse setStandardProductResponse) {
            super(setStandardProductResponse);
            if (setStandardProductResponse != null) {
                this.header = setStandardProductResponse.header;
                this.spuid = setStandardProductResponse.spuid;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder spuid(Long l) {
            this.spuid = l;
            return this;
        }

        public SetStandardProductResponse build() {
            return new SetStandardProductResponse(this);
        }
    }
}
