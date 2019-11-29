package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingTrendingSearch extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final String DEFAULT_KEYWORD_OR_HASHTAG = "";
    public static final Integer DEFAULT_LOCATION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keyword_or_hashtag;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer location;

    public TrackingTrendingSearch(String str, Integer num, String str2) {
        this.keyword_or_hashtag = str;
        this.location = num;
        this.algorithm = str2;
    }

    private TrackingTrendingSearch(Builder builder) {
        this(builder.keyword_or_hashtag, builder.location, builder.algorithm);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingTrendingSearch)) {
            return false;
        }
        TrackingTrendingSearch trackingTrendingSearch = (TrackingTrendingSearch) obj;
        if (!equals((Object) this.keyword_or_hashtag, (Object) trackingTrendingSearch.keyword_or_hashtag) || !equals((Object) this.location, (Object) trackingTrendingSearch.location) || !equals((Object) this.algorithm, (Object) trackingTrendingSearch.algorithm)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keyword_or_hashtag;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.location;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.algorithm;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingTrendingSearch> {
        public String algorithm;
        public String keyword_or_hashtag;
        public Integer location;

        public Builder() {
        }

        public Builder(TrackingTrendingSearch trackingTrendingSearch) {
            super(trackingTrendingSearch);
            if (trackingTrendingSearch != null) {
                this.keyword_or_hashtag = trackingTrendingSearch.keyword_or_hashtag;
                this.location = trackingTrendingSearch.location;
                this.algorithm = trackingTrendingSearch.algorithm;
            }
        }

        public Builder keyword_or_hashtag(String str) {
            this.keyword_or_hashtag = str;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public TrackingTrendingSearch build() {
            return new TrackingTrendingSearch(this);
        }
    }
}
