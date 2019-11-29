package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseFeedComment extends Message {
    public static final List<FeedComment> DEFAULT_CMT = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeedComment.class, tag = 3)
    public final List<FeedComment> cmt;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseFeedComment(String str, Integer num, List<FeedComment> list) {
        this.requestid = str;
        this.errcode = num;
        this.cmt = immutableCopyOf(list);
    }

    private ResponseFeedComment(Builder builder) {
        this(builder.requestid, builder.errcode, builder.cmt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseFeedComment)) {
            return false;
        }
        ResponseFeedComment responseFeedComment = (ResponseFeedComment) obj;
        if (!equals((Object) this.requestid, (Object) responseFeedComment.requestid) || !equals((Object) this.errcode, (Object) responseFeedComment.errcode) || !equals((List<?>) this.cmt, (List<?>) responseFeedComment.cmt)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<FeedComment> list = this.cmt;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseFeedComment> {
        public List<FeedComment> cmt;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseFeedComment responseFeedComment) {
            super(responseFeedComment);
            if (responseFeedComment != null) {
                this.requestid = responseFeedComment.requestid;
                this.errcode = responseFeedComment.errcode;
                this.cmt = ResponseFeedComment.copyOf(responseFeedComment.cmt);
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

        public Builder cmt(List<FeedComment> list) {
            this.cmt = checkForNulls(list);
            return this;
        }

        public ResponseFeedComment build() {
            checkRequiredFields();
            return new ResponseFeedComment(this);
        }
    }
}
