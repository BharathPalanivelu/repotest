package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestSearchUser extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_EXACT_ONLY = false;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_OFFICIAL_ONLY = false;
    public static final Integer DEFAULT_OFFSET = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean exact_only;
    @ProtoField(tag = 8)
    public final SearchFeedUserOption feed_option;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean official_only;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;

    public RequestSearchUser(RequestHeader requestHeader, String str, Integer num, Integer num2, String str2, Boolean bool, Boolean bool2, SearchFeedUserOption searchFeedUserOption) {
        this.header = requestHeader;
        this.keyword = str;
        this.offset = num;
        this.limit = num2;
        this.country = str2;
        this.official_only = bool;
        this.exact_only = bool2;
        this.feed_option = searchFeedUserOption;
    }

    private RequestSearchUser(Builder builder) {
        this(builder.header, builder.keyword, builder.offset, builder.limit, builder.country, builder.official_only, builder.exact_only, builder.feed_option);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchUser)) {
            return false;
        }
        RequestSearchUser requestSearchUser = (RequestSearchUser) obj;
        if (!equals((Object) this.header, (Object) requestSearchUser.header) || !equals((Object) this.keyword, (Object) requestSearchUser.keyword) || !equals((Object) this.offset, (Object) requestSearchUser.offset) || !equals((Object) this.limit, (Object) requestSearchUser.limit) || !equals((Object) this.country, (Object) requestSearchUser.country) || !equals((Object) this.official_only, (Object) requestSearchUser.official_only) || !equals((Object) this.exact_only, (Object) requestSearchUser.exact_only) || !equals((Object) this.feed_option, (Object) requestSearchUser.feed_option)) {
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
        String str2 = this.country;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.official_only;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.exact_only;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        SearchFeedUserOption searchFeedUserOption = this.feed_option;
        if (searchFeedUserOption != null) {
            i2 = searchFeedUserOption.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchUser> {
        public String country;
        public Boolean exact_only;
        public SearchFeedUserOption feed_option;
        public RequestHeader header;
        public String keyword;
        public Integer limit;
        public Boolean official_only;
        public Integer offset;

        public Builder() {
        }

        public Builder(RequestSearchUser requestSearchUser) {
            super(requestSearchUser);
            if (requestSearchUser != null) {
                this.header = requestSearchUser.header;
                this.keyword = requestSearchUser.keyword;
                this.offset = requestSearchUser.offset;
                this.limit = requestSearchUser.limit;
                this.country = requestSearchUser.country;
                this.official_only = requestSearchUser.official_only;
                this.exact_only = requestSearchUser.exact_only;
                this.feed_option = requestSearchUser.feed_option;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder official_only(Boolean bool) {
            this.official_only = bool;
            return this;
        }

        public Builder exact_only(Boolean bool) {
            this.exact_only = bool;
            return this;
        }

        public Builder feed_option(SearchFeedUserOption searchFeedUserOption) {
            this.feed_option = searchFeedUserOption;
            return this;
        }

        public RequestSearchUser build() {
            return new RequestSearchUser(this);
        }
    }
}
