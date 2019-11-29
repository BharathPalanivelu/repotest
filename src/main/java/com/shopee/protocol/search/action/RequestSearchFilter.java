package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestSearchFilter extends Message {
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_SORTTYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final SearchCondition condition;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer sorttype;

    public RequestSearchFilter(RequestHeader requestHeader, String str, Integer num, Integer num2, Integer num3, SearchCondition searchCondition) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.sorttype = num3;
        this.condition = searchCondition;
    }

    private RequestSearchFilter(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.sorttype, builder.condition);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchFilter)) {
            return false;
        }
        RequestSearchFilter requestSearchFilter = (RequestSearchFilter) obj;
        if (!equals((Object) this.header, (Object) requestSearchFilter.header) || !equals((Object) this.keyword, (Object) requestSearchFilter.keyword) || !equals((Object) this.offset, (Object) requestSearchFilter.offset) || !equals((Object) this.limit, (Object) requestSearchFilter.limit) || !equals((Object) this.sorttype, (Object) requestSearchFilter.sorttype) || !equals((Object) this.condition, (Object) requestSearchFilter.condition)) {
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
        Integer num3 = this.sorttype;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        SearchCondition searchCondition = this.condition;
        if (searchCondition != null) {
            i2 = searchCondition.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchFilter> {
        public SearchCondition condition;
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Integer offset;
        public Integer sorttype;

        public Builder() {
        }

        public Builder(RequestSearchFilter requestSearchFilter) {
            super(requestSearchFilter);
            if (requestSearchFilter != null) {
                this.header = requestSearchFilter.header;
                this.keyword = requestSearchFilter.keyword;
                this.offset = requestSearchFilter.offset;
                this.limit = requestSearchFilter.limit;
                this.sorttype = requestSearchFilter.sorttype;
                this.condition = requestSearchFilter.condition;
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

        public Builder sorttype(Integer num) {
            this.sorttype = num;
            return this;
        }

        public Builder condition(SearchCondition searchCondition) {
            this.condition = searchCondition;
            return this;
        }

        public RequestSearchFilter build() {
            return new RequestSearchFilter(this);
        }
    }
}
