package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatCountsResponse extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TOTAL_UNREAD_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer total_unread_count;

    public ChatCountsResponse(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.total_unread_count = num2;
    }

    private ChatCountsResponse(Builder builder) {
        this(builder.requestid, builder.errcode, builder.total_unread_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatCountsResponse)) {
            return false;
        }
        ChatCountsResponse chatCountsResponse = (ChatCountsResponse) obj;
        if (!equals((Object) this.requestid, (Object) chatCountsResponse.requestid) || !equals((Object) this.errcode, (Object) chatCountsResponse.errcode) || !equals((Object) this.total_unread_count, (Object) chatCountsResponse.total_unread_count)) {
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
        Integer num2 = this.total_unread_count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatCountsResponse> {
        public Integer errcode;
        public String requestid;
        public Integer total_unread_count;

        public Builder() {
        }

        public Builder(ChatCountsResponse chatCountsResponse) {
            super(chatCountsResponse);
            if (chatCountsResponse != null) {
                this.requestid = chatCountsResponse.requestid;
                this.errcode = chatCountsResponse.errcode;
                this.total_unread_count = chatCountsResponse.total_unread_count;
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

        public Builder total_unread_count(Integer num) {
            this.total_unread_count = num;
            return this;
        }

        public ChatCountsResponse build() {
            checkRequiredFields();
            return new ChatCountsResponse(this);
        }
    }
}
