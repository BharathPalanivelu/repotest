package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MsgAck extends Message {
    public static final Long DEFAULT_CHATID = 0L;
    public static final Long DEFAULT_MSGID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public MsgAck(String str, Long l, Long l2, Integer num) {
        this.requestid = str;
        this.msgid = l;
        this.chatid = l2;
        this.userid = num;
    }

    private MsgAck(Builder builder) {
        this(builder.requestid, builder.msgid, builder.chatid, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MsgAck)) {
            return false;
        }
        MsgAck msgAck = (MsgAck) obj;
        if (!equals((Object) this.requestid, (Object) msgAck.requestid) || !equals((Object) this.msgid, (Object) msgAck.msgid) || !equals((Object) this.chatid, (Object) msgAck.chatid) || !equals((Object) this.userid, (Object) msgAck.userid)) {
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
        Long l2 = this.chatid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.userid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MsgAck> {
        public Long chatid;
        public Long msgid;
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(MsgAck msgAck) {
            super(msgAck);
            if (msgAck != null) {
                this.requestid = msgAck.requestid;
                this.msgid = msgAck.msgid;
                this.chatid = msgAck.chatid;
                this.userid = msgAck.userid;
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

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public MsgAck build() {
            checkRequiredFields();
            return new MsgAck(this);
        }
    }
}
