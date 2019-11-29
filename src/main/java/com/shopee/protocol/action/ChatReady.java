package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatReady extends Message {
    public static final Integer DEFAULT_INAPP_TIMESTAMP = 0;
    public static final Long DEFAULT_LAST_MSGID = 0L;
    public static final Boolean DEFAULT_NO_NEED_CHAT = false;
    public static final Boolean DEFAULT_NO_NEED_NOTI = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer inapp_timestamp;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long last_msgid;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean no_need_chat;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean no_need_noti;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;

    public ChatReady(String str, Integer num, Long l, Boolean bool, Boolean bool2, String str2) {
        this.requestid = str;
        this.inapp_timestamp = num;
        this.last_msgid = l;
        this.no_need_chat = bool;
        this.no_need_noti = bool2;
        this.token = str2;
    }

    private ChatReady(Builder builder) {
        this(builder.requestid, builder.inapp_timestamp, builder.last_msgid, builder.no_need_chat, builder.no_need_noti, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatReady)) {
            return false;
        }
        ChatReady chatReady = (ChatReady) obj;
        if (!equals((Object) this.requestid, (Object) chatReady.requestid) || !equals((Object) this.inapp_timestamp, (Object) chatReady.inapp_timestamp) || !equals((Object) this.last_msgid, (Object) chatReady.last_msgid) || !equals((Object) this.no_need_chat, (Object) chatReady.no_need_chat) || !equals((Object) this.no_need_noti, (Object) chatReady.no_need_noti) || !equals((Object) this.token, (Object) chatReady.token)) {
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
        Integer num = this.inapp_timestamp;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.last_msgid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.no_need_chat;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.no_need_noti;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatReady> {
        public Integer inapp_timestamp;
        public Long last_msgid;
        public Boolean no_need_chat;
        public Boolean no_need_noti;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ChatReady chatReady) {
            super(chatReady);
            if (chatReady != null) {
                this.requestid = chatReady.requestid;
                this.inapp_timestamp = chatReady.inapp_timestamp;
                this.last_msgid = chatReady.last_msgid;
                this.no_need_chat = chatReady.no_need_chat;
                this.no_need_noti = chatReady.no_need_noti;
                this.token = chatReady.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder inapp_timestamp(Integer num) {
            this.inapp_timestamp = num;
            return this;
        }

        public Builder last_msgid(Long l) {
            this.last_msgid = l;
            return this;
        }

        public Builder no_need_chat(Boolean bool) {
            this.no_need_chat = bool;
            return this;
        }

        public Builder no_need_noti(Boolean bool) {
            this.no_need_noti = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public ChatReady build() {
            return new ChatReady(this);
        }
    }
}
