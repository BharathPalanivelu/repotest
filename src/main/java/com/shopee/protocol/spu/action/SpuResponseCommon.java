package com.shopee.protocol.spu.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SpuResponseCommon extends Message {
    public static final String DEFAULT_ERR_MESSAGE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public SpuResponseCommon(ResponseHeader responseHeader, String str) {
        this.header = responseHeader;
        this.err_message = str;
    }

    private SpuResponseCommon(Builder builder) {
        this(builder.header, builder.err_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpuResponseCommon)) {
            return false;
        }
        SpuResponseCommon spuResponseCommon = (SpuResponseCommon) obj;
        if (!equals((Object) this.header, (Object) spuResponseCommon.header) || !equals((Object) this.err_message, (Object) spuResponseCommon.err_message)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        String str = this.err_message;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SpuResponseCommon> {
        public String err_message;
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(SpuResponseCommon spuResponseCommon) {
            super(spuResponseCommon);
            if (spuResponseCommon != null) {
                this.header = spuResponseCommon.header;
                this.err_message = spuResponseCommon.err_message;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public SpuResponseCommon build() {
            return new SpuResponseCommon(this);
        }
    }
}
