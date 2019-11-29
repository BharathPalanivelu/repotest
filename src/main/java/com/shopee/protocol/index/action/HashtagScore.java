package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HashtagScore extends Message {
    public static final String DEFAULT_HASHTAG = "";
    public static final Integer DEFAULT_SCORE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String hashtag;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer score;

    public HashtagScore(String str, Integer num) {
        this.hashtag = str;
        this.score = num;
    }

    private HashtagScore(Builder builder) {
        this(builder.hashtag, builder.score);
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
        if (!equals((Object) this.hashtag, (Object) hashtagScore.hashtag) || !equals((Object) this.score, (Object) hashtagScore.score)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.hashtag;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.score;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HashtagScore> {
        public String hashtag;
        public Integer score;

        public Builder() {
        }

        public Builder(HashtagScore hashtagScore) {
            super(hashtagScore);
            if (hashtagScore != null) {
                this.hashtag = hashtagScore.hashtag;
                this.score = hashtagScore.score;
            }
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder score(Integer num) {
            this.score = num;
            return this;
        }

        public HashtagScore build() {
            return new HashtagScore(this);
        }
    }
}
