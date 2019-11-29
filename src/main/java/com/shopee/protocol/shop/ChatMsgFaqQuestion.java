package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatMsgFaqQuestion extends Message {
    public static final Long DEFAULT_FAQ_ID = 0L;
    public static final Long DEFAULT_QUESTION_ID = 0L;
    public static final Long DEFAULT_SHOPID = 0L;
    public static final String DEFAULT_TEXT = "";
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long faq_id;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long question_id;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long shopid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long userid;

    public ChatMsgFaqQuestion(Long l, Long l2, Long l3, Long l4, String str) {
        this.userid = l;
        this.shopid = l2;
        this.faq_id = l3;
        this.question_id = l4;
        this.text = str;
    }

    private ChatMsgFaqQuestion(Builder builder) {
        this(builder.userid, builder.shopid, builder.faq_id, builder.question_id, builder.text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsgFaqQuestion)) {
            return false;
        }
        ChatMsgFaqQuestion chatMsgFaqQuestion = (ChatMsgFaqQuestion) obj;
        if (!equals((Object) this.userid, (Object) chatMsgFaqQuestion.userid) || !equals((Object) this.shopid, (Object) chatMsgFaqQuestion.shopid) || !equals((Object) this.faq_id, (Object) chatMsgFaqQuestion.faq_id) || !equals((Object) this.question_id, (Object) chatMsgFaqQuestion.question_id) || !equals((Object) this.text, (Object) chatMsgFaqQuestion.text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.userid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.shopid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.faq_id;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.question_id;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str = this.text;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatMsgFaqQuestion> {
        public Long faq_id;
        public Long question_id;
        public Long shopid;
        public String text;
        public Long userid;

        public Builder() {
        }

        public Builder(ChatMsgFaqQuestion chatMsgFaqQuestion) {
            super(chatMsgFaqQuestion);
            if (chatMsgFaqQuestion != null) {
                this.userid = chatMsgFaqQuestion.userid;
                this.shopid = chatMsgFaqQuestion.shopid;
                this.faq_id = chatMsgFaqQuestion.faq_id;
                this.question_id = chatMsgFaqQuestion.question_id;
                this.text = chatMsgFaqQuestion.text;
            }
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder shopid(Long l) {
            this.shopid = l;
            return this;
        }

        public Builder faq_id(Long l) {
            this.faq_id = l;
            return this;
        }

        public Builder question_id(Long l) {
            this.question_id = l;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public ChatMsgFaqQuestion build() {
            return new ChatMsgFaqQuestion(this);
        }
    }
}
