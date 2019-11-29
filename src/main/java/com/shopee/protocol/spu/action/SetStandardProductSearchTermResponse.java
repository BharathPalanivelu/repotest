package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetStandardProductSearchTermResponse extends Message {
    public static final Long DEFAULT_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long id;

    public SetStandardProductSearchTermResponse(ResponseHeader responseHeader, Long l) {
        this.header = responseHeader;
        this.id = l;
    }

    private SetStandardProductSearchTermResponse(Builder builder) {
        this(builder.header, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetStandardProductSearchTermResponse)) {
            return false;
        }
        SetStandardProductSearchTermResponse setStandardProductSearchTermResponse = (SetStandardProductSearchTermResponse) obj;
        if (!equals((Object) this.header, (Object) setStandardProductSearchTermResponse.header) || !equals((Object) this.id, (Object) setStandardProductSearchTermResponse.id)) {
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
        Long l = this.id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetStandardProductSearchTermResponse> {
        public ResponseHeader header;
        public Long id;

        public Builder() {
        }

        public Builder(SetStandardProductSearchTermResponse setStandardProductSearchTermResponse) {
            super(setStandardProductSearchTermResponse);
            if (setStandardProductSearchTermResponse != null) {
                this.header = setStandardProductSearchTermResponse.header;
                this.id = setStandardProductSearchTermResponse.id;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public SetStandardProductSearchTermResponse build() {
            return new SetStandardProductSearchTermResponse(this);
        }
    }
}
