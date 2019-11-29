package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.AttributeValueV2;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAttributeValueRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2)
    public final AttributeValueV2 value;

    public SetAttributeValueRequest(RequestHeader requestHeader, AttributeValueV2 attributeValueV2) {
        this.header = requestHeader;
        this.value = attributeValueV2;
    }

    private SetAttributeValueRequest(Builder builder) {
        this(builder.header, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAttributeValueRequest)) {
            return false;
        }
        SetAttributeValueRequest setAttributeValueRequest = (SetAttributeValueRequest) obj;
        if (!equals((Object) this.header, (Object) setAttributeValueRequest.header) || !equals((Object) this.value, (Object) setAttributeValueRequest.value)) {
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
        AttributeValueV2 attributeValueV2 = this.value;
        if (attributeValueV2 != null) {
            i2 = attributeValueV2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAttributeValueRequest> {
        public RequestHeader header;
        public AttributeValueV2 value;

        public Builder() {
        }

        public Builder(SetAttributeValueRequest setAttributeValueRequest) {
            super(setAttributeValueRequest);
            if (setAttributeValueRequest != null) {
                this.header = setAttributeValueRequest.header;
                this.value = setAttributeValueRequest.value;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder value(AttributeValueV2 attributeValueV2) {
            this.value = attributeValueV2;
            return this;
        }

        public SetAttributeValueRequest build() {
            return new SetAttributeValueRequest(this);
        }
    }
}
