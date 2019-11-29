package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatMsgLiveAgent extends Message {
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String text;

    public ChatMsgLiveAgent(String str) {
        this.text = str;
    }

    private ChatMsgLiveAgent(Builder builder) {
        this(builder.text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsgLiveAgent)) {
            return false;
        }
        return equals((Object) this.text, (Object) ((ChatMsgLiveAgent) obj).text);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.text;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ChatMsgLiveAgent> {
        public String text;

        public Builder() {
        }

        public Builder(ChatMsgLiveAgent chatMsgLiveAgent) {
            super(chatMsgLiveAgent);
            if (chatMsgLiveAgent != null) {
                this.text = chatMsgLiveAgent.text;
            }
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public ChatMsgLiveAgent build() {
            return new ChatMsgLiveAgent(this);
        }
    }
}
