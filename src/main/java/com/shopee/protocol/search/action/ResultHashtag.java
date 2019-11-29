package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResultHashtag extends Message {
    public static final Long DEFAULT_HASHTAG_ID = 0L;
    public static final Long DEFAULT_POST_COUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long hashtag_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long post_count;

    public ResultHashtag(Long l, Long l2) {
        this.hashtag_id = l;
        this.post_count = l2;
    }

    private ResultHashtag(Builder builder) {
        this(builder.hashtag_id, builder.post_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResultHashtag)) {
            return false;
        }
        ResultHashtag resultHashtag = (ResultHashtag) obj;
        if (!equals((Object) this.hashtag_id, (Object) resultHashtag.hashtag_id) || !equals((Object) this.post_count, (Object) resultHashtag.post_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.hashtag_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.post_count;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResultHashtag> {
        public Long hashtag_id;
        public Long post_count;

        public Builder() {
        }

        public Builder(ResultHashtag resultHashtag) {
            super(resultHashtag);
            if (resultHashtag != null) {
                this.hashtag_id = resultHashtag.hashtag_id;
                this.post_count = resultHashtag.post_count;
            }
        }

        public Builder hashtag_id(Long l) {
            this.hashtag_id = l;
            return this;
        }

        public Builder post_count(Long l) {
            this.post_count = l;
            return this;
        }

        public ResultHashtag build() {
            return new ResultHashtag(this);
        }
    }
}
