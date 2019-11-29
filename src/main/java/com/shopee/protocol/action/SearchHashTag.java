package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchHashTag extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_HASHTAG = "";
    public static final Long DEFAULT_LAST_HASHTAGID = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_DESCRIPTION = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SEARCH_TYPE = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String hashtag;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long last_hashtagid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean need_description;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer search_type;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String token;

    public SearchHashTag(String str, String str2, Long l, Integer num, String str3, Integer num2, Boolean bool, String str4) {
        this.requestid = str;
        this.hashtag = str2;
        this.last_hashtagid = l;
        this.limit = num;
        this.country = str3;
        this.search_type = num2;
        this.need_description = bool;
        this.token = str4;
    }

    private SearchHashTag(Builder builder) {
        this(builder.requestid, builder.hashtag, builder.last_hashtagid, builder.limit, builder.country, builder.search_type, builder.need_description, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchHashTag)) {
            return false;
        }
        SearchHashTag searchHashTag = (SearchHashTag) obj;
        if (!equals((Object) this.requestid, (Object) searchHashTag.requestid) || !equals((Object) this.hashtag, (Object) searchHashTag.hashtag) || !equals((Object) this.last_hashtagid, (Object) searchHashTag.last_hashtagid) || !equals((Object) this.limit, (Object) searchHashTag.limit) || !equals((Object) this.country, (Object) searchHashTag.country) || !equals((Object) this.search_type, (Object) searchHashTag.search_type) || !equals((Object) this.need_description, (Object) searchHashTag.need_description) || !equals((Object) this.token, (Object) searchHashTag.token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.hashtag;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.last_hashtagid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.limit;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.search_type;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.need_description;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.token;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchHashTag> {
        public String country;
        public String hashtag;
        public Long last_hashtagid;
        public Integer limit;
        public Boolean need_description;
        public String requestid;
        public Integer search_type;
        public String token;

        public Builder() {
        }

        public Builder(SearchHashTag searchHashTag) {
            super(searchHashTag);
            if (searchHashTag != null) {
                this.requestid = searchHashTag.requestid;
                this.hashtag = searchHashTag.hashtag;
                this.last_hashtagid = searchHashTag.last_hashtagid;
                this.limit = searchHashTag.limit;
                this.country = searchHashTag.country;
                this.search_type = searchHashTag.search_type;
                this.need_description = searchHashTag.need_description;
                this.token = searchHashTag.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder last_hashtagid(Long l) {
            this.last_hashtagid = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder search_type(Integer num) {
            this.search_type = num;
            return this;
        }

        public Builder need_description(Boolean bool) {
            this.need_description = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public SearchHashTag build() {
            checkRequiredFields();
            return new SearchHashTag(this);
        }
    }
}
