package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class MsgSend extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final Integer DEFAULT_FROM_USERID = 0;
    public static final Boolean DEFAULT_IS_NOTI = false;
    public static final Long DEFAULT_MSGID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Long DEFAULT_TO_CLIKEY = 0L;
    public static final Integer DEFAULT_TO_USERID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final f content;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer from_userid;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_noti;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long to_clikey;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer to_userid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer type;

    public MsgSend(String str, Long l, f fVar, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Long l2) {
        this.requestid = str;
        this.msgid = l;
        this.content = fVar;
        this.from_userid = num;
        this.to_userid = num2;
        this.timestamp = num3;
        this.type = num4;
        this.is_noti = bool;
        this.to_clikey = l2;
    }

    private MsgSend(Builder builder) {
        this(builder.requestid, builder.msgid, builder.content, builder.from_userid, builder.to_userid, builder.timestamp, builder.type, builder.is_noti, builder.to_clikey);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MsgSend)) {
            return false;
        }
        MsgSend msgSend = (MsgSend) obj;
        if (!equals((Object) this.requestid, (Object) msgSend.requestid) || !equals((Object) this.msgid, (Object) msgSend.msgid) || !equals((Object) this.content, (Object) msgSend.content) || !equals((Object) this.from_userid, (Object) msgSend.from_userid) || !equals((Object) this.to_userid, (Object) msgSend.to_userid) || !equals((Object) this.timestamp, (Object) msgSend.timestamp) || !equals((Object) this.type, (Object) msgSend.type) || !equals((Object) this.is_noti, (Object) msgSend.is_noti) || !equals((Object) this.to_clikey, (Object) msgSend.to_clikey)) {
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
        Boolean bool = this.is_noti;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l2 = this.to_clikey;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MsgSend> {
        public f content;
        public Integer from_userid;
        public Boolean is_noti;
        public Long msgid;
        public String requestid;
        public Integer timestamp;
        public Long to_clikey;
        public Integer to_userid;
        public Integer type;

        public Builder() {
        }

        public Builder(MsgSend msgSend) {
            super(msgSend);
            if (msgSend != null) {
                this.requestid = msgSend.requestid;
                this.msgid = msgSend.msgid;
                this.content = msgSend.content;
                this.from_userid = msgSend.from_userid;
                this.to_userid = msgSend.to_userid;
                this.timestamp = msgSend.timestamp;
                this.type = msgSend.type;
                this.is_noti = msgSend.is_noti;
                this.to_clikey = msgSend.to_clikey;
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

        public Builder is_noti(Boolean bool) {
            this.is_noti = bool;
            return this;
        }

        public Builder to_clikey(Long l) {
            this.to_clikey = l;
            return this;
        }

        public MsgSend build() {
            checkRequiredFields();
            return new MsgSend(this);
        }
    }
}
