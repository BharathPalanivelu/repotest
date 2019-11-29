package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetLikeItemComment extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Boolean DEFAULT_LIKE = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean like;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public SetLikeItemComment(String str, String str2, Integer num, Long l, Long l2, Boolean bool) {
        this.requestid = str;
        this.token = str2;
        this.shopid = num;
        this.itemid = l;
        this.cmtid = l2;
        this.like = bool;
    }

    private SetLikeItemComment(Builder builder) {
        this(builder.requestid, builder.token, builder.shopid, builder.itemid, builder.cmtid, builder.like);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetLikeItemComment)) {
            return false;
        }
        SetLikeItemComment setLikeItemComment = (SetLikeItemComment) obj;
        if (!equals((Object) this.requestid, (Object) setLikeItemComment.requestid) || !equals((Object) this.token, (Object) setLikeItemComment.token) || !equals((Object) this.shopid, (Object) setLikeItemComment.shopid) || !equals((Object) this.itemid, (Object) setLikeItemComment.itemid) || !equals((Object) this.cmtid, (Object) setLikeItemComment.cmtid) || !equals((Object) this.like, (Object) setLikeItemComment.like)) {
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
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.cmtid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool = this.like;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetLikeItemComment> {
        public Long cmtid;
        public Long itemid;
        public Boolean like;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(SetLikeItemComment setLikeItemComment) {
            super(setLikeItemComment);
            if (setLikeItemComment != null) {
                this.requestid = setLikeItemComment.requestid;
                this.token = setLikeItemComment.token;
                this.shopid = setLikeItemComment.shopid;
                this.itemid = setLikeItemComment.itemid;
                this.cmtid = setLikeItemComment.cmtid;
                this.like = setLikeItemComment.like;
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

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder like(Boolean bool) {
            this.like = bool;
            return this;
        }

        public SetLikeItemComment build() {
            return new SetLikeItemComment(this);
        }
    }
}
