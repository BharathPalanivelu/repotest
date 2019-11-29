package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestSearchOrderBuyer extends Message {
    public static final Boolean DEFAULT_COLD_SEARCH_EXTEND = false;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean cold_search_extend;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userid;

    public RequestSearchOrderBuyer(RequestHeader requestHeader, String str, Integer num, Integer num2, Integer num3, Boolean bool) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.userid = num3;
        this.cold_search_extend = bool;
    }

    private RequestSearchOrderBuyer(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.userid, builder.cold_search_extend);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchOrderBuyer)) {
            return false;
        }
        RequestSearchOrderBuyer requestSearchOrderBuyer = (RequestSearchOrderBuyer) obj;
        if (!equals((Object) this.header, (Object) requestSearchOrderBuyer.header) || !equals((Object) this.keyword, (Object) requestSearchOrderBuyer.keyword) || !equals((Object) this.offset, (Object) requestSearchOrderBuyer.offset) || !equals((Object) this.limit, (Object) requestSearchOrderBuyer.limit) || !equals((Object) this.userid, (Object) requestSearchOrderBuyer.userid) || !equals((Object) this.cold_search_extend, (Object) requestSearchOrderBuyer.cold_search_extend)) {
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
        Integer num3 = this.userid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.cold_search_extend;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchOrderBuyer> {
        public Boolean cold_search_extend;
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Integer offset;
        public Integer userid;

        public Builder() {
        }

        public Builder(RequestSearchOrderBuyer requestSearchOrderBuyer) {
            super(requestSearchOrderBuyer);
            if (requestSearchOrderBuyer != null) {
                this.header = requestSearchOrderBuyer.header;
                this.keyword = requestSearchOrderBuyer.keyword;
                this.offset = requestSearchOrderBuyer.offset;
                this.limit = requestSearchOrderBuyer.limit;
                this.userid = requestSearchOrderBuyer.userid;
                this.cold_search_extend = requestSearchOrderBuyer.cold_search_extend;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder cold_search_extend(Boolean bool) {
            this.cold_search_extend = bool;
            return this;
        }

        public RequestSearchOrderBuyer build() {
            return new RequestSearchOrderBuyer(this);
        }
    }
}
