package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetStandardProductSearchDataResponse extends Message {
    public static final Long DEFAULT_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long id;

    public SetStandardProductSearchDataResponse(ResponseHeader responseHeader, Long l) {
        this.header = responseHeader;
        this.id = l;
    }

    private SetStandardProductSearchDataResponse(Builder builder) {
        this(builder.header, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetStandardProductSearchDataResponse)) {
            return false;
        }
        SetStandardProductSearchDataResponse setStandardProductSearchDataResponse = (SetStandardProductSearchDataResponse) obj;
        if (!equals((Object) this.header, (Object) setStandardProductSearchDataResponse.header) || !equals((Object) this.id, (Object) setStandardProductSearchDataResponse.id)) {
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

    public static final class Builder extends Message.Builder<SetStandardProductSearchDataResponse> {
        public ResponseHeader header;
        public Long id;

        public Builder() {
        }

        public Builder(SetStandardProductSearchDataResponse setStandardProductSearchDataResponse) {
            super(setStandardProductSearchDataResponse);
            if (setStandardProductSearchDataResponse != null) {
                this.header = setStandardProductSearchDataResponse.header;
                this.id = setStandardProductSearchDataResponse.id;
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

        public SetStandardProductSearchDataResponse build() {
            return new SetStandardProductSearchDataResponse(this);
        }
    }
}
