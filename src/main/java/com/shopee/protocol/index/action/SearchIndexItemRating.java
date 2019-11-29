package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexItemRating extends Message {
    public static final Integer DEFAULT_BAD_RATINGS = 0;
    public static final Integer DEFAULT_GOOD_RATINGS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer bad_ratings;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer good_ratings;

    public SearchIndexItemRating(Integer num, Integer num2) {
        this.good_ratings = num;
        this.bad_ratings = num2;
    }

    private SearchIndexItemRating(Builder builder) {
        this(builder.good_ratings, builder.bad_ratings);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemRating)) {
            return false;
        }
        SearchIndexItemRating searchIndexItemRating = (SearchIndexItemRating) obj;
        if (!equals((Object) this.good_ratings, (Object) searchIndexItemRating.good_ratings) || !equals((Object) this.bad_ratings, (Object) searchIndexItemRating.bad_ratings)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.good_ratings;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.bad_ratings;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemRating> {
        public Integer bad_ratings;
        public Integer good_ratings;

        public Builder() {
        }

        public Builder(SearchIndexItemRating searchIndexItemRating) {
            super(searchIndexItemRating);
            if (searchIndexItemRating != null) {
                this.good_ratings = searchIndexItemRating.good_ratings;
                this.bad_ratings = searchIndexItemRating.bad_ratings;
            }
        }

        public Builder good_ratings(Integer num) {
            this.good_ratings = num;
            return this;
        }

        public Builder bad_ratings(Integer num) {
            this.bad_ratings = num;
            return this;
        }

        public SearchIndexItemRating build() {
            return new SearchIndexItemRating(this);
        }
    }
}
