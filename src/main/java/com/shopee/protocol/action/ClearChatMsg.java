package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ClearChatMsg extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ClearChatMsg(String str, String str2, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.userid = num;
    }

    private ClearChatMsg(Builder builder) {
        this(builder.requestid, builder.token, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClearChatMsg)) {
            return false;
        }
        ClearChatMsg clearChatMsg = (ClearChatMsg) obj;
        if (!equals((Object) this.requestid, (Object) clearChatMsg.requestid) || !equals((Object) this.token, (Object) clearChatMsg.token) || !equals((Object) this.userid, (Object) clearChatMsg.userid)) {
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
        Integer num = this.userid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ClearChatMsg> {
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(ClearChatMsg clearChatMsg) {
            super(clearChatMsg);
            if (clearChatMsg != null) {
                this.requestid = clearChatMsg.requestid;
                this.token = clearChatMsg.token;
                this.userid = clearChatMsg.userid;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public ClearChatMsg build() {
            return new ClearChatMsg(this);
        }
    }
}
