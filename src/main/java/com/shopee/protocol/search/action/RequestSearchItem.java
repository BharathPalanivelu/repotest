package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestSearchItem extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final Integer DEFAULT_FACET_TYPE = 0;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_NEED_DEBUG = 0;
    public static final Boolean DEFAULT_NEED_DROP_WORD = false;
    public static final Boolean DEFAULT_NEED_ITEMS = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_SORTTYPE = 0;
    public static final Integer DEFAULT_SUGGESTION_ALGORITHM = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 6)
    public final SearchCondition condition;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer facet_type;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer need_debug;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean need_drop_word;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean need_items;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer sorttype;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer suggestion_algorithm;

    public RequestSearchItem(RequestHeader requestHeader, String str, Integer num, Integer num2, Integer num3, SearchCondition searchCondition, Boolean bool, Boolean bool2, Integer num4, Integer num5, String str2, Integer num6) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.sorttype = num3;
        this.condition = searchCondition;
        this.need_drop_word = bool;
        this.need_items = bool2;
        this.need_debug = num4;
        this.facet_type = num5;
        this.algorithm = str2;
        this.suggestion_algorithm = num6;
    }

    private RequestSearchItem(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.sorttype, builder.condition, builder.need_drop_word, builder.need_items, builder.need_debug, builder.facet_type, builder.algorithm, builder.suggestion_algorithm);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchItem)) {
            return false;
        }
        RequestSearchItem requestSearchItem = (RequestSearchItem) obj;
        if (!equals((Object) this.header, (Object) requestSearchItem.header) || !equals((Object) this.keyword, (Object) requestSearchItem.keyword) || !equals((Object) this.offset, (Object) requestSearchItem.offset) || !equals((Object) this.limit, (Object) requestSearchItem.limit) || !equals((Object) this.sorttype, (Object) requestSearchItem.sorttype) || !equals((Object) this.condition, (Object) requestSearchItem.condition) || !equals((Object) this.need_drop_word, (Object) requestSearchItem.need_drop_word) || !equals((Object) this.need_items, (Object) requestSearchItem.need_items) || !equals((Object) this.need_debug, (Object) requestSearchItem.need_debug) || !equals((Object) this.facet_type, (Object) requestSearchItem.facet_type) || !equals((Object) this.algorithm, (Object) requestSearchItem.algorithm) || !equals((Object) this.suggestion_algorithm, (Object) requestSearchItem.suggestion_algorithm)) {
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
        int hashCode6 = (hashCode5 + (searchCondition != null ? searchCondition.hashCode() : 0)) * 37;
        Boolean bool = this.need_drop_word;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_items;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num4 = this.need_debug;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.facet_type;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.algorithm;
        int hashCode11 = (hashCode10 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num6 = this.suggestion_algorithm;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchItem> {
        public String algorithm;
        public SearchCondition condition;
        public Integer facet_type;
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Integer need_debug;
        public Boolean need_drop_word;
        public Boolean need_items;
        public Integer offset;
        public Integer sorttype;
        public Integer suggestion_algorithm;

        public Builder() {
        }

        public Builder(RequestSearchItem requestSearchItem) {
            super(requestSearchItem);
            if (requestSearchItem != null) {
                this.header = requestSearchItem.header;
                this.keyword = requestSearchItem.keyword;
                this.offset = requestSearchItem.offset;
                this.limit = requestSearchItem.limit;
                this.sorttype = requestSearchItem.sorttype;
                this.condition = requestSearchItem.condition;
                this.need_drop_word = requestSearchItem.need_drop_word;
                this.need_items = requestSearchItem.need_items;
                this.need_debug = requestSearchItem.need_debug;
                this.facet_type = requestSearchItem.facet_type;
                this.algorithm = requestSearchItem.algorithm;
                this.suggestion_algorithm = requestSearchItem.suggestion_algorithm;
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

        public Builder need_drop_word(Boolean bool) {
            this.need_drop_word = bool;
            return this;
        }

        public Builder need_items(Boolean bool) {
            this.need_items = bool;
            return this;
        }

        public Builder need_debug(Integer num) {
            this.need_debug = num;
            return this;
        }

        public Builder facet_type(Integer num) {
            this.facet_type = num;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder suggestion_algorithm(Integer num) {
            this.suggestion_algorithm = num;
            return this;
        }

        public RequestSearchItem build() {
            return new RequestSearchItem(this);
        }
    }
}
