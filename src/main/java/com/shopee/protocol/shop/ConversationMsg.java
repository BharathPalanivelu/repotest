package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConversationMsg extends Message {
    public static final Long DEFAULT_CHATID = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_OPT = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer opt;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ConversationMsg(Long l, Integer num, Long l2, Integer num2, Integer num3, Integer num4) {
        this.chatid = l;
        this.userid = num;
        this.msgid = l2;
        this.status = num2;
        this.ctime = num3;
        this.opt = num4;
    }

    private ConversationMsg(Builder builder) {
        this(builder.chatid, builder.userid, builder.msgid, builder.status, builder.ctime, builder.opt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConversationMsg)) {
            return false;
        }
        ConversationMsg conversationMsg = (ConversationMsg) obj;
        if (!equals((Object) this.chatid, (Object) conversationMsg.chatid) || !equals((Object) this.userid, (Object) conversationMsg.userid) || !equals((Object) this.msgid, (Object) conversationMsg.msgid) || !equals((Object) this.status, (Object) conversationMsg.status) || !equals((Object) this.ctime, (Object) conversationMsg.ctime) || !equals((Object) this.opt, (Object) conversationMsg.opt)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.chatid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.msgid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.opt;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConversationMsg> {
        public Long chatid;
        public Integer ctime;
        public Long msgid;
        public Integer opt;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ConversationMsg conversationMsg) {
            super(conversationMsg);
            if (conversationMsg != null) {
                this.chatid = conversationMsg.chatid;
                this.userid = conversationMsg.userid;
                this.msgid = conversationMsg.msgid;
                this.status = conversationMsg.status;
                this.ctime = conversationMsg.ctime;
                this.opt = conversationMsg.opt;
            }
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder msgid(Long l) {
            this.msgid = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder opt(Integer num) {
            this.opt = num;
            return this;
        }

        public ConversationMsg build() {
            return new ConversationMsg(this);
        }
    }
}
