package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FeedComment extends Message {
    public static final String DEFAULT_COMMENT = "";
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_FEEDID = 0L;
    public static final f DEFAULT_MENTIONED = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f mentioned;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public FeedComment(Long l, Integer num, String str, Long l2, f fVar, Integer num2) {
        this.feedid = l;
        this.userid = num;
        this.comment = str;
        this.ctime = l2;
        this.mentioned = fVar;
        this.shopid = num2;
    }

    private FeedComment(Builder builder) {
        this(builder.feedid, builder.userid, builder.comment, builder.ctime, builder.mentioned, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedComment)) {
            return false;
        }
        FeedComment feedComment = (FeedComment) obj;
        if (!equals((Object) this.feedid, (Object) feedComment.feedid) || !equals((Object) this.userid, (Object) feedComment.userid) || !equals((Object) this.comment, (Object) feedComment.comment) || !equals((Object) this.ctime, (Object) feedComment.ctime) || !equals((Object) this.mentioned, (Object) feedComment.mentioned) || !equals((Object) this.shopid, (Object) feedComment.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.feedid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.comment;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        f fVar = this.mentioned;
        int hashCode5 = (hashCode4 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FeedComment> {
        public String comment;
        public Long ctime;
        public Long feedid;
        public f mentioned;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(FeedComment feedComment) {
            super(feedComment);
            if (feedComment != null) {
                this.feedid = feedComment.feedid;
                this.userid = feedComment.userid;
                this.comment = feedComment.comment;
                this.ctime = feedComment.ctime;
                this.mentioned = feedComment.mentioned;
                this.shopid = feedComment.shopid;
            }
        }

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder comment(String str) {
            this.comment = str;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mentioned(f fVar) {
            this.mentioned = fVar;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public FeedComment build() {
            return new FeedComment(this);
        }
    }
}
