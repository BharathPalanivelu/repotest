package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SameShopEditResponse extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public SameShopEditResponse(ResponseHeader responseHeader) {
        this.header = responseHeader;
    }

    private SameShopEditResponse(Builder builder) {
        this(builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SameShopEditResponse)) {
            return false;
        }
        return equals((Object) this.header, (Object) ((SameShopEditResponse) obj).header);
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

    public static final class Builder extends Message.Builder<SameShopEditResponse> {
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(SameShopEditResponse sameShopEditResponse) {
            super(sameShopEditResponse);
            if (sameShopEditResponse != null) {
                this.header = sameShopEditResponse.header;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public SameShopEditResponse build() {
            return new SameShopEditResponse(this);
        }
    }
}
