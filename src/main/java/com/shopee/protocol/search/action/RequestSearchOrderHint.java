package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestSearchOrderHint extends Message {
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;

    public RequestSearchOrderHint(RequestHeader requestHeader, String str, Integer num, Integer num2, Integer num3) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.shopid = num3;
    }

    private RequestSearchOrderHint(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchOrderHint)) {
            return false;
        }
        RequestSearchOrderHint requestSearchOrderHint = (RequestSearchOrderHint) obj;
        if (!equals((Object) this.header, (Object) requestSearchOrderHint.header) || !equals((Object) this.keyword, (Object) requestSearchOrderHint.keyword) || !equals((Object) this.offset, (Object) requestSearchOrderHint.offset) || !equals((Object) this.limit, (Object) requestSearchOrderHint.limit) || !equals((Object) this.shopid, (Object) requestSearchOrderHint.shopid)) {
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
        String str = this.keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchOrderHint> {
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Integer offset;
        public Integer shopid;

        public Builder() {
        }

        public Builder(RequestSearchOrderHint requestSearchOrderHint) {
            super(requestSearchOrderHint);
            if (requestSearchOrderHint != null) {
                this.header = requestSearchOrderHint.header;
                this.keyword = requestSearchOrderHint.keyword;
                this.offset = requestSearchOrderHint.offset;
                this.limit = requestSearchOrderHint.limit;
                this.shopid = requestSearchOrderHint.shopid;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public RequestSearchOrderHint build() {
            return new RequestSearchOrderHint(this);
        }
    }
}
