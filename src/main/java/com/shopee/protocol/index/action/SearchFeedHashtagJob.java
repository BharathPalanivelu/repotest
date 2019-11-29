package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SearchFeedHashtagJob extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_FEED_HASHTAG_ID = 0L;
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long feed_hashtag_id;
    @ProtoField(tag = 4)
    public final SearchIndexFeedHashtag feed_hashtag_info;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public SearchFeedHashtagJob(Integer num, Long l, String str, SearchIndexFeedHashtag searchIndexFeedHashtag, f fVar) {
        this.type = num;
        this.feed_hashtag_id = l;
        this.country = str;
        this.feed_hashtag_info = searchIndexFeedHashtag;
        this.raw_ctx = fVar;
    }

    private SearchFeedHashtagJob(Builder builder) {
        this(builder.type, builder.feed_hashtag_id, builder.country, builder.feed_hashtag_info, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchFeedHashtagJob)) {
            return false;
        }
        SearchFeedHashtagJob searchFeedHashtagJob = (SearchFeedHashtagJob) obj;
        if (!equals((Object) this.type, (Object) searchFeedHashtagJob.type) || !equals((Object) this.feed_hashtag_id, (Object) searchFeedHashtagJob.feed_hashtag_id) || !equals((Object) this.country, (Object) searchFeedHashtagJob.country) || !equals((Object) this.feed_hashtag_info, (Object) searchFeedHashtagJob.feed_hashtag_info) || !equals((Object) this.raw_ctx, (Object) searchFeedHashtagJob.raw_ctx)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.feed_hashtag_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        SearchIndexFeedHashtag searchIndexFeedHashtag = this.feed_hashtag_info;
        int hashCode4 = (hashCode3 + (searchIndexFeedHashtag != null ? searchIndexFeedHashtag.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchFeedHashtagJob> {
        public String country;
        public Long feed_hashtag_id;
        public SearchIndexFeedHashtag feed_hashtag_info;
        public f raw_ctx;
        public Integer type;

        public Builder() {
        }

        public Builder(SearchFeedHashtagJob searchFeedHashtagJob) {
            super(searchFeedHashtagJob);
            if (searchFeedHashtagJob != null) {
                this.type = searchFeedHashtagJob.type;
                this.feed_hashtag_id = searchFeedHashtagJob.feed_hashtag_id;
                this.country = searchFeedHashtagJob.country;
                this.feed_hashtag_info = searchFeedHashtagJob.feed_hashtag_info;
                this.raw_ctx = searchFeedHashtagJob.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder feed_hashtag_id(Long l) {
            this.feed_hashtag_id = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder feed_hashtag_info(SearchIndexFeedHashtag searchIndexFeedHashtag) {
            this.feed_hashtag_info = searchIndexFeedHashtag;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public SearchFeedHashtagJob build() {
            return new SearchFeedHashtagJob(this);
        }
    }
}
