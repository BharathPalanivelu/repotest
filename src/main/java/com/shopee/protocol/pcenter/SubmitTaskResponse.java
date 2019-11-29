package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SubmitTaskResponse extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public SubmitTaskResponse(ResponseHeader responseHeader) {
        this.header = responseHeader;
    }

    private SubmitTaskResponse(Builder builder) {
        this(builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitTaskResponse)) {
            return false;
        }
        return equals((Object) this.header, (Object) ((SubmitTaskResponse) obj).header);
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

    public static final class Builder extends Message.Builder<SubmitTaskResponse> {
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(SubmitTaskResponse submitTaskResponse) {
            super(submitTaskResponse);
            if (submitTaskResponse != null) {
                this.header = submitTaskResponse.header;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public SubmitTaskResponse build() {
            return new SubmitTaskResponse(this);
        }
    }
}
