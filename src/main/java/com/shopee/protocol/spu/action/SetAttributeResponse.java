package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAttributeResponse extends Message {
    public static final Long DEFAULT_ATTRID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long attrid;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public SetAttributeResponse(ResponseHeader responseHeader, Long l) {
        this.header = responseHeader;
        this.attrid = l;
    }

    private SetAttributeResponse(Builder builder) {
        this(builder.header, builder.attrid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAttributeResponse)) {
            return false;
        }
        SetAttributeResponse setAttributeResponse = (SetAttributeResponse) obj;
        if (!equals((Object) this.header, (Object) setAttributeResponse.header) || !equals((Object) this.attrid, (Object) setAttributeResponse.attrid)) {
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
        Long l = this.attrid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAttributeResponse> {
        public Long attrid;
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(SetAttributeResponse setAttributeResponse) {
            super(setAttributeResponse);
            if (setAttributeResponse != null) {
                this.header = setAttributeResponse.header;
                this.attrid = setAttributeResponse.attrid;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder attrid(Long l) {
            this.attrid = l;
            return this;
        }

        public SetAttributeResponse build() {
            return new SetAttributeResponse(this);
        }
    }
}
