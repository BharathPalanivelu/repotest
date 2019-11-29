package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetRootAttributeResponse extends Message {
    public static final Long DEFAULT_ATTRID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long attrid;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public SetRootAttributeResponse(ResponseHeader responseHeader, Long l) {
        this.header = responseHeader;
        this.attrid = l;
    }

    private SetRootAttributeResponse(Builder builder) {
        this(builder.header, builder.attrid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetRootAttributeResponse)) {
            return false;
        }
        SetRootAttributeResponse setRootAttributeResponse = (SetRootAttributeResponse) obj;
        if (!equals((Object) this.header, (Object) setRootAttributeResponse.header) || !equals((Object) this.attrid, (Object) setRootAttributeResponse.attrid)) {
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

    public static final class Builder extends Message.Builder<SetRootAttributeResponse> {
        public Long attrid;
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(SetRootAttributeResponse setRootAttributeResponse) {
            super(setRootAttributeResponse);
            if (setRootAttributeResponse != null) {
                this.header = setRootAttributeResponse.header;
                this.attrid = setRootAttributeResponse.attrid;
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

        public SetRootAttributeResponse build() {
            return new SetRootAttributeResponse(this);
        }
    }
}
