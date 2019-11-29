package com.shopee.protocol.spu.action;

import com.shopee.protocol.shop.StandardProductSearchTerm;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetStandardProductSearchTermRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2)
    public final StandardProductSearchTerm search_term;

    public SetStandardProductSearchTermRequest(RequestHeader requestHeader, StandardProductSearchTerm standardProductSearchTerm) {
        this.header = requestHeader;
        this.search_term = standardProductSearchTerm;
    }

    private SetStandardProductSearchTermRequest(Builder builder) {
        this(builder.header, builder.search_term);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetStandardProductSearchTermRequest)) {
            return false;
        }
        SetStandardProductSearchTermRequest setStandardProductSearchTermRequest = (SetStandardProductSearchTermRequest) obj;
        if (!equals((Object) this.header, (Object) setStandardProductSearchTermRequest.header) || !equals((Object) this.search_term, (Object) setStandardProductSearchTermRequest.search_term)) {
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
        StandardProductSearchTerm standardProductSearchTerm = this.search_term;
        if (standardProductSearchTerm != null) {
            i2 = standardProductSearchTerm.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetStandardProductSearchTermRequest> {
        public RequestHeader header;
        public StandardProductSearchTerm search_term;

        public Builder() {
        }

        public Builder(SetStandardProductSearchTermRequest setStandardProductSearchTermRequest) {
            super(setStandardProductSearchTermRequest);
            if (setStandardProductSearchTermRequest != null) {
                this.header = setStandardProductSearchTermRequest.header;
                this.search_term = setStandardProductSearchTermRequest.search_term;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder search_term(StandardProductSearchTerm standardProductSearchTerm) {
            this.search_term = standardProductSearchTerm;
            return this;
        }

        public SetStandardProductSearchTermRequest build() {
            return new SetStandardProductSearchTermRequest(this);
        }
    }
}
