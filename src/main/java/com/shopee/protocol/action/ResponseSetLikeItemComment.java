package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSetLikeItemComment extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_LIKE_COUNT = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer like_count;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetLikeItemComment(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.like_count = num2;
    }

    private ResponseSetLikeItemComment(Builder builder) {
        this(builder.requestid, builder.errcode, builder.like_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetLikeItemComment)) {
            return false;
        }
        ResponseSetLikeItemComment responseSetLikeItemComment = (ResponseSetLikeItemComment) obj;
        if (!equals((Object) this.requestid, (Object) responseSetLikeItemComment.requestid) || !equals((Object) this.errcode, (Object) responseSetLikeItemComment.errcode) || !equals((Object) this.like_count, (Object) responseSetLikeItemComment.like_count)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.like_count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSetLikeItemComment> {
        public Integer errcode;
        public Integer like_count;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetLikeItemComment responseSetLikeItemComment) {
            super(responseSetLikeItemComment);
            if (responseSetLikeItemComment != null) {
                this.requestid = responseSetLikeItemComment.requestid;
                this.errcode = responseSetLikeItemComment.errcode;
                this.like_count = responseSetLikeItemComment.like_count;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder like_count(Integer num) {
            this.like_count = num;
            return this;
        }

        public ResponseSetLikeItemComment build() {
            checkRequiredFields();
            return new ResponseSetLikeItemComment(this);
        }
    }
}
