package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ChatMsgFaqCategory extends Message {
    public static final List<ChatMsgFaqEntry> DEFAULT_QUESTIONS = Collections.emptyList();
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ChatMsgFaqEntry.class, tag = 2)
    public final List<ChatMsgFaqEntry> questions;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;

    public ChatMsgFaqCategory(String str, List<ChatMsgFaqEntry> list) {
        this.title = str;
        this.questions = immutableCopyOf(list);
    }

    private ChatMsgFaqCategory(Builder builder) {
        this(builder.title, builder.questions);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsgFaqCategory)) {
            return false;
        }
        ChatMsgFaqCategory chatMsgFaqCategory = (ChatMsgFaqCategory) obj;
        if (!equals((Object) this.title, (Object) chatMsgFaqCategory.title) || !equals((List<?>) this.questions, (List<?>) chatMsgFaqCategory.questions)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<ChatMsgFaqEntry> list = this.questions;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ChatMsgFaqCategory> {
        public List<ChatMsgFaqEntry> questions;
        public String title;

        public Builder() {
        }

        public Builder(ChatMsgFaqCategory chatMsgFaqCategory) {
            super(chatMsgFaqCategory);
            if (chatMsgFaqCategory != null) {
                this.title = chatMsgFaqCategory.title;
                this.questions = ChatMsgFaqCategory.copyOf(chatMsgFaqCategory.questions);
            }
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder questions(List<ChatMsgFaqEntry> list) {
            this.questions = checkForNulls(list);
            return this;
        }

        public ChatMsgFaqCategory build() {
            return new ChatMsgFaqCategory(this);
        }
    }
}
