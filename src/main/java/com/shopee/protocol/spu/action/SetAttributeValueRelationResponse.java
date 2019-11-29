package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAttributeValueRelationResponse extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public SetAttributeValueRelationResponse(ResponseHeader responseHeader) {
        this.header = responseHeader;
    }

    private SetAttributeValueRelationResponse(Builder builder) {
        this(builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAttributeValueRelationResponse)) {
            return false;
        }
        return equals((Object) this.header, (Object) ((SetAttributeValueRelationResponse) obj).header);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ResponseHeader responseHeader = this.header;
            i = responseHeader != null ? responseHeader.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SetAttributeValueRelationResponse> {
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(SetAttributeValueRelationResponse setAttributeValueRelationResponse) {
            super(setAttributeValueRelationResponse);
            if (setAttributeValueRelationResponse != null) {
                this.header = setAttributeValueRelationResponse.header;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public SetAttributeValueRelationResponse build() {
            return new SetAttributeValueRelationResponse(this);
        }
    }
}
