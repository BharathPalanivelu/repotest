package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AddFeedComment extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final FeedComment cmt;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public AddFeedComment(String str, String str2, FeedComment feedComment) {
        this.requestid = str;
        this.token = str2;
        this.cmt = feedComment;
    }

    private AddFeedComment(Builder builder) {
        this(builder.requestid, builder.token, builder.cmt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddFeedComment)) {
            return false;
        }
        AddFeedComment addFeedComment = (AddFeedComment) obj;
        if (!equals((Object) this.requestid, (Object) addFeedComment.requestid) || !equals((Object) this.token, (Object) addFeedComment.token) || !equals((Object) this.cmt, (Object) addFeedComment.cmt)) {
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
        FeedComment feedComment = this.cmt;
        if (feedComment != null) {
            i2 = feedComment.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AddFeedComment> {
        public FeedComment cmt;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(AddFeedComment addFeedComment) {
            super(addFeedComment);
            if (addFeedComment != null) {
                this.requestid = addFeedComment.requestid;
                this.token = addFeedComment.token;
                this.cmt = addFeedComment.cmt;
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

        public Builder cmt(FeedComment feedComment) {
            this.cmt = feedComment;
            return this;
        }

        public AddFeedComment build() {
            return new AddFeedComment(this);
        }
    }
}
