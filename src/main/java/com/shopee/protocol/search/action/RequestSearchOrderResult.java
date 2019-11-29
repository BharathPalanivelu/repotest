package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestSearchOrderResult extends Message {
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

    public RequestSearchOrderResult(RequestHeader requestHeader, String str, Integer num, Integer num2, Integer num3) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.shopid = num3;
    }

    private RequestSearchOrderResult(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchOrderResult)) {
            return false;
        }
        RequestSearchOrderResult requestSearchOrderResult = (RequestSearchOrderResult) obj;
        if (!equals((Object) this.header, (Object) requestSearchOrderResult.header) || !equals((Object) this.keyword, (Object) requestSearchOrderResult.keyword) || !equals((Object) this.offset, (Object) requestSearchOrderResult.offset) || !equals((Object) this.limit, (Object) requestSearchOrderResult.limit) || !equals((Object) this.shopid, (Object) requestSearchOrderResult.shopid)) {
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

    public static final class Builder extends Message.Builder<RequestSearchOrderResult> {
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Integer offset;
        public Integer shopid;

        public Builder() {
        }

        public Builder(RequestSearchOrderResult requestSearchOrderResult) {
            super(requestSearchOrderResult);
            if (requestSearchOrderResult != null) {
                this.header = requestSearchOrderResult.header;
                this.keyword = requestSearchOrderResult.keyword;
                this.offset = requestSearchOrderResult.offset;
                this.limit = requestSearchOrderResult.limit;
                this.shopid = requestSearchOrderResult.shopid;
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

        public RequestSearchOrderResult build() {
            return new RequestSearchOrderResult(this);
        }
    }
}
