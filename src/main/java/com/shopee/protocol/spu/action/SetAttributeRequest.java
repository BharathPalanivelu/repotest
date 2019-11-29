package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.Attribute;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAttributeRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final Attribute attribute;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetAttributeRequest(RequestHeader requestHeader, Attribute attribute2) {
        this.header = requestHeader;
        this.attribute = attribute2;
    }

    private SetAttributeRequest(Builder builder) {
        this(builder.header, builder.attribute);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAttributeRequest)) {
            return false;
        }
        SetAttributeRequest setAttributeRequest = (SetAttributeRequest) obj;
        if (!equals((Object) this.header, (Object) setAttributeRequest.header) || !equals((Object) this.attribute, (Object) setAttributeRequest.attribute)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        Attribute attribute2 = this.attribute;
        if (attribute2 != null) {
            i2 = attribute2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAttributeRequest> {
        public Attribute attribute;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetAttributeRequest setAttributeRequest) {
            super(setAttributeRequest);
            if (setAttributeRequest != null) {
                this.header = setAttributeRequest.header;
                this.attribute = setAttributeRequest.attribute;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder attribute(Attribute attribute2) {
            this.attribute = attribute2;
            return this;
        }

        public SetAttributeRequest build() {
            return new SetAttributeRequest(this);
        }
    }
}
