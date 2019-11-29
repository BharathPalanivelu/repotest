package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.StandardProductAttribute;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetStandardProductAttributeRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final StandardProductAttribute attribute;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetStandardProductAttributeRequest(RequestHeader requestHeader, StandardProductAttribute standardProductAttribute) {
        this.header = requestHeader;
        this.attribute = standardProductAttribute;
    }

    private SetStandardProductAttributeRequest(Builder builder) {
        this(builder.header, builder.attribute);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetStandardProductAttributeRequest)) {
            return false;
        }
        SetStandardProductAttributeRequest setStandardProductAttributeRequest = (SetStandardProductAttributeRequest) obj;
        if (!equals((Object) this.header, (Object) setStandardProductAttributeRequest.header) || !equals((Object) this.attribute, (Object) setStandardProductAttributeRequest.attribute)) {
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
        StandardProductAttribute standardProductAttribute = this.attribute;
        if (standardProductAttribute != null) {
            i2 = standardProductAttribute.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetStandardProductAttributeRequest> {
        public StandardProductAttribute attribute;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetStandardProductAttributeRequest setStandardProductAttributeRequest) {
            super(setStandardProductAttributeRequest);
            if (setStandardProductAttributeRequest != null) {
                this.header = setStandardProductAttributeRequest.header;
                this.attribute = setStandardProductAttributeRequest.attribute;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder attribute(StandardProductAttribute standardProductAttribute) {
            this.attribute = standardProductAttribute;
            return this;
        }

        public SetStandardProductAttributeRequest build() {
            return new SetStandardProductAttributeRequest(this);
        }
    }
}
