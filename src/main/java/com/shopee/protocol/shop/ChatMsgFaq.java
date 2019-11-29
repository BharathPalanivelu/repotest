package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ChatMsgFaq extends Message {
    public static final List<ChatMsgFaqCategory> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final Long DEFAULT_FAQ_ID = 0L;
    public static final String DEFAULT_OPENING = "";
    public static final Long DEFAULT_SHOPID = 0L;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ChatMsgFaqCategory.class, tag = 5)
    public final List<ChatMsgFaqCategory> categories;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long faq_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String opening;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long shopid;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long userid;

    public ChatMsgFaq(Long l, Long l2, Long l3, String str, List<ChatMsgFaqCategory> list) {
        this.userid = l;
        this.shopid = l2;
        this.faq_id = l3;
        this.opening = str;
        this.categories = immutableCopyOf(list);
    }

    private ChatMsgFaq(Builder builder) {
        this(builder.userid, builder.shopid, builder.faq_id, builder.opening, builder.categories);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsgFaq)) {
            return false;
        }
        ChatMsgFaq chatMsgFaq = (ChatMsgFaq) obj;
        if (!equals((Object) this.userid, (Object) chatMsgFaq.userid) || !equals((Object) this.shopid, (Object) chatMsgFaq.shopid) || !equals((Object) this.faq_id, (Object) chatMsgFaq.faq_id) || !equals((Object) this.opening, (Object) chatMsgFaq.opening) || !equals((List<?>) this.categories, (List<?>) chatMsgFaq.categories)) {
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
        String str = this.opening;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<ChatMsgFaqCategory> list = this.categories;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<ChatMsgFaq> {
        public List<ChatMsgFaqCategory> categories;
        public Long faq_id;
        public String opening;
        public Long shopid;
        public Long userid;

        public Builder() {
        }

        public Builder(ChatMsgFaq chatMsgFaq) {
            super(chatMsgFaq);
            if (chatMsgFaq != null) {
                this.userid = chatMsgFaq.userid;
                this.shopid = chatMsgFaq.shopid;
                this.faq_id = chatMsgFaq.faq_id;
                this.opening = chatMsgFaq.opening;
                this.categories = ChatMsgFaq.copyOf(chatMsgFaq.categories);
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

        public Builder opening(String str) {
            this.opening = str;
            return this;
        }

        public Builder categories(List<ChatMsgFaqCategory> list) {
            this.categories = checkForNulls(list);
            return this;
        }

        public ChatMsgFaq build() {
            return new ChatMsgFaq(this);
        }
    }
}
