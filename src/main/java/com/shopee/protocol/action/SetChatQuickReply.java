package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetChatQuickReply extends Message {
    public static final List<String> DEFAULT_CONTENT = Collections.emptyList();
    public static final Boolean DEFAULT_IS_ON = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> content;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_on;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public SetChatQuickReply(String str, List<String> list, Boolean bool, String str2) {
        this.requestid = str;
        this.content = immutableCopyOf(list);
        this.is_on = bool;
        this.token = str2;
    }

    private SetChatQuickReply(Builder builder) {
        this(builder.requestid, builder.content, builder.is_on, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetChatQuickReply)) {
            return false;
        }
        SetChatQuickReply setChatQuickReply = (SetChatQuickReply) obj;
        if (!equals((Object) this.requestid, (Object) setChatQuickReply.requestid) || !equals((List<?>) this.content, (List<?>) setChatQuickReply.content) || !equals((Object) this.is_on, (Object) setChatQuickReply.is_on) || !equals((Object) this.token, (Object) setChatQuickReply.token)) {
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
        List<String> list = this.content;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.is_on;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetChatQuickReply> {
        public List<String> content;
        public Boolean is_on;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetChatQuickReply setChatQuickReply) {
            super(setChatQuickReply);
            if (setChatQuickReply != null) {
                this.requestid = setChatQuickReply.requestid;
                this.content = SetChatQuickReply.copyOf(setChatQuickReply.content);
                this.is_on = setChatQuickReply.is_on;
                this.token = setChatQuickReply.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder content(List<String> list) {
            this.content = checkForNulls(list);
            return this;
        }

        public Builder is_on(Boolean bool) {
            this.is_on = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public SetChatQuickReply build() {
            return new SetChatQuickReply(this);
        }
    }
}
