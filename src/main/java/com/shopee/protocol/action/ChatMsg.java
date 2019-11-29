package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ChatMsg extends Message {
    public static final Long DEFAULT_CHATID = 0L;
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final Integer DEFAULT_FROM_USERID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_MSG_SRC = 0;
    public static final Integer DEFAULT_OPT = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PCHATID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SELLER_USERID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Boolean DEFAULT_SUPPORT_FAQ = false;
    public static final String DEFAULT_TEXT_CONTENT = "";
    public static final String DEFAULT_TEXT_MSGID = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TO_USERID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f content;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer from_userid;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer msg_src;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer opt;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer seller_userid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 20, type = Message.Datatype.BOOL)
    public final Boolean support_faq;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String text_content;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String text_msgid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer to_userid;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer type;

    public ChatMsg(String str, Long l, f fVar, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l2, Long l3, String str2, Long l4, Long l5, Long l6, String str3, Integer num7, String str4, Integer num8, Boolean bool) {
        this.requestid = str;
        this.msgid = l;
        this.content = fVar;
        this.from_userid = num;
        this.to_userid = num2;
        this.timestamp = num3;
        this.type = num4;
        this.seller_userid = num5;
        this.shopid = num6;
        this.itemid = l2;
        this.chatid = l3;
        this.token = str2;
        this.orderid = l4;
        this.modelid = l5;
        this.pchatid = l6;
        this.text_content = str3;
        this.opt = num7;
        this.text_msgid = str4;
        this.msg_src = num8;
        this.support_faq = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ChatMsg(com.shopee.protocol.action.ChatMsg.Builder r24) {
        /*
            r23 = this;
            r0 = r24
            r1 = r23
            java.lang.String r2 = r0.requestid
            java.lang.Long r3 = r0.msgid
            e.f r4 = r0.content
            java.lang.Integer r5 = r0.from_userid
            java.lang.Integer r6 = r0.to_userid
            java.lang.Integer r7 = r0.timestamp
            java.lang.Integer r8 = r0.type
            java.lang.Integer r9 = r0.seller_userid
            java.lang.Integer r10 = r0.shopid
            java.lang.Long r11 = r0.itemid
            java.lang.Long r12 = r0.chatid
            java.lang.String r13 = r0.token
            java.lang.Long r14 = r0.orderid
            java.lang.Long r15 = r0.modelid
            r22 = r1
            java.lang.Long r1 = r0.pchatid
            r16 = r1
            java.lang.String r1 = r0.text_content
            r17 = r1
            java.lang.Integer r1 = r0.opt
            r18 = r1
            java.lang.String r1 = r0.text_msgid
            r19 = r1
            java.lang.Integer r1 = r0.msg_src
            r20 = r1
            java.lang.Boolean r1 = r0.support_faq
            r21 = r1
            r1 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r23.setBuilder(r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.ChatMsg.<init>(com.shopee.protocol.action.ChatMsg$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsg)) {
            return false;
        }
        ChatMsg chatMsg = (ChatMsg) obj;
        if (!equals((Object) this.requestid, (Object) chatMsg.requestid) || !equals((Object) this.msgid, (Object) chatMsg.msgid) || !equals((Object) this.content, (Object) chatMsg.content) || !equals((Object) this.from_userid, (Object) chatMsg.from_userid) || !equals((Object) this.to_userid, (Object) chatMsg.to_userid) || !equals((Object) this.timestamp, (Object) chatMsg.timestamp) || !equals((Object) this.type, (Object) chatMsg.type) || !equals((Object) this.seller_userid, (Object) chatMsg.seller_userid) || !equals((Object) this.shopid, (Object) chatMsg.shopid) || !equals((Object) this.itemid, (Object) chatMsg.itemid) || !equals((Object) this.chatid, (Object) chatMsg.chatid) || !equals((Object) this.token, (Object) chatMsg.token) || !equals((Object) this.orderid, (Object) chatMsg.orderid) || !equals((Object) this.modelid, (Object) chatMsg.modelid) || !equals((Object) this.pchatid, (Object) chatMsg.pchatid) || !equals((Object) this.text_content, (Object) chatMsg.text_content) || !equals((Object) this.opt, (Object) chatMsg.opt) || !equals((Object) this.text_msgid, (Object) chatMsg.text_msgid) || !equals((Object) this.msg_src, (Object) chatMsg.msg_src) || !equals((Object) this.support_faq, (Object) chatMsg.support_faq)) {
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
        Long l = this.msgid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        f fVar = this.content;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.from_userid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.to_userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.timestamp;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.type;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.seller_userid;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.shopid;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.chatid;
        int hashCode11 = (hashCode10 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l4 = this.orderid;
        int hashCode13 = (hashCode12 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.modelid;
        int hashCode14 = (hashCode13 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.pchatid;
        int hashCode15 = (hashCode14 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str3 = this.text_content;
        int hashCode16 = (hashCode15 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num7 = this.opt;
        int hashCode17 = (hashCode16 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str4 = this.text_msgid;
        int hashCode18 = (hashCode17 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num8 = this.msg_src;
        int hashCode19 = (hashCode18 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Boolean bool = this.support_faq;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode19 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatMsg> {
        public Long chatid;
        public f content;
        public Integer from_userid;
        public Long itemid;
        public Long modelid;
        public Integer msg_src;
        public Long msgid;
        public Integer opt;
        public Long orderid;
        public Long pchatid;
        public String requestid;
        public Integer seller_userid;
        public Integer shopid;
        public Boolean support_faq;
        public String text_content;
        public String text_msgid;
        public Integer timestamp;
        public Integer to_userid;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(ChatMsg chatMsg) {
            super(chatMsg);
            if (chatMsg != null) {
                this.requestid = chatMsg.requestid;
                this.msgid = chatMsg.msgid;
                this.content = chatMsg.content;
                this.from_userid = chatMsg.from_userid;
                this.to_userid = chatMsg.to_userid;
                this.timestamp = chatMsg.timestamp;
                this.type = chatMsg.type;
                this.seller_userid = chatMsg.seller_userid;
                this.shopid = chatMsg.shopid;
                this.itemid = chatMsg.itemid;
                this.chatid = chatMsg.chatid;
                this.token = chatMsg.token;
                this.orderid = chatMsg.orderid;
                this.modelid = chatMsg.modelid;
                this.pchatid = chatMsg.pchatid;
                this.text_content = chatMsg.text_content;
                this.opt = chatMsg.opt;
                this.text_msgid = chatMsg.text_msgid;
                this.msg_src = chatMsg.msg_src;
                this.support_faq = chatMsg.support_faq;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder msgid(Long l) {
            this.msgid = l;
            return this;
        }

        public Builder content(f fVar) {
            this.content = fVar;
            return this;
        }

        public Builder from_userid(Integer num) {
            this.from_userid = num;
            return this;
        }

        public Builder to_userid(Integer num) {
            this.to_userid = num;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder seller_userid(Integer num) {
            this.seller_userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
            return this;
        }

        public Builder text_content(String str) {
            this.text_content = str;
            return this;
        }

        public Builder opt(Integer num) {
            this.opt = num;
            return this;
        }

        public Builder text_msgid(String str) {
            this.text_msgid = str;
            return this;
        }

        public Builder msg_src(Integer num) {
            this.msg_src = num;
            return this;
        }

        public Builder support_faq(Boolean bool) {
            this.support_faq = bool;
            return this;
        }

        public ChatMsg build() {
            return new ChatMsg(this);
        }
    }
}
