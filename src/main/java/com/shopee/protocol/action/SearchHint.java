package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchHint extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    public static final String DEFAULT_MATCH_VALUE = "";
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer match_type;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String match_value;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer version;

    public SearchHint(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, String str3, Integer num5, String str4, Integer num6, Integer num7) {
        this.requestid = str;
        this.keyword = str2;
        this.offset = num;
        this.limit = num2;
        this.type = num3;
        this.catid = num4;
        this.country = str3;
        this.match_type = num5;
        this.match_value = str4;
        this.version = num6;
        this.platform = num7;
    }

    private SearchHint(Builder builder) {
        this(builder.requestid, builder.keyword, builder.offset, builder.limit, builder.type, builder.catid, builder.country, builder.match_type, builder.match_value, builder.version, builder.platform);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchHint)) {
            return false;
        }
        SearchHint searchHint = (SearchHint) obj;
        if (!equals((Object) this.requestid, (Object) searchHint.requestid) || !equals((Object) this.keyword, (Object) searchHint.keyword) || !equals((Object) this.offset, (Object) searchHint.offset) || !equals((Object) this.limit, (Object) searchHint.limit) || !equals((Object) this.type, (Object) searchHint.type) || !equals((Object) this.catid, (Object) searchHint.catid) || !equals((Object) this.country, (Object) searchHint.country) || !equals((Object) this.match_type, (Object) searchHint.match_type) || !equals((Object) this.match_value, (Object) searchHint.match_value) || !equals((Object) this.version, (Object) searchHint.version) || !equals((Object) this.platform, (Object) searchHint.platform)) {
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
        String str2 = this.keyword;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.type;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.catid;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num5 = this.match_type;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.match_value;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num6 = this.version;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.platform;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchHint> {
        public Integer catid;
        public String country;
        public String keyword;
        public Integer limit;
        public Integer match_type;
        public String match_value;
        public Integer offset;
        public Integer platform;
        public String requestid;
        public Integer type;
        public Integer version;

        public Builder() {
        }

        public Builder(SearchHint searchHint) {
            super(searchHint);
            if (searchHint != null) {
                this.requestid = searchHint.requestid;
                this.keyword = searchHint.keyword;
                this.offset = searchHint.offset;
                this.limit = searchHint.limit;
                this.type = searchHint.type;
                this.catid = searchHint.catid;
                this.country = searchHint.country;
                this.match_type = searchHint.match_type;
                this.match_value = searchHint.match_value;
                this.version = searchHint.version;
                this.platform = searchHint.platform;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public Builder match_value(String str) {
            this.match_value = str;
            return this;
        }

        public Builder version(Integer num) {
            this.version = num;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public SearchHint build() {
            checkRequiredFields();
            return new SearchHint(this);
        }
    }
}
