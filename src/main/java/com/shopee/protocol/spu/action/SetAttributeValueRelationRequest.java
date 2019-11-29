package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.AttributeValueRelation;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAttributeValueRelationRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 3)
    public final AttributeValueRelation relation;

    public SetAttributeValueRelationRequest(RequestHeader requestHeader, AttributeValueRelation attributeValueRelation) {
        this.header = requestHeader;
        this.relation = attributeValueRelation;
    }

    private SetAttributeValueRelationRequest(Builder builder) {
        this(builder.header, builder.relation);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAttributeValueRelationRequest)) {
            return false;
        }
        SetAttributeValueRelationRequest setAttributeValueRelationRequest = (SetAttributeValueRelationRequest) obj;
        if (!equals((Object) this.header, (Object) setAttributeValueRelationRequest.header) || !equals((Object) this.relation, (Object) setAttributeValueRelationRequest.relation)) {
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
        AttributeValueRelation attributeValueRelation = this.relation;
        if (attributeValueRelation != null) {
            i2 = attributeValueRelation.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAttributeValueRelationRequest> {
        public RequestHeader header;
        public AttributeValueRelation relation;

        public Builder() {
        }

        public Builder(SetAttributeValueRelationRequest setAttributeValueRelationRequest) {
            super(setAttributeValueRelationRequest);
            if (setAttributeValueRelationRequest != null) {
                this.header = setAttributeValueRelationRequest.header;
                this.relation = setAttributeValueRelationRequest.relation;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder relation(AttributeValueRelation attributeValueRelation) {
            this.relation = attributeValueRelation;
            return this;
        }

        public SetAttributeValueRelationRequest build() {
            return new SetAttributeValueRelationRequest(this);
        }
    }
}
