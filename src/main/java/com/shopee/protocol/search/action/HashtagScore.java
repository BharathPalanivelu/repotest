package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HashtagScore extends Message {
    public static final Long DEFAULT_HASHTAG = 0L;
    public static final Integer DEFAULT_VALUE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long hashtag;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer value;

    public HashtagScore(Long l, Integer num) {
        this.hashtag = l;
        this.value = num;
    }

    private HashtagScore(Builder builder) {
        this(builder.hashtag, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HashtagScore)) {
            return false;
        }
        HashtagScore hashtagScore = (HashtagScore) obj;
        if (!equals((Object) this.hashtag, (Object) hashtagScore.hashtag) || !equals((Object) this.value, (Object) hashtagScore.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.hashtag;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.value;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HashtagScore> {
        public Long hashtag;
        public Integer value;

        public Builder() {
        }

        public Builder(HashtagScore hashtagScore) {
            super(hashtagScore);
            if (hashtagScore != null) {
                this.hashtag = hashtagScore.hashtag;
                this.value = hashtagScore.value;
            }
        }

        public Builder hashtag(Long l) {
            this.hashtag = l;
            return this;
        }

        public Builder value(Integer num) {
            this.value = num;
            return this;
        }

        public HashtagScore build() {
            return new HashtagScore(this);
        }
    }
}
