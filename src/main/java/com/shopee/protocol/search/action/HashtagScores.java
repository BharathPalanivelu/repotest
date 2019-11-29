package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class HashtagScores extends Message {
    public static final List<HashtagScore> DEFAULT_SCORES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = HashtagScore.class, tag = 1)
    public final List<HashtagScore> scores;

    public HashtagScores(List<HashtagScore> list) {
        this.scores = immutableCopyOf(list);
    }

    private HashtagScores(Builder builder) {
        this(builder.scores);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HashtagScores)) {
            return false;
        }
        return equals((List<?>) this.scores, (List<?>) ((HashtagScores) obj).scores);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<HashtagScore> list = this.scores;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<HashtagScores> {
        public List<HashtagScore> scores;

        public Builder() {
        }

        public Builder(HashtagScores hashtagScores) {
            super(hashtagScores);
            if (hashtagScores != null) {
                this.scores = HashtagScores.copyOf(hashtagScores.scores);
            }
        }

        public Builder scores(List<HashtagScore> list) {
            this.scores = checkForNulls(list);
            return this;
        }

        public HashtagScores build() {
            return new HashtagScores(this);
        }
    }
}
