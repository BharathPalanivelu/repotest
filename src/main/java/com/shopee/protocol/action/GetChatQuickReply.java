package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetChatQuickReply extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetChatQuickReply(String str, String str2) {
        this.requestid = str;
        this.token = str2;
    }

    private GetChatQuickReply(Builder builder) {
        this(builder.requestid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetChatQuickReply)) {
            return false;
        }
        GetChatQuickReply getChatQuickReply = (GetChatQuickReply) obj;
        if (!equals((Object) this.requestid, (Object) getChatQuickReply.requestid) || !equals((Object) this.token, (Object) getChatQuickReply.token)) {
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
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetChatQuickReply> {
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetChatQuickReply getChatQuickReply) {
            super(getChatQuickReply);
            if (getChatQuickReply != null) {
                this.requestid = getChatQuickReply.requestid;
                this.token = getChatQuickReply.token;
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

        public GetChatQuickReply build() {
            return new GetChatQuickReply(this);
        }
    }
}
