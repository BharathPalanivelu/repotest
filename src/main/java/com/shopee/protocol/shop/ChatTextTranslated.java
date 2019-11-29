package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatTextTranslated extends Message {
    public static final String DEFAULT_SOURCE = "";
    public static final String DEFAULT_TRANSLATED_LANGUAGE = "";
    public static final String DEFAULT_TRANSLATED_TEXT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String translated_language;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String translated_text;

    public ChatTextTranslated(String str, String str2, String str3) {
        this.translated_text = str;
        this.translated_language = str2;
        this.source = str3;
    }

    private ChatTextTranslated(Builder builder) {
        this(builder.translated_text, builder.translated_language, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatTextTranslated)) {
            return false;
        }
        ChatTextTranslated chatTextTranslated = (ChatTextTranslated) obj;
        if (!equals((Object) this.translated_text, (Object) chatTextTranslated.translated_text) || !equals((Object) this.translated_language, (Object) chatTextTranslated.translated_language) || !equals((Object) this.source, (Object) chatTextTranslated.source)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.translated_text;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.translated_language;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.source;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatTextTranslated> {
        public String source;
        public String translated_language;
        public String translated_text;

        public Builder() {
        }

        public Builder(ChatTextTranslated chatTextTranslated) {
            super(chatTextTranslated);
            if (chatTextTranslated != null) {
                this.translated_text = chatTextTranslated.translated_text;
                this.translated_language = chatTextTranslated.translated_language;
                this.source = chatTextTranslated.source;
            }
        }

        public Builder translated_text(String str) {
            this.translated_text = str;
            return this;
        }

        public Builder translated_language(String str) {
            this.translated_language = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public ChatTextTranslated build() {
            return new ChatTextTranslated(this);
        }
    }
}
