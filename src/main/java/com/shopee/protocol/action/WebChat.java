package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WebChat extends Message {
    public static final Integer DEFAULT_CLEAR_TIME = 0;
    public static final Long DEFAULT_LAST_MSGID = 0L;
    public static final Integer DEFAULT_LAST_MSG_TIME = 0;
    public static final Long DEFAULT_LAST_READ = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PORTRAIT = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TEXT_LAST_READ = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_USERNAME = "";
    public static final Integer DEFAULT_USER_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer clear_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer last_msg_time;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long last_msgid;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long last_read;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String text_last_read;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer user_status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String username;

    public WebChat(Integer num, Integer num2, Long l, Integer num3, Integer num4, Long l2, Integer num5, String str, String str2, String str3, Integer num6) {
        this.userid = num;
        this.shopid = num2;
        this.last_msgid = l;
        this.last_msg_time = num3;
        this.clear_time = num4;
        this.last_read = l2;
        this.mtime = num5;
        this.text_last_read = str;
        this.username = str2;
        this.portrait = str3;
        this.user_status = num6;
    }

    private WebChat(Builder builder) {
        this(builder.userid, builder.shopid, builder.last_msgid, builder.last_msg_time, builder.clear_time, builder.last_read, builder.mtime, builder.text_last_read, builder.username, builder.portrait, builder.user_status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebChat)) {
            return false;
        }
        WebChat webChat = (WebChat) obj;
        if (!equals((Object) this.userid, (Object) webChat.userid) || !equals((Object) this.shopid, (Object) webChat.shopid) || !equals((Object) this.last_msgid, (Object) webChat.last_msgid) || !equals((Object) this.last_msg_time, (Object) webChat.last_msg_time) || !equals((Object) this.clear_time, (Object) webChat.clear_time) || !equals((Object) this.last_read, (Object) webChat.last_read) || !equals((Object) this.mtime, (Object) webChat.mtime) || !equals((Object) this.text_last_read, (Object) webChat.text_last_read) || !equals((Object) this.username, (Object) webChat.username) || !equals((Object) this.portrait, (Object) webChat.portrait) || !equals((Object) this.user_status, (Object) webChat.user_status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.last_msgid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.last_msg_time;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.clear_time;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.last_read;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str = this.text_last_read;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.username;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.portrait;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num6 = this.user_status;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WebChat> {
        public Integer clear_time;
        public Integer last_msg_time;
        public Long last_msgid;
        public Long last_read;
        public Integer mtime;
        public String portrait;
        public Integer shopid;
        public String text_last_read;
        public Integer user_status;
        public Integer userid;
        public String username;

        public Builder() {
        }

        public Builder(WebChat webChat) {
            super(webChat);
            if (webChat != null) {
                this.userid = webChat.userid;
                this.shopid = webChat.shopid;
                this.last_msgid = webChat.last_msgid;
                this.last_msg_time = webChat.last_msg_time;
                this.clear_time = webChat.clear_time;
                this.last_read = webChat.last_read;
                this.mtime = webChat.mtime;
                this.text_last_read = webChat.text_last_read;
                this.username = webChat.username;
                this.portrait = webChat.portrait;
                this.user_status = webChat.user_status;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder last_msgid(Long l) {
            this.last_msgid = l;
            return this;
        }

        public Builder last_msg_time(Integer num) {
            this.last_msg_time = num;
            return this;
        }

        public Builder clear_time(Integer num) {
            this.clear_time = num;
            return this;
        }

        public Builder last_read(Long l) {
            this.last_read = l;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder text_last_read(String str) {
            this.text_last_read = str;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public Builder user_status(Integer num) {
            this.user_status = num;
            return this;
        }

        public WebChat build() {
            return new WebChat(this);
        }
    }
}
