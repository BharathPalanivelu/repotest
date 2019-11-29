package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.RootAttribute;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetRootAttributeRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2)
    public final RootAttribute root_attribute;

    public SetRootAttributeRequest(RequestHeader requestHeader, RootAttribute rootAttribute) {
        this.header = requestHeader;
        this.root_attribute = rootAttribute;
    }

    private SetRootAttributeRequest(Builder builder) {
        this(builder.header, builder.root_attribute);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetRootAttributeRequest)) {
            return false;
        }
        SetRootAttributeRequest setRootAttributeRequest = (SetRootAttributeRequest) obj;
        if (!equals((Object) this.header, (Object) setRootAttributeRequest.header) || !equals((Object) this.root_attribute, (Object) setRootAttributeRequest.root_attribute)) {
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
        RootAttribute rootAttribute = this.root_attribute;
        if (rootAttribute != null) {
            i2 = rootAttribute.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetRootAttributeRequest> {
        public RequestHeader header;
        public RootAttribute root_attribute;

        public Builder() {
        }

        public Builder(SetRootAttributeRequest setRootAttributeRequest) {
            super(setRootAttributeRequest);
            if (setRootAttributeRequest != null) {
                this.header = setRootAttributeRequest.header;
                this.root_attribute = setRootAttributeRequest.root_attribute;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder root_attribute(RootAttribute rootAttribute) {
            this.root_attribute = rootAttribute;
            return this;
        }

        public SetRootAttributeRequest build() {
            return new SetRootAttributeRequest(this);
        }
    }
}
