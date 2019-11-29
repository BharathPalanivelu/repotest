package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestGetSubCatId extends Message {
    public static final Integer DEFAULT_MCATID = 0;
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer mcatid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String query;

    public RequestGetSubCatId(RequestHeader requestHeader, Integer num, String str) {
        this.header = requestHeader;
        this.mcatid = num;
        this.query = str;
    }

    private RequestGetSubCatId(Builder builder) {
        this(builder.header, builder.mcatid, builder.query);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestGetSubCatId)) {
            return false;
        }
        RequestGetSubCatId requestGetSubCatId = (RequestGetSubCatId) obj;
        if (!equals((Object) this.header, (Object) requestGetSubCatId.header) || !equals((Object) this.mcatid, (Object) requestGetSubCatId.mcatid) || !equals((Object) this.query, (Object) requestGetSubCatId.query)) {
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
        Integer num = this.mcatid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.query;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestGetSubCatId> {
        public RequestHeader header;
        public Integer mcatid;
        public String query;

        public Builder() {
        }

        public Builder(RequestGetSubCatId requestGetSubCatId) {
            super(requestGetSubCatId);
            if (requestGetSubCatId != null) {
                this.header = requestGetSubCatId.header;
                this.mcatid = requestGetSubCatId.mcatid;
                this.query = requestGetSubCatId.query;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder mcatid(Integer num) {
            this.mcatid = num;
            return this;
        }

        public Builder query(String str) {
            this.query = str;
            return this;
        }

        public RequestGetSubCatId build() {
            return new RequestGetSubCatId(this);
        }
    }
}
