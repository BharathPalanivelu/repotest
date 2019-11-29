package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetChatMsgid extends Message {
    public static final Long DEFAULT_CHATID = 0L;
    public static final Long DEFAULT_CURSOR = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long cursor;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetChatMsgid(String str, Long l, Long l2, Integer num, Integer num2, String str2) {
        this.requestid = str;
        this.chatid = l;
        this.cursor = l2;
        this.limit = num;
        this.userid = num2;
        this.token = str2;
    }

    private GetChatMsgid(Builder builder) {
        this(builder.requestid, builder.chatid, builder.cursor, builder.limit, builder.userid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetChatMsgid)) {
            return false;
        }
        GetChatMsgid getChatMsgid = (GetChatMsgid) obj;
        if (!equals((Object) this.requestid, (Object) getChatMsgid.requestid) || !equals((Object) this.chatid, (Object) getChatMsgid.chatid) || !equals((Object) this.cursor, (Object) getChatMsgid.cursor) || !equals((Object) this.limit, (Object) getChatMsgid.limit) || !equals((Object) this.userid, (Object) getChatMsgid.userid) || !equals((Object) this.token, (Object) getChatMsgid.token)) {
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
        Long l = this.chatid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.cursor;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.limit;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetChatMsgid> {
        public Long chatid;
        public Long cursor;
        public Integer limit;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetChatMsgid getChatMsgid) {
            super(getChatMsgid);
            if (getChatMsgid != null) {
                this.requestid = getChatMsgid.requestid;
                this.chatid = getChatMsgid.chatid;
                this.cursor = getChatMsgid.cursor;
                this.limit = getChatMsgid.limit;
                this.userid = getChatMsgid.userid;
                this.token = getChatMsgid.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder cursor(Long l) {
            this.cursor = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetChatMsgid build() {
            checkRequiredFields();
            return new GetChatMsgid(this);
        }
    }
}
