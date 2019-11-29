package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LikeFeed extends Message {
    public static final Long DEFAULT_FEEDID = 0L;
    public static final Boolean DEFAULT_LIKE = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean like;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public LikeFeed(String str, String str2, Long l, Boolean bool) {
        this.requestid = str;
        this.token = str2;
        this.feedid = l;
        this.like = bool;
    }

    private LikeFeed(Builder builder) {
        this(builder.requestid, builder.token, builder.feedid, builder.like);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LikeFeed)) {
            return false;
        }
        LikeFeed likeFeed = (LikeFeed) obj;
        if (!equals((Object) this.requestid, (Object) likeFeed.requestid) || !equals((Object) this.token, (Object) likeFeed.token) || !equals((Object) this.feedid, (Object) likeFeed.feedid) || !equals((Object) this.like, (Object) likeFeed.like)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.feedid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.like;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LikeFeed> {
        public Long feedid;
        public Boolean like;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(LikeFeed likeFeed) {
            super(likeFeed);
            if (likeFeed != null) {
                this.requestid = likeFeed.requestid;
                this.token = likeFeed.token;
                this.feedid = likeFeed.feedid;
                this.like = likeFeed.like;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public Builder like(Boolean bool) {
            this.like = bool;
            return this;
        }

        public LikeFeed build() {
            return new LikeFeed(this);
        }
    }
}
