package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseGetSubCatId extends Message {
    public static final Boolean DEFAULT_EXIST = false;
    public static final Integer DEFAULT_SCATID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean exist;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer scatid;

    public ResponseGetSubCatId(ResponseHeader responseHeader, Boolean bool, Integer num) {
        this.header = responseHeader;
        this.exist = bool;
        this.scatid = num;
    }

    private ResponseGetSubCatId(Builder builder) {
        this(builder.header, builder.exist, builder.scatid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetSubCatId)) {
            return false;
        }
        ResponseGetSubCatId responseGetSubCatId = (ResponseGetSubCatId) obj;
        if (!equals((Object) this.header, (Object) responseGetSubCatId.header) || !equals((Object) this.exist, (Object) responseGetSubCatId.exist) || !equals((Object) this.scatid, (Object) responseGetSubCatId.scatid)) {
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
        Boolean bool = this.exist;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.scatid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetSubCatId> {
        public Boolean exist;
        public ResponseHeader header;
        public Integer scatid;

        public Builder() {
        }

        public Builder(ResponseGetSubCatId responseGetSubCatId) {
            super(responseGetSubCatId);
            if (responseGetSubCatId != null) {
                this.header = responseGetSubCatId.header;
                this.exist = responseGetSubCatId.exist;
                this.scatid = responseGetSubCatId.scatid;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder exist(Boolean bool) {
            this.exist = bool;
            return this;
        }

        public Builder scatid(Integer num) {
            this.scatid = num;
            return this;
        }

        public ResponseGetSubCatId build() {
            return new ResponseGetSubCatId(this);
        }
    }
}
