package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConvMsg extends Message {
    public static final Long DEFAULT_CHATID = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_OPT = 0;
    public static final Long DEFAULT_PCHATID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer opt;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public ConvMsg(Long l, Long l2, Integer num, Long l3, Integer num2, Integer num3, Integer num4) {
        this.pchatid = l;
        this.chatid = l2;
        this.userid = num;
        this.msgid = l3;
        this.status = num2;
        this.ctime = num3;
        this.opt = num4;
    }

    private ConvMsg(Builder builder) {
        this(builder.pchatid, builder.chatid, builder.userid, builder.msgid, builder.status, builder.ctime, builder.opt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConvMsg)) {
            return false;
        }
        ConvMsg convMsg = (ConvMsg) obj;
        if (!equals((Object) this.pchatid, (Object) convMsg.pchatid) || !equals((Object) this.chatid, (Object) convMsg.chatid) || !equals((Object) this.userid, (Object) convMsg.userid) || !equals((Object) this.msgid, (Object) convMsg.msgid) || !equals((Object) this.status, (Object) convMsg.status) || !equals((Object) this.ctime, (Object) convMsg.ctime) || !equals((Object) this.opt, (Object) convMsg.opt)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.pchatid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.chatid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.msgid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.opt;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConvMsg> {
        public Long chatid;
        public Integer ctime;
        public Long msgid;
        public Integer opt;
        public Long pchatid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ConvMsg convMsg) {
            super(convMsg);
            if (convMsg != null) {
                this.pchatid = convMsg.pchatid;
                this.chatid = convMsg.chatid;
                this.userid = convMsg.userid;
                this.msgid = convMsg.msgid;
                this.status = convMsg.status;
                this.ctime = convMsg.ctime;
                this.opt = convMsg.opt;
            }
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
            return this;
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

        public ConvMsg build() {
            return new ConvMsg(this);
        }
    }
}
