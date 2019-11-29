package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActVoteFAQAnswer extends Message {
    public static final Long DEFAULT_ARTICLEID = 0L;
    public static final Boolean DEFAULT_USEFUL = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long articleId;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean useful;

    public ActVoteFAQAnswer(Long l, Boolean bool) {
        this.articleId = l;
        this.useful = bool;
    }

    private ActVoteFAQAnswer(Builder builder) {
        this(builder.articleId, builder.useful);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActVoteFAQAnswer)) {
            return false;
        }
        ActVoteFAQAnswer actVoteFAQAnswer = (ActVoteFAQAnswer) obj;
        if (!equals((Object) this.articleId, (Object) actVoteFAQAnswer.articleId) || !equals((Object) this.useful, (Object) actVoteFAQAnswer.useful)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.articleId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Boolean bool = this.useful;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActVoteFAQAnswer> {
        public Long articleId;
        public Boolean useful;

        public Builder() {
        }

        public Builder(ActVoteFAQAnswer actVoteFAQAnswer) {
            super(actVoteFAQAnswer);
            if (actVoteFAQAnswer != null) {
                this.articleId = actVoteFAQAnswer.articleId;
                this.useful = actVoteFAQAnswer.useful;
            }
        }

        public Builder articleId(Long l) {
            this.articleId = l;
            return this;
        }

        public Builder useful(Boolean bool) {
            this.useful = bool;
            return this;
        }

        public ActVoteFAQAnswer build() {
            return new ActVoteFAQAnswer(this);
        }
    }
}
