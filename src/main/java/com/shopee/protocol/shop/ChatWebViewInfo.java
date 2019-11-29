package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatWebViewInfo extends Message {
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String url;

    public ChatWebViewInfo(String str) {
        this.url = str;
    }

    private ChatWebViewInfo(Builder builder) {
        this(builder.url);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatWebViewInfo)) {
            return false;
        }
        return equals((Object) this.url, (Object) ((ChatWebViewInfo) obj).url);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.url;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ChatWebViewInfo> {
        public String url;

        public Builder() {
        }

        public Builder(ChatWebViewInfo chatWebViewInfo) {
            super(chatWebViewInfo);
            if (chatWebViewInfo != null) {
                this.url = chatWebViewInfo.url;
            }
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public ChatWebViewInfo build() {
            return new ChatWebViewInfo(this);
        }
    }
}
