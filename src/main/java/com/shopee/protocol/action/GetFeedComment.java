package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetFeedComment extends Message {
    public static final Long DEFAULT_FEEDID = 0L;
    public static final Long DEFAULT_LAST_TIMESTAMP = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long last_timestamp;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetFeedComment(String str, Long l, Long l2, Integer num) {
        this.requestid = str;
        this.feedid = l;
        this.last_timestamp = l2;
        this.limit = num;
    }

    private GetFeedComment(Builder builder) {
        this(builder.requestid, builder.feedid, builder.last_timestamp, builder.limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetFeedComment)) {
            return false;
        }
        GetFeedComment getFeedComment = (GetFeedComment) obj;
        if (!equals((Object) this.requestid, (Object) getFeedComment.requestid) || !equals((Object) this.feedid, (Object) getFeedComment.feedid) || !equals((Object) this.last_timestamp, (Object) getFeedComment.last_timestamp) || !equals((Object) this.limit, (Object) getFeedComment.limit)) {
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
        Long l = this.feedid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.last_timestamp;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.limit;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetFeedComment> {
        public Long feedid;
        public Long last_timestamp;
        public Integer limit;
        public String requestid;

        public Builder() {
        }

        public Builder(GetFeedComment getFeedComment) {
            super(getFeedComment);
            if (getFeedComment != null) {
                this.requestid = getFeedComment.requestid;
                this.feedid = getFeedComment.feedid;
                this.last_timestamp = getFeedComment.last_timestamp;
                this.limit = getFeedComment.limit;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public Builder last_timestamp(Long l) {
            this.last_timestamp = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public GetFeedComment build() {
            return new GetFeedComment(this);
        }
    }
}
