package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatTextInfo extends Message {
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 2)
    public final ChatTextTranslated translated_text;

    public ChatTextInfo(String str, ChatTextTranslated chatTextTranslated) {
        this.text = str;
        this.translated_text = chatTextTranslated;
    }

    private ChatTextInfo(Builder builder) {
        this(builder.text, builder.translated_text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatTextInfo)) {
            return false;
        }
        ChatTextInfo chatTextInfo = (ChatTextInfo) obj;
        if (!equals((Object) this.text, (Object) chatTextInfo.text) || !equals((Object) this.translated_text, (Object) chatTextInfo.translated_text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.text;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        ChatTextTranslated chatTextTranslated = this.translated_text;
        if (chatTextTranslated != null) {
            i2 = chatTextTranslated.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatTextInfo> {
        public String text;
        public ChatTextTranslated translated_text;

        public Builder() {
        }

        public Builder(ChatTextInfo chatTextInfo) {
            super(chatTextInfo);
            if (chatTextInfo != null) {
                this.text = chatTextInfo.text;
                this.translated_text = chatTextInfo.translated_text;
            }
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder translated_text(ChatTextTranslated chatTextTranslated) {
            this.translated_text = chatTextTranslated;
            return this;
        }

        public ChatTextInfo build() {
            checkRequiredFields();
            return new ChatTextInfo(this);
        }
    }
}
