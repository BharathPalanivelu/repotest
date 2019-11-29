package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestFeedSearchHashtag extends Message {
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final SearchFeedSortType DEFAULT_SORTTYPE = SearchFeedSortType.PostCount;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 5, type = Message.Datatype.ENUM)
    public final SearchFeedSortType sorttype;

    public RequestFeedSearchHashtag(RequestHeader requestHeader, String str, Integer num, Integer num2, SearchFeedSortType searchFeedSortType) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.sorttype = searchFeedSortType;
    }

    private RequestFeedSearchHashtag(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.sorttype);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestFeedSearchHashtag)) {
            return false;
        }
        RequestFeedSearchHashtag requestFeedSearchHashtag = (RequestFeedSearchHashtag) obj;
        if (!equals((Object) this.header, (Object) requestFeedSearchHashtag.header) || !equals((Object) this.keyword, (Object) requestFeedSearchHashtag.keyword) || !equals((Object) this.offset, (Object) requestFeedSearchHashtag.offset) || !equals((Object) this.limit, (Object) requestFeedSearchHashtag.limit) || !equals((Object) this.sorttype, (Object) requestFeedSearchHashtag.sorttype)) {
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
        SearchFeedSortType searchFeedSortType = this.sorttype;
        if (searchFeedSortType != null) {
            i2 = searchFeedSortType.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestFeedSearchHashtag> {
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Integer offset;
        public SearchFeedSortType sorttype;

        public Builder() {
        }

        public Builder(RequestFeedSearchHashtag requestFeedSearchHashtag) {
            super(requestFeedSearchHashtag);
            if (requestFeedSearchHashtag != null) {
                this.header = requestFeedSearchHashtag.header;
                this.keyword = requestFeedSearchHashtag.keyword;
                this.offset = requestFeedSearchHashtag.offset;
                this.limit = requestFeedSearchHashtag.limit;
                this.sorttype = requestFeedSearchHashtag.sorttype;
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

        public Builder sorttype(SearchFeedSortType searchFeedSortType) {
            this.sorttype = searchFeedSortType;
            return this;
        }

        public RequestFeedSearchHashtag build() {
            return new RequestFeedSearchHashtag(this);
        }
    }
}
