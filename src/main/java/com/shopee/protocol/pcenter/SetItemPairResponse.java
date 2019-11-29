package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetItemPairResponse extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public SetItemPairResponse(ResponseHeader responseHeader) {
        this.header = responseHeader;
    }

    private SetItemPairResponse(Builder builder) {
        this(builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetItemPairResponse)) {
            return false;
        }
        return equals((Object) this.header, (Object) ((SetItemPairResponse) obj).header);
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

    public static final class Builder extends Message.Builder<SetItemPairResponse> {
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(SetItemPairResponse setItemPairResponse) {
            super(setItemPairResponse);
            if (setItemPairResponse != null) {
                this.header = setItemPairResponse.header;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public SetItemPairResponse build() {
            return new SetItemPairResponse(this);
        }
    }
}
