package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetChatLastRead extends Message {
    public static final Long DEFAULT_MSGID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public SetChatLastRead(String str, Integer num, Long l, String str2) {
        this.requestid = str;
        this.userid = num;
        this.msgid = l;
        this.token = str2;
    }

    private SetChatLastRead(Builder builder) {
        this(builder.requestid, builder.userid, builder.msgid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetChatLastRead)) {
            return false;
        }
        SetChatLastRead setChatLastRead = (SetChatLastRead) obj;
        if (!equals((Object) this.requestid, (Object) setChatLastRead.requestid) || !equals((Object) this.userid, (Object) setChatLastRead.userid) || !equals((Object) this.msgid, (Object) setChatLastRead.msgid) || !equals((Object) this.token, (Object) setChatLastRead.token)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.msgid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetChatLastRead> {
        public Long msgid;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(SetChatLastRead setChatLastRead) {
            super(setChatLastRead);
            if (setChatLastRead != null) {
                this.requestid = setChatLastRead.requestid;
                this.userid = setChatLastRead.userid;
                this.msgid = setChatLastRead.msgid;
                this.token = setChatLastRead.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder msgid(Long l) {
            this.msgid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public SetChatLastRead build() {
            return new SetChatLastRead(this);
        }
    }
}
