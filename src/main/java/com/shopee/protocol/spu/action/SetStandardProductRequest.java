package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.StandardProduct;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetStandardProductRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2)
    public final StandardProduct product;

    public SetStandardProductRequest(RequestHeader requestHeader, StandardProduct standardProduct) {
        this.header = requestHeader;
        this.product = standardProduct;
    }

    private SetStandardProductRequest(Builder builder) {
        this(builder.header, builder.product);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetStandardProductRequest)) {
            return false;
        }
        SetStandardProductRequest setStandardProductRequest = (SetStandardProductRequest) obj;
        if (!equals((Object) this.header, (Object) setStandardProductRequest.header) || !equals((Object) this.product, (Object) setStandardProductRequest.product)) {
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
        StandardProduct standardProduct = this.product;
        if (standardProduct != null) {
            i2 = standardProduct.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetStandardProductRequest> {
        public RequestHeader header;
        public StandardProduct product;

        public Builder() {
        }

        public Builder(SetStandardProductRequest setStandardProductRequest) {
            super(setStandardProductRequest);
            if (setStandardProductRequest != null) {
                this.header = setStandardProductRequest.header;
                this.product = setStandardProductRequest.product;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder product(StandardProduct standardProduct) {
            this.product = standardProduct;
            return this;
        }

        public SetStandardProductRequest build() {
            return new SetStandardProductRequest(this);
        }
    }
}
