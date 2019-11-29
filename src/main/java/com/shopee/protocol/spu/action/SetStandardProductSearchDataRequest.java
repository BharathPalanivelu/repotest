package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.StandardProductSearchData;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetStandardProductSearchDataRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final StandardProductSearchData data;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetStandardProductSearchDataRequest(RequestHeader requestHeader, StandardProductSearchData standardProductSearchData) {
        this.header = requestHeader;
        this.data = standardProductSearchData;
    }

    private SetStandardProductSearchDataRequest(Builder builder) {
        this(builder.header, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetStandardProductSearchDataRequest)) {
            return false;
        }
        SetStandardProductSearchDataRequest setStandardProductSearchDataRequest = (SetStandardProductSearchDataRequest) obj;
        if (!equals((Object) this.header, (Object) setStandardProductSearchDataRequest.header) || !equals((Object) this.data, (Object) setStandardProductSearchDataRequest.data)) {
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
        StandardProductSearchData standardProductSearchData = this.data;
        if (standardProductSearchData != null) {
            i2 = standardProductSearchData.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetStandardProductSearchDataRequest> {
        public StandardProductSearchData data;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetStandardProductSearchDataRequest setStandardProductSearchDataRequest) {
            super(setStandardProductSearchDataRequest);
            if (setStandardProductSearchDataRequest != null) {
                this.header = setStandardProductSearchDataRequest.header;
                this.data = setStandardProductSearchDataRequest.data;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder data(StandardProductSearchData standardProductSearchData) {
            this.data = standardProductSearchData;
            return this;
        }

        public SetStandardProductSearchDataRequest build() {
            return new SetStandardProductSearchDataRequest(this);
        }
    }
}
