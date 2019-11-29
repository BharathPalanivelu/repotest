package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexFeedHashtag extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_CTIME = 0L;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_FEEDS_COUNT = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_NAME_ID = 0L;
    public static final Integer DEFAULT_STATE = 0;
    public static final String DEFAULT_THUMBNAIL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long feeds_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long name_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer state;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String thumbnail;

    public SearchIndexFeedHashtag(Long l, String str, Long l2, Long l3, String str2, String str3, Integer num, Long l4, Long l5, String str4) {
        this.id = l;
        this.name = str;
        this.name_id = l2;
        this.feeds_count = l3;
        this.thumbnail = str2;
        this.description = str3;
        this.state = num;
        this.ctime = l4;
        this.mtime = l5;
        this.country = str4;
    }

    private SearchIndexFeedHashtag(Builder builder) {
        this(builder.id, builder.name, builder.name_id, builder.feeds_count, builder.thumbnail, builder.description, builder.state, builder.ctime, builder.mtime, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexFeedHashtag)) {
            return false;
        }
        SearchIndexFeedHashtag searchIndexFeedHashtag = (SearchIndexFeedHashtag) obj;
        if (!equals((Object) this.id, (Object) searchIndexFeedHashtag.id) || !equals((Object) this.name, (Object) searchIndexFeedHashtag.name) || !equals((Object) this.name_id, (Object) searchIndexFeedHashtag.name_id) || !equals((Object) this.feeds_count, (Object) searchIndexFeedHashtag.feeds_count) || !equals((Object) this.thumbnail, (Object) searchIndexFeedHashtag.thumbnail) || !equals((Object) this.description, (Object) searchIndexFeedHashtag.description) || !equals((Object) this.state, (Object) searchIndexFeedHashtag.state) || !equals((Object) this.ctime, (Object) searchIndexFeedHashtag.ctime) || !equals((Object) this.mtime, (Object) searchIndexFeedHashtag.mtime) || !equals((Object) this.country, (Object) searchIndexFeedHashtag.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.name_id;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.feeds_count;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.thumbnail;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.description;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.state;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        Long l4 = this.ctime;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.mtime;
        int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str4 = this.country;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexFeedHashtag> {
        public String country;
        public Long ctime;
        public String description;
        public Long feeds_count;
        public Long id;
        public Long mtime;
        public String name;
        public Long name_id;
        public Integer state;
        public String thumbnail;

        public Builder() {
        }

        public Builder(SearchIndexFeedHashtag searchIndexFeedHashtag) {
            super(searchIndexFeedHashtag);
            if (searchIndexFeedHashtag != null) {
                this.id = searchIndexFeedHashtag.id;
                this.name = searchIndexFeedHashtag.name;
                this.name_id = searchIndexFeedHashtag.name_id;
                this.feeds_count = searchIndexFeedHashtag.feeds_count;
                this.thumbnail = searchIndexFeedHashtag.thumbnail;
                this.description = searchIndexFeedHashtag.description;
                this.state = searchIndexFeedHashtag.state;
                this.ctime = searchIndexFeedHashtag.ctime;
                this.mtime = searchIndexFeedHashtag.mtime;
                this.country = searchIndexFeedHashtag.country;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder name_id(Long l) {
            this.name_id = l;
            return this;
        }

        public Builder feeds_count(Long l) {
            this.feeds_count = l;
            return this;
        }

        public Builder thumbnail(String str) {
            this.thumbnail = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder state(Integer num) {
            this.state = num;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SearchIndexFeedHashtag build() {
            return new SearchIndexFeedHashtag(this);
        }
    }
}
